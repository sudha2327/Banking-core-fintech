package com.fintech.fintech;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service

public class Services {
    private final repo ledgerRepo;
    public Services(repo ledgerRepo) {
        this.ledgerRepo = ledgerRepo;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)   
    public void transfer(String fromAccount, String toAccount, Double amount) {
        
        Double fromBalance = ledgerRepo.calculateBalance(fromAccount);
        if (fromBalance == null || fromBalance < amount) {
            throw new IllegalArgumentException("Insufficient funds in the source account.");
        }
        ledgerentry debitEntry = new ledgerentry(fromAccount,toAccount,entrytype.DEBIT,amount);
        debitEntry.setAccountNumber(fromAccount);
        debitEntry.setTransactionType(entrytype.DEBIT);
        debitEntry.setAmount(amount);

        ledgerRepo.save(debitEntry);
        ledgerentry creditEntry = new ledgerentry(null, toAccount, null, fromBalance, toAccount);
        creditEntry.setAccountNumber(toAccount);
        creditEntry.setTransactionType(entrytype.CREDIT);
        creditEntry.setAmount(amount);
        ledgerRepo.save(creditEntry);
    }


}
