package com.basic.ddi.strategy;

public interface PaymentStrategy {
    void processPayment(double amount);
    PaymentType getType();
}
