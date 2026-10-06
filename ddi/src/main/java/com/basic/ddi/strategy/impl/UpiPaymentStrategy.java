package com.basic.ddi.strategy.impl;

import com.basic.ddi.strategy.PaymentStrategy;
import com.basic.ddi.strategy.PaymentType;
import org.springframework.stereotype.Service;

@Service
public class UpiPaymentStrategy implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount);
    }

    @Override
    public PaymentType getType() {
        return PaymentType.UPI;
    }
}
