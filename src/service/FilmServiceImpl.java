package service;

import model.Film;
import model.Genre;
import repository.FilmRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmServiceImpl implements FilmService {
    UserRepository userRepository = UserRepository.userRepository.getUserRepository();
    FilmRepository filmRepository = new FilmRepository();
    List<Film> list = new ArrayList<>();

    @Override
    public void addToMyFavoriteFilm() throws SQLException {

    }

    @Override
    public void addToMyWatchedFilm() throws SQLException {


    }

    @Override
    public void addToMyFavoriteGenre() throws SQLException {

    }
    public  List<Genre> getMyFavoriteGenre() throws SQLException {
        List<Genre> list1=new ArrayList<>();
       return list1=filmRepository.getFavoriteGenres();
    }

    public List<Film> getFavoriteFilmService() throws SQLException {
        list = null;
        list = filmRepository.getFavoriteFilm();
        return list;
    }

    public List<Film> getFavoriteGenresFilmsService() throws SQLException {
        list = null;
        list = filmRepository.getFavoriteGenresFilms();
        return list;
    }

    public List<Film> getWatchedFilmService() throws SQLException {
        list = null;
        list = filmRepository.getWatchedFilm();
        return list;
    }
}
