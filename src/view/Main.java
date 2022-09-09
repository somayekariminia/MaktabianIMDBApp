package view;

import model.Film;
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
        FilmServiceImpl filmService=new FilmServiceImpl();
        Scanner scanner = new Scanner(System.in);
        List<Film> films=new ArrayList<>();
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
                            films =filmService.getFavoriteFilmService();
                            if(!films.isEmpty())
                            for (Film film : films) {
                                System.out.println(film.toString());
                            }
                            else
                                System.out.println("your list is empty ");
                        case 2:
                            films=null;
                            films=filmService.getFavoriteGenresFilmsService();
                            if(!films.isEmpty())
                                for (int i = 0; i < films.size(); i++) {
                                    System.out.println(films.get(i).getGenre());
                                }
                        case 3:

                        case 4:
                    }
                }
                break;

            case 2:

        }
    }
}
