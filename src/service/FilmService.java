package service;

import java.sql.SQLException;

public interface FilmService {
    void addToMyFavoriteFilm(int userId,int filmId) throws SQLException;
    void addToMyWatchedFilm(int userId,int filmId) throws SQLException;
    void addToMyFavoriteGenre(int userId,int filmId ) throws SQLException;

}
