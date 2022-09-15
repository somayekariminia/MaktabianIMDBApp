package repository;

import model.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TableCreatorRepository {
    public void creatUserTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table user_table(id serial  primary key ,userName varchar(50)," +
                "age int,password varchar(15)," +
                "mobileNumber varchar(15)," +
                "email varchar(50))");
        preparedStatement.executeUpdate();

    }

    public void creatFavoriteFilmTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table favorite_Film(id serial primary key not null ,user_id int,film_id int," +
                "FOREIGN KEY(user_id) REFERENCES user_table(id)," +
                " FOREIGN KEY(film_id) REFERENCES film_table(id))");
        preparedStatement.executeUpdate();
    }

    public void createFilmTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table film_table(id serial primary key ,name varchar(50)," +
                "genre varchar(50)," +
                "directorName varchar(50)," +
                "duration varchar(50) ," +
                "ageCategory varchar(50)," +
                "createyear int," +
                "country varchar(50)," +
                "numberSeasons int," +
                "numberEpisodes int )");
        preparedStatement.executeUpdate();

    }

    public void creatCommentTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("create table  comment_table(id serial primary key not null," +
                "user_id int ," +
                "film_id int," +
                "description varchar(300)," +
                "rate int, "+
                " FOREIGN KEY(user_id) REFERENCES user_table(id)," +
                " FOREIGN KEY(film_id) REFERENCES film_table(id))");
        preparedStatement.executeUpdate();
    }
    public  void watchedFilmTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("create table watched_table(id serial primary key," +
                "user_id int," +
                "film_id int," +
                " FOREIGN KEY(user_id) REFERENCES user_table(id)," +
                " FOREIGN KEY(film_id) REFERENCES film_table(id))");
     preparedStatement.executeUpdate();
    }
    public void createGenreTable() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("create table gener_table(id serial primary key," +
                "user_id int," +
                "film_id int," +
                " FOREIGN KEY(user_id) REFERENCES user_table(id)," +
                " FOREIGN KEY(film_id) REFERENCES film_table(id))");
        preparedStatement.executeUpdate();
    }
}

