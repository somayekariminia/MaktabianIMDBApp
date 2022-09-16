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
    public void addFilmToFavoriteList(int idUser,int idFilm) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into favorite_film(user_id,film_id) values(?,?)");
        preparedStatement.setInt(1, idUser);
        preparedStatement.setInt(2, idFilm);
        preparedStatement.executeUpdate();
    }

    public void addFilmToWatchedList( int userId, int filmId) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into watched_table(user_id,film_id) values(?,?)");
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, filmId);
        preparedStatement.executeUpdate();
    }

    public void addCommentToFilm(String comment, int rate,int id_user,int id_film) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into comment_table (description,rate,user_id,film_id) values(?,?,?,?)");
        preparedStatement.setString(1, comment);
        preparedStatement.setInt(2, rate);
        preparedStatement.setInt(3, id_user);
        preparedStatement.setInt(4, id_film);
        preparedStatement.executeUpdate();
    }

    public List<Integer> getRateList(int id) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select rate from comment_table where film_id=?");
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
                " watched_table on watched_table.film_id=film_table.id where name=? ");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean flage=false;
        while (resultSet.next()){
         if(!resultSet.getString("name").equals(null))
             flage=true;
        }
        return flage;
    }

    public List<Film> getWatchedFilm() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("(select * from user_table INNER JOIN watched_table " +
                " on user_table.id=watched_table.user_id  inner join film_table " +
                "on film_table.id=watched_table.film_id)");
        List<Film> filmList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Film film = new Film(resultSet.getString("name"),
                    resultSet.getString("genre")
                    , resultSet.getString("directorName"),
                    resultSet.getInt("duration"),
                    resultSet.getString("ageCategory"),
                    resultSet.getInt("createyear"),
                    resultSet.getString("country"));
            filmList.add(film);
        }
        return filmList;
    }

    public List<Film> getFavoriteGenresFilms() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table INNER JOIN gener_table" +
                " on user_table.id=gener_table.user_id  inner join film_table " +
                "on film_table.id=gener_table.film_id");
        List<Film> list = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Film film = new Film(resultSet.getString("name"),
                    resultSet.getString("genre")
                    , resultSet.getString("directorName"),
                    resultSet.getInt("duration"),
                    resultSet.getString("ageCategory"),
                    resultSet.getInt("createyear"),
                    resultSet.getString("country"));
            list.add(film);
        }
        return list;
    }

    public List<Film> getFavoriteFilm() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table INNER JOIN favorite_Film " +
                " on user_table.id=favorite_Film.user_id  inner join film_table on film_table.id=favorite_Film.film_id");
        List<Film> filmList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Film film = new Film(resultSet.getString("name"),
                    resultSet.getString("genre")
                    , resultSet.getString("directorName"),
                    resultSet.getInt("duration"),
                    resultSet.getString("ageCategory"),
                    resultSet.getInt("createyear"),
                    resultSet.getString("country"));
            filmList.add(film);
        }
        return filmList;
    }

    public List<Genre> getFavoriteGenres() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select genre from user_table INNER JOIN gener_table" +
                " on user_table.id=gener_table.user_id  inner join film_table " +
                "on film_table.id=gener_table.film_id  group by genre");
        List<Genre> list = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Genre genre = Genre.valueOf(resultSet.getString("genre"));
            list.add(genre);
        }
        return list;
    }
    public int getIdFilm(String name) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select id from film_table where name=?");
        preparedStatement.setString(1,name);
        ResultSet resultSet= preparedStatement.executeQuery();
        int idFilm=0;
        while (resultSet.next()){
            idFilm=resultSet.getInt(1);
        }
        return idFilm;
    }
}

