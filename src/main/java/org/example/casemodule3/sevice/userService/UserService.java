package org.example.casemodule3.sevice.userService;

import org.example.casemodule3.model.user.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static org.example.casemodule3.config.ConnectionJDBC.getConnection;
public class UserService implements IUserService{
    @Override
    public List<Users> findAll() {
        List<Users> usersList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("userid");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String fullName = resultSet.getString("fullName");
                Timestamp createdAt = resultSet.getTimestamp("createdAt");
                Users user = new Users(id, userName, password,email,fullName,createdAt);
                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }

    @Override
    public Users findByID(int id) {
        Connection connection = getConnection();
        Users users = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userid = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("Userid");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String fullName = resultSet.getString("fullName");
                Timestamp createdAt = resultSet.getTimestamp("createdAt");
                users = new Users(id1,userName,password,email,fullName,createdAt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void create(Users o) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users (username, password, email, fullName, createdAt) values (?,?,?,?,?)");
            preparedStatement.setString(1,o.getUserName());
            preparedStatement.setString(2, o.getPassword());
            preparedStatement.setString(3, o.getEmail());
            preparedStatement.setString(4, o.getFullName());
            preparedStatement.setTimestamp(5,o.getCreatedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateByID(int id, Users o) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Users SET Username=?, Password=?, Email=?, FullName=?, CreatedAt=? WHERE UserID=?");
            preparedStatement.setString(1,o.getUserName());
            preparedStatement.setString(2, o.getPassword());
            preparedStatement.setString(3, o.getEmail());
            preparedStatement.setString(4, o.getFullName());
            preparedStatement.setTimestamp(5,o.getCreatedAt());
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByID(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where userid =?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
