package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreatorRepository {
    public  void creatUserTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement prepare = connection.prepareStatement("create table user_table(id int primary key ,userName varchar(50)," +
                "age int,password varchar(15)," +
                "mobileNumber varchar(15)," +
                "email varchar(50))");

    }
    public  void creatFavoriteFilmTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement prepare=connection.prepareStatement("create table favorite_Film(id int primary key not null ,user_id int,film_id int," +
                "FOREIGN KEY(user_id) REFERENCES user_table(id)," +
                " FOREIGN KEY(film_id) REFERENCES film_table(id))");
    }
    public  void createFilmTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement prepare=connection.prepareStatement("create table film_table(id int,name varchar(50)," +
                "ganre varchar(50),directorName varchar(50),createyear int,countey varchar(50))");
    }


}
