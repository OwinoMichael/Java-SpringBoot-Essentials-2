package com.example.demo.Transaction;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

public class TransferDTO {
    private String fromUser;
    private String toUser;
    private double amount;

    public TransferDTO() {
    }

    public TransferDTO(String fromUser, String toUser, double amount) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferDTO that = (TransferDTO) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(fromUser, that.fromUser) && Objects.equals(toUser, that.toUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromUser, toUser, amount);
    }
}
