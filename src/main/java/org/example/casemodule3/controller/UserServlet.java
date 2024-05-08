package org.example.casemodule3.controller;

import org.example.casemodule3.dto.DTOUser;
import org.example.casemodule3.model.user.Users;
import org.example.casemodule3.sevice.userService.IUserService;
import org.example.casemodule3.sevice.userService.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet (name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private final IUserService iUserService = new UserService();
    private Users users = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }switch (action){
            case "show":
                showUser(req,resp);
                break;
            case "add":
                showFormCreate(req,resp);
                break;
            case "edit":
                showFormEdit(req,resp);
                break;
            case "delete":
                deleteUsers(req,resp);
                break;
            default:
                listUser(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }switch (action){
            case "add":
                addUser(req,resp);
                break;
            case "edit":
                editUser(req,resp);
            default:
                resp.sendRedirect("/users");
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        Timestamp createdAt = Timestamp.valueOf((req.getParameter("createdAt")));
        users = new Users(id, userName,password,email,fullName,createdAt);
        iUserService.updateByID(id,users);
        resp.sendRedirect("/users?action=list");
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        if (userName != null && password != null && email != null) {
            Users users = new Users(userName, password, email, fullName, createdAt);
            iUserService.create(users);
            resp.sendRedirect("/users?action=list");
        } else {
            resp.getWriter().println("Some required fields are missing.");
        }
    }


    private void deleteUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        iUserService.deleteByID(id);
        resp.sendRedirect("/users?action=list");
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        users = iUserService.findByID(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/user_form.jsp");
        req.setAttribute("users",users);
        req.setAttribute("action","edit");
        requestDispatcher.forward(req,resp);
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> userList = iUserService.findAll();
        req.setAttribute("userList",userList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/list.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        users = iUserService.findByID(id);
        req.setAttribute("users",users);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/user_detail.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/user_form.jsp");
        req.setAttribute("action","add");
        requestDispatcher.forward(req,resp);
    }
}
