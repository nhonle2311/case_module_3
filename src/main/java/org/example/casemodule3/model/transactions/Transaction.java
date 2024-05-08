package org.example.casemodule3.model.transactions;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Transaction {
    private int transactionID;
    private int userID;
    private int transactionTypeID;
    private double amount;
    private String description;
    private LocalDate transactionDate;
    private Timestamp createdAt;

    public Transaction() {
    }

    public Transaction(int transactionID, int userID, int transactionTypeID, double amount, String description, LocalDate transactionDate, Timestamp createdAt) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.transactionTypeID = transactionTypeID;
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
        this.createdAt = createdAt;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTransactionTypeID() {
        return transactionTypeID;
    }

    public void setTransactionTypeID(int transactionTypeID) {
        this.transactionTypeID = transactionTypeID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

