package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreatorRepository {
    public void creatUserTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table user_table(id int primary key ,userName varchar(50)," +
                "age int,password varchar(15)," +
                "mobileNumber varchar(15)," +
                "email varchar(50))");
        preparedStatement.executeUpdate();

    }

    public void creatFavoriteFilmTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table favorite_Film(id int primary key not null ,user_id int,film_id int," +
                "FOREIGN KEY(user_id) REFERENCES user_table(id)," +
                " FOREIGN KEY(film_id) REFERENCES film_table(id))");
        preparedStatement.executeUpdate();
    }

    public void createFilmTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table film_table(id int,name varchar(50)," +
                "genre varchar(50),directorName varchar(50),createyear int,countey varchar(50))");
        preparedStatement.executeUpdate();

    }

    public void creatCommentTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement PreparedStatement = connection.prepareStatement("create table  comment_table(id int primary key not null," +
                "user_id int ," +
                "film_id int," +
                "description varchar(300)," +
                " FOREIGN KEY(user_id) REFERENCES user_table(id)," +
                " FOREIGN KEY(film_id) REFERENCES film_table(id))");
    }
    public  void watchedFilmTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement PreparedStatement=connection.prepareStatement("create table watched_table(id int primary key," +
                "user_id int," +
                "film_id int," +
                " FOREIGN KEY(user_id) REFERENCES user_table(id)," +
                " FOREIGN KEY(film_id) REFERENCES film_table(id))");
    }

}

