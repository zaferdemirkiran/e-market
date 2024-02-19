package com.kitapyurdu.payment.client;

import com.kitapyurdu.payment.feignApi.TransferFeignCallableApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "TRANSFER")
public interface TransferFeignClient extends TransferFeignCallableApi {
}
