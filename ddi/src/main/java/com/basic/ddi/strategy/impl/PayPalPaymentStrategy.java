package com.basic.ddi.strategy.impl;

import com.basic.ddi.strategy.PaymentStrategy;
import com.basic.ddi.strategy.PaymentType;
import org.springframework.stereotype.Service;

@Service
public class PayPalPaymentStrategy implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    @Override
    public PaymentType getType() {
        return PaymentType.PAYPAL;
    }
}