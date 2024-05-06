package org.example.casemodule3.model.transactions;

import org.example.casemodule3.model.category.CategoryType;
import org.example.casemodule3.model.user.Users;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Transaction {
    private int id;
    private Users users;
    private double amount;
    private CategoryType categoryType;
    private String description;
    private LocalDate date;
    private Timestamp createdAt;
}

