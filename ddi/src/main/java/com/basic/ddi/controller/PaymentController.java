package com.basic.ddi.controller;

import com.basic.ddi.factory.PaymentFactory;
import com.basic.ddi.strategy.PaymentStrategy;
import com.basic.ddi.strategy.PaymentType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentFactory paymentFactory;

    public PaymentController(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(
            @RequestParam PaymentType type,
            @RequestParam double amount) {

        PaymentStrategy paymentService = paymentFactory.getService(type);
        paymentService.processPayment(amount);

        return ResponseEntity.ok("Payment processed successfully using " + type);
    }
}
