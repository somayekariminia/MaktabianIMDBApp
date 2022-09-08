package service;

import java.sql.SQLException;

public interface ServiceFilm {
    void addToMyFavoriteFilm() throws SQLException;
    void addToMyWatchedFilm() throws SQLException;
    void addToMyFavoriteGenre();
    void watchNewToFilm() throws SQLException;

}
