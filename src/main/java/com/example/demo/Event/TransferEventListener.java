package com.example.demo.Event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TransferEventListener implements ApplicationListener<TransferEvent> {
    @Override
    public void onApplicationEvent(TransferEvent event) {
        //Code for execution e.g. send an email

        System.out.println("Transfer Event Handled");
        System.out.println(event.getTransferDTO());
        System.out.println(event.getSource());
    }
}
