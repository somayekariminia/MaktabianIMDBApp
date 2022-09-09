package repository;

import model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static UserRepository userRepository = new UserRepository();

    private UserRepository() {
    }

    public UserRepository getUserRepository() {
        return userRepository;
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

    public List<Film> myFavoriteFilm() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table INNER JOIN favorite_Film " +
                " on user_table.id=favorite_Film.user_id  inner join film_table on film_table.id=favorit_Film.film_id");
        List<Film> filmList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Film film = new Film(resultSet.getString("name"), resultSet.getString("gener")
                    , resultSet.getString("directorName"),
                    resultSet.getInt("createryear"),
                    resultSet.getString("country"));
            filmList.add(film);
        }
        return filmList;
    }

    public List<Film> myWatchedFilm() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("(select * from user_table INNER JOIN favorite_Film " +
                " on user_table.id=favorite_Film.user_id  inner join film_table " +
                "on film_table.id=whatched_table.film_id)");
        List<Film> filmList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Film film = new Film(resultSet.getString("name"), resultSet.getString("gener")
                    , resultSet.getString("directorName"),
                    resultSet.getInt("createryear"),
                    resultSet.getString("country"));
            filmList.add(film);
        }
        return filmList;
    }

    public List<Film> getFavoriteGenresFilms() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table INNER JOIN genre_table" +
                " on user_table.id=genre_Film.user_id  inner join film_table " +
                "on film_table.id=gener.film_id");
        List<Film> list = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Film film = new Film(resultSet.getString("name"), resultSet.getString("gener")
                    , resultSet.getString("directorName"),
                    resultSet.getInt("createryear"),
                    resultSet.getString("country"));
            list.add(film);
        }
        return list;
    }

}
