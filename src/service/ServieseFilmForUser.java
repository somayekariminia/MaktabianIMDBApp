package service;

import model.Film;
import repository.FilmRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public void addToMyFavoriteGenre() throws SQLException {

        userRepository.getFavoriteGenresFilms();

    }

    @Override
    public void watchNewToFilm() throws SQLException {
        int choice=0;
        List<Film> filmList=new ArrayList<>();
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
