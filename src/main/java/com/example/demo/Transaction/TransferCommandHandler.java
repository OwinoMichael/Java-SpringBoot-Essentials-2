package com.example.demo.Transaction;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class TransferCommandHandler {

    private final BankAccountRepository bankAccountRepository;

    public TransferCommandHandler(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public ResponseEntity transfer(TransferDTO transferDTO){
        Optional<BankAccount> fromAccount = bankAccountRepository.findById(transferDTO.getFromUser());
        Optional<BankAccount> toAccount = bankAccountRepository.findById(transferDTO.getToUser());

        if(fromAccount.isEmpty() || toAccount.isEmpty()){
            throw new RuntimeException("User Not Found");
        }

        BankAccount from = fromAccount.get();
        BankAccount to = toAccount.get();

        //Add and Deduct
        add(to, transferDTO.getAmount());
        //
        deduct(from, transferDTO.getAmount());

        return ResponseEntity.ok("Success");
    }

    private void deduct(BankAccount bankAccount, double amount){
        if (bankAccount.getBalance() < amount){
            throw new RuntimeException("Not Enough Money"); //this MUST BE RUNTIME EXCEPTION OR CHILD OF RUNTIME EXCEPTION
        }
        bankAccount.setBalance(bankAccount.getBalance() - amount);
    }

    private void add(BankAccount bankAccount, double amount){
        bankAccount.setBalance(bankAccount.getBalance() + amount);
    }
}
