package com.kitapyurdu.payment.feignApi;

import com.kitapyurdu.payment.entity.Basket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;

public interface BasketFeignCallableApi {
    @GetMapping("basket/getBasket/{basketId}")
    Basket getBasketByBasketId(@PathVariable(value = "basketId")String basketId);

}

