package service;

import model.User;
import repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private  UserRepository userRepository=new UserRepository();
    private static UserService instance=new UserService();
    private UserService(){}
    public static UserService getInstance(){
        return  instance;
    }
    public void addNewUser(User user) throws SQLException {
        userRepository.addUser(user);
    }
    public  boolean isExist(String name,String password) throws SQLException {
       return userRepository.login(name,password);
    }
 public int getId(String userName,String password) throws SQLException {
        return userRepository.getIdUser(userName,password);
 }
}
