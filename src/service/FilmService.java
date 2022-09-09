package service;

import java.sql.SQLException;

public interface FilmService {
    void addToMyFavoriteFilm() throws SQLException;
    void addToMyWatchedFilm() throws SQLException;
    void addToMyFavoriteGenre() throws SQLException;
    void watchNewFilm() throws SQLException;

}
