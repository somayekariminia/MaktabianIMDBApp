package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    public boolean login(String userName,String password) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from user_table" +
                " where userName=? and password=?");
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);
        ResultSet resultSet= preparedStatement.executeQuery();
        boolean flage=false;
        while (resultSet.next()){
            if(!resultSet.getString("userName").equals(null) &&
                    !resultSet.getString("password").equals(null))
                flage=true;
        }
        return flage;
    }


}
