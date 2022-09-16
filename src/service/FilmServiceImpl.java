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
    public void addToMyFavoriteFilm(int userId,int filmId) throws SQLException {
        filmRepository.addFilmToFavoriteList(userId,filmId);

    }

    @Override
    public void addToMyWatchedFilm(int userId,int filmId) throws SQLException {
        filmRepository.addFilmToWatchedList(userId,filmId);
    }
    @Override
    public void addToMyFavoriteGenre(int userId,int filmId) throws SQLException {
     filmRepository.addFilmToFavoriteList(userId, filmId);
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
    public int getIdFilm(String name) throws SQLException {
        return filmRepository.getIdFilm(name);
    }
}
