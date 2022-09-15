package view;

import model.Film;
import model.Genre;
import repository.TableCreatorRepository;
import service.FilmService;
import service.FilmServiceImpl;
import service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        FilmServiceImpl filmService = new FilmServiceImpl();
        Scanner scanner = new Scanner(System.in);
        List<Film> films = new ArrayList<>();
        System.out.println("1: signin \n 2: signout ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("enter your username");
                String name = scanner.nextLine();
                System.out.println("enter your password");
                String password = scanner.nextLine();
                if (userService.isExist(name, password)) {
                    System.out.println("1- My Favorite Films\n " +
                            "2- My Favorite Genre\n " +
                            "3- My Watched Films\n " +
                            "4- Watch a New Film");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            films = filmService.getFavoriteFilmService();
                            if (!films.isEmpty())
                                for (Film film : films) {
                                    System.out.println(film.toString());
                                }
                            else
                                System.out.println("your list is empty ");
                        case 2:

                            List<Genre>genreList=new ArrayList<>();
                            genreList = filmService.getMyFavoriteGenre();
                            if(!genreList.isEmpty())
                                for (Genre genre:genreList) {
                                    System.out.println(genre);
                                }
                            else
                                System.out.println("your list empty");
                            break;
                        case 3:
                            films = null;
                            films = filmService.getWatchedFilmService();
                            for (Film film : films) {
                                System.out.println(films.toString());
                            }
                        case 4:
                            films = null;
                            films = filmService.getFavoriteGenresFilmsService();
                            for (Film film : films) {
                                System.out.println(film.toString());
                            }
                            System.out.println("1- Choose a Film to Watch/n 2- add To Favorite ");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    filmService.addToMyWatchedFilm();
                                    System.out.println(" 1- race\n 2- command ");
                                    choice = Integer.parseInt(scanner.nextLine());
                                    switch (choice) {
                                        case 1:
                                            System.out.println("enter  rate range[1-10]");
                                            int rante = Integer.parseInt(scanner.nextLine());
                                            if (rante >= 1 && rante <= 10)
                                                System.out.println("rate");
                                                else
                                            System.out.println("renge invalid");
                                                break;
                                        case 2:
                                            System.out.println("enter your commend:");
                                            String commend=scanner.nextLine();
                                            break;
                                    }
                                    break;
                                case 2:
                                    filmService.addToMyFavoriteFilm();
                                    break;
                            }
                    }
                }
                break;

            case 2:
                System.out.println("for exite press key  0:");
                choice=scanner.nextInt();


        }
    }
}
