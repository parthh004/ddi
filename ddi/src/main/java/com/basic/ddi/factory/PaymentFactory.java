package com.basic.ddi.factory;

import com.basic.ddi.strategy.PaymentStrategy;
import com.basic.ddi.strategy.PaymentType;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentFactory {

    private final Map<PaymentType, PaymentStrategy> paymentStrategies;

    public PaymentFactory(List<PaymentStrategy> services) {
        this.paymentStrategies = services.stream()
                .collect(Collectors.toMap(PaymentStrategy::getType, Function.identity()));
    }

    public PaymentStrategy getService(PaymentType paymentType) {
        PaymentStrategy service = paymentStrategies.get(paymentType);
        if (service == null) {
            throw new IllegalArgumentException("No payment strategy registered for type: " + paymentType);
        }
        return service;
    }
}
