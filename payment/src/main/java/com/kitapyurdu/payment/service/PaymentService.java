package com.kitapyurdu.payment.service;

import com.kitapyurdu.payment.dto.DoPayDto;
import com.kitapyurdu.payment.response.PaymentResponse;

public interface PaymentService {

    public PaymentResponse doPay(DoPayDto doPay);
}
