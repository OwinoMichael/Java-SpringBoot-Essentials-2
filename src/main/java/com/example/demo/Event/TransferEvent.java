package com.example.demo.Event;

import com.example.demo.Transaction.TransferDTO;
import org.springframework.context.ApplicationEvent;

public class TransferEvent extends ApplicationEvent {
    private TransferDTO transferDTO;


    public TransferEvent(Object source, TransferDTO transferDTO) {
        super(source);
        this.transferDTO = transferDTO;
    }

    public TransferDTO getTransferDTO() {
        return transferDTO;
    }
}
