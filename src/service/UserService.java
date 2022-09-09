package service;

import repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private  UserRepository userRepository=new UserRepository();
    public  boolean isExist(String name,String password) throws SQLException {
       return userRepository.login(name,password);
    }

}
