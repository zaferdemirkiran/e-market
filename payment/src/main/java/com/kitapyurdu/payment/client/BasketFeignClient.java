package com.kitapyurdu.payment.client;

import com.kitapyurdu.payment.feignApi.BasketFeignCallableApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "BASKET") //TODO istek atılacak servis in ismi. 8761'de nasıl kayıtlıysa.
public interface BasketFeignClient extends BasketFeignCallableApi {
}
