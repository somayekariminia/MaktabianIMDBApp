package service;

import repository.FilmRepository;
import repository.UserRepository;

import java.sql.SQLException;

public class ServieseFilmForUser implements ServiceFilm {
    UserRepository userRepository=UserRepository.userRepository.getUserRepository();
    FilmRepository filmRepository=new FilmRepository();
    @Override
    public void addToMyFavoriteFilm() throws SQLException {
        userRepository.myFavoriteFilm();
    }

    @Override
    public void addToMyWatchedFilm() throws SQLException {
        userRepository.myWatchedFilm();

    }
    @Override
    public void addToMyFavoriteGenre() {

        userRepository.myGenreFavorite();

    }

    @Override
    public void watchNewToFilm() throws SQLException {
        int choice=0;
        switch (choice)
        {
            case 1:
                filmRepository.addFilmToWatchedList();
                  break;
            case 2:
                addToMyFavoriteGenre();
                break;
        }
    }
}
