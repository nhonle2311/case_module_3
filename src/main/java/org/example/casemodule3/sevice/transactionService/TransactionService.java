package org.example.casemodule3.sevice.transactionService;

import org.example.casemodule3.model.transactions.Transaction;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.example.casemodule3.config.ConnectionJDBC.getConnection;
public class TransactionService implements ITransaction{
    @Override
    public List<Transaction> findAll() {
        List<Transaction>transactionList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from transactions");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int transactionID = rs.getInt("TransactionID");
                int userID = rs.getInt("UserID");
                int transactionTypeID = rs.getInt("TransactionTypeID");
                double amount = rs.getDouble("Amount");
                String description = rs.getString("Description");
                LocalDate transactionDate = rs.getDate("TransactionDate").toLocalDate();
                Timestamp createdAt = rs.getTimestamp("CreatedAt");
                Transaction transaction = new Transaction(transactionID,userID,transactionTypeID,amount,description,transactionDate,createdAt);
                transactionList.add(transaction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactionList;
    }

    @Override
    public Transaction findByID(int id) {
        Connection connection = getConnection();
        Transaction transaction = null;
        try {
             PreparedStatement preparedStatement = connection.prepareStatement("select * from transactions where TransactionID=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int transactionID = rs.getInt("TransactionID");
                int userID = rs.getInt("UserID");
                int transactionTypeID = rs.getInt("TransactionTypeID");
                double amount = rs.getDouble("Amount");
                String description = rs.getString("Description");
                LocalDate transactionDate = rs.getDate("TransactionDate").toLocalDate();
                Timestamp createdAt = rs.getTimestamp("CreatedAt");
                transaction = new Transaction(transactionID, userID, transactionTypeID, amount, description, transactionDate, createdAt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public void create(Transaction o) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO transactions (userid, transactiontypeid, amount, description, transactiondate, createdat) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, o.getUserID());
            preparedStatement.setInt(2, o.getTransactionTypeID()); // Sử dụng getTransactionTypeID() thay vì getTransactionID()
            preparedStatement.setDouble(3, o.getAmount());
            preparedStatement.setString(4, o.getDescription());
            preparedStatement.setDate(5, Date.valueOf(o.getTransactionDate()));
            preparedStatement.setTimestamp(6, o.getCreatedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateByID(int id, Transaction o) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Transactions SET UserID=?, TransactionTypeID=?, Amount=?, Description=?, TransactionDate=?, CreatedAt=? WHERE TransactionID=?");
            preparedStatement.setInt(1, o.getUserID());
            preparedStatement.setInt(2, o.getTransactionTypeID());
            preparedStatement.setDouble(3, o.getAmount());
            preparedStatement.setString(4, o.getDescription());
            preparedStatement.setDate(5, Date.valueOf(o.getTransactionDate()));
            preparedStatement.setTimestamp(6, Timestamp.valueOf(String.valueOf(o.getCreatedAt())));
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByID(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Transactions WHERE TransactionID=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public double calculateTotalIncomeByUserID(int userID) {
        Connection connection = getConnection();
        double totalIncome = 0.0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(Amount) AS TotalIncome FROM Transactions WHERE UserID = ? AND TransactionTypeID = 1");
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalIncome = resultSet.getDouble("TotalIncome");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalIncome;
    }

    public double calculateTotalExpensesByUserID(int userID) {
        Connection connection = getConnection();
        double totalExpenses = 0.0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(Amount) AS TotalExpenses FROM Transactions WHERE UserID = ? AND TransactionTypeID = 2");
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalExpenses = resultSet.getDouble("TotalExpenses");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalExpenses;
    }


    public double calculateTotalIncomeMinusExpensesByUserID(int userID) {
        double totalIncome = calculateTotalIncomeByUserID(userID);
        double totalExpenses = calculateTotalExpensesByUserID(userID);
        return totalIncome - totalExpenses;
    }

}

