package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmRepository {
    public void addFilmToFavoriteList() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into favorite_table values(?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, user.getId());
        preparedStatement.setInt(3, film.getId());
        preparedStatement.executeQuery();
    }

    public void addFilmToWatchedList() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into watched_table values(?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(2, user.getId());
        preparedStatement.setInt(3, film.getId());
        preparedStatement.executeQuery();
    }

    public void addCommentToFilm(String comment, int rate) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into comment_table values(?,?,?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, comment);
        preparedStatement.setInt(3, rate);
        preparedStatement.setInt(4, user.getId());
        preparedStatement.setInt(5, film.getId());
        preparedStatement.executeQuery();
    }

    public List<Integer> listRate(int id) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select rate from commant_table where film_id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet =preparedStatement.executeQuery();
        List<Integer> list=new ArrayList<>();
        while (resultSet.next()){
            int rate=resultSet.getInt("rate");
            list.add(rate);
        }
    return list;
    }
    public  boolean isWatched(String name) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from film_table inner join " +
                " watch_table on whatch_table.film_id=film_table.id where name=? ");
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.equals(null))
          return false;
        else
            return true;
    }

}

