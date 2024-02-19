package com.kitapyurdu.payment.service.impl;
import com.hazelcast.core.HazelcastInstance;
import com.kitapyurdu.payment.feignApi.BasketFeignCallableApi;
import com.kitapyurdu.payment.dto.BasketDto;
import com.kitapyurdu.payment.dto.DoPayDto;
import com.kitapyurdu.payment.entity.Transaction;
import com.kitapyurdu.payment.mapper.PaymentMapper;
import com.kitapyurdu.payment.response.*;

import com.kitapyurdu.payment.repository.PaymentRepository;
import com.kitapyurdu.payment.response.BasketResponse;

import com.kitapyurdu.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentMapper paymentMapper;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    public Map<String, Transaction> transactionMap;
    private final HazelcastInstance hazelcastInstance;
    @Autowired
    BasketFeignCallableApi basketFeignCallableApi;

    public PaymentServiceImpl(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public BasketResponse sendRequestBasketService(int basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/getBasket/"+basketId,BasketResponse.class);
    }

    public BasketResponse sendRequestUpdateBasket(BasketDto basketDto){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/updateBasket"+basketDto,BasketResponse.class);
    }

    public TransferResponse sendRequestTransferService(int basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:9116/transfer/feedBack"+ basketId ,TransferResponse.class);
    }

    public PaymentResponse doPay(DoPayDto doPay) {
        Meta meta = new Meta();
        meta.errorCode = 200;
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.meta = meta;
        BasketResponse result = sendRequestBasketService(doPay.basketId);
        if (doPay.success) {
            result.basket.status=1;
            //TODO basket ms updateBasketi buraya çağır.
            BasketResponse basketResponse = sendRequestUpdateBasket(result.basket);
            if (basketResponse.meta.errorCode != 200) {
                paymentResponse.meta.errorCode = 4000;
                paymentResponse.meta.errorDesc = "Sepet güncellenemediği için ödemeye devam edilemedi.";
            } else {
                TransferResponse transferResponse1 = sendRequestTransferService(result.basket.basketId);


                if (transferResponse1.meta.errorCode == 200) {
                    paymentResponse.meta.errorCode = 200;
                    paymentResponse.meta.errorDesc = "Başarılı.";
                } else {
                    paymentResponse.meta.errorCode = 4001;
                    paymentResponse.meta.errorDesc = "Kargo verilemedi.";
                    result.basket.status = 0;
                    BasketResponse basketResponse1 = sendRequestUpdateBasket(result.basket);
                }
            }
        } else {
            paymentResponse.meta.errorCode = 5001;
            paymentResponse.meta.errorDesc = "Ödeme alınamadığı için işleme devam edilemedi.";
            //TODO başarsız senaryoyu calıstır. basketi güncelleme
        }
        return paymentResponse;
    }

    public Transaction getSession(String key) {
        Map<String, Transaction> transactionMap = hazelcastInstance.getMap("transactionMap");
        return transactionMap.get(key);
    }
    public void addSession(String key, Transaction order) {
        Map<String, Transaction> transactionMap = hazelcastInstance.getMap("transactionMap");
        transactionMap.put(key, order);
    }
}
