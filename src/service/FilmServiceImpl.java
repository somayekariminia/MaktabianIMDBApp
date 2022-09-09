package service;

import model.Film;
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

    @Override

    public void watchNewFilm() throws SQLException {
        List<Film> filmList = new ArrayList<>();
        filmList = userRepository.getFavoriteGenresFilms();
        for (int i = 0; i < filmList.size(); i++) {
            System.out.println(filmList.get(i).toString());
        }
        System.out.println("1 : watch\n 2 : favorite");
        Scanner scanner = new Scanner(System.in);
        int choice;
        switch (choice) {
            case 1:

                filmRepository.addFilmToWatchedList();
                break;
            case 2:
                addToMyFavoriteGenre();
                break;
        }
    }

}
