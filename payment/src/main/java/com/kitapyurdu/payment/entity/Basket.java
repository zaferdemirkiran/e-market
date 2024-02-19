package com.kitapyurdu.payment.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Basket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketId;
    private double totalAmount; // status ekle
    private int status;

    public Basket() {
    }

    public Basket(int basketId, double totalAmount, int status) {
        this.basketId = basketId;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}




