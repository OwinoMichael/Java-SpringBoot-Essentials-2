package com.example.demo.Event;

import com.example.demo.Transaction.TransferDTO;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TransferEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public TransferEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(Object source, TransferDTO transferDTO){
        TransferEvent transferEvent = new TransferEvent(source, transferDTO);
        applicationEventPublisher.publishEvent(transferEvent);
    }
}
