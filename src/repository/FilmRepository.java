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

public class FilmRepository {
    public void addFilmToFavoriteList(int id, User user, Film film) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into favorite_table(user_id,film_id) values(?,?)");
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setInt(2, film.getId());
        preparedStatement.executeQuery();
    }

    public void addFilmToWatchedList(int id, User user, Film film) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into watched_table(user_id,film_id) values(?,?)");
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setInt(2, film.getId());
        preparedStatement.executeQuery();
    }

    public void addCommentToFilm(String comment, int rate, User user, Film film, int id) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into comment_table (comment,rate,user_id,film_id) values(?,?,?,?)");
        preparedStatement.setString(1, comment);
        preparedStatement.setInt(2, rate);
        preparedStatement.setInt(3, user.getId());
        preparedStatement.setInt(4, film.getId());
        preparedStatement.executeQuery();
    }

    public List<Integer> getRateList(int id) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select rate from commant_table where film_id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Integer> list = new ArrayList<>();
        while (resultSet.next()) {
            int rate = resultSet.getInt("rate");
            list.add(rate);
        }
        return list;
    }

    public boolean isWatched(String name) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from film_table inner join " +
                " watch_table on whatch_table.film_id=film_table.id where name=? ");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.equals(null))
            return false;
        else
            return true;
    }

    public List<Film> getWatchedFilm() throws SQLException {
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
                " on user_table.id=genre_table.user_id  inner join film_table " +
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

    public List<Film> getFavoriteFilm() throws SQLException {
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

    public List<Genre> getFavoriteGenres() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select genre from user_table INNER JOIN genre_table" +
                " on user_table.id=genre_table.user_id  inner join film_table " +
                "on film_table.id=gener.film_id  group by genre");
        List<Genre> list = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Genre genre = Genre.valueOf(resultSet.getString("genre"));
            list.add(genre);
        }
        return list;
    }
}

