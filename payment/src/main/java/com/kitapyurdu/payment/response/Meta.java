package com.kitapyurdu.payment.response;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class Meta implements Serializable {
    public int errorCode;
    public String errorDesc;


}
