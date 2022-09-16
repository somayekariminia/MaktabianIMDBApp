package repository;

import model.Film;
import model.Genre;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static UserRepository userRepository = new UserRepository();

    public UserRepository() {
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
    public  void addUser(User user) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user_table(username,age,password,mobileNumber,email) values(?,?,?,?,?)");
        preparedStatement.setString(1,user.getUserName());
        preparedStatement.setInt(2,user.getAge());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.setString(4,user.getMobileNumber());
        preparedStatement.setString(5,user.getEmail());
        preparedStatement.executeUpdate();
    }
    public boolean login(String userName, String password) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table" +
                " where userName=? and password=?");
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean flage = false;
        while (resultSet.next()) {
            if (!resultSet.getString("userName").equals(null) &&
                    !resultSet.getString("password").equals(null))
                flage = true;
        }
        return flage;
    }
    public int getIdUser(String userName,String password) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select id from  user_table where username=? and password=?");
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);
        ResultSet resultSet=preparedStatement.executeQuery();
        int id=0;
        while (resultSet.next())
        {
            id=resultSet.getInt(1);
        }
        return id;
    }
}
