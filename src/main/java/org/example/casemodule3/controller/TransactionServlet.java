package org.example.casemodule3.controller;

import org.example.casemodule3.model.transactions.Transaction;
import org.example.casemodule3.model.user.Users;
import org.example.casemodule3.sevice.transactionService.ITransaction;
import org.example.casemodule3.sevice.transactionService.TransactionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="TransactionServlet", urlPatterns = "/transaction")
public class TransactionServlet extends HttpServlet {
    private ITransaction iTransaction = new TransactionService();
    private Transaction transaction;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }switch (action){
            case "show":
                showTransaction(req,resp);
                break;
            default: listTransaction(req,resp);
                break;
        }
    }

    private void listTransaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Transaction> transactionList = iTransaction.findAll();
        req.setAttribute("transactionList",transactionList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/transaction/transaction_list.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showTransaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        transaction = iTransaction.findByID(id);
        req.setAttribute("transaction",transaction);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/transaction/transaction_list.jsp");
        requestDispatcher.forward(req,resp);
    }
}
