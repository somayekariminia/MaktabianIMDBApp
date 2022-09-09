package service;

import java.sql.SQLException;

public interface ServiceFilm {
    void addToMyFavoriteFilm() throws SQLException;
    void addToMyWatchedFilm() throws SQLException;
    void addToMyFavoriteGenre() throws SQLException;
    void watchNewToFilm() throws SQLException;

}
