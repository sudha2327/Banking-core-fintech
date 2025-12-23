package com.fintech.fintech;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="Ledger_Data"
)
public class ledgerentry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    @Column(name="account_number", nullable=false)
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private entrytype transactionType;
    @Column(name="amount", nullable=false)
    private Double amount;
    @Column(name="timestamp", nullable=false)
    private String timestamp=LocalDateTime.now().toString();   
    public ledgerentry(Long id, String accountNumber, entrytype transactionType, Double amount, String timestamp) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public ledgerentry(String fromAccount, String toAccount, entrytype debit, Double amount2) {
        //TODO Auto-generated constructor stub
    }
    public ledgerentry(String string, double d, entrytype credit) {
        //TODO Auto-generated constructor stub
    }
    // Getters and Setters  
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAccountNumber() {
        return accountNumber;
    }       
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
   
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public void setTransactionType(entrytype debit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTransactionType'");
    }

}
