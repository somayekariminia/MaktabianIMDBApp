package view;
import model.Film;
import model.Genre;
import model.User;
import repository.TableCreatorRepository;
import service.FilmService;
import service.FilmServiceImpl;
import service.UserService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static User user;
    private static UserService userService = UserService.getInstance();
    private static FilmServiceImpl filmService = new FilmServiceImpl();
    private static List<Film> films = new ArrayList<>();
    private static    int idUser = 0;
    private static int idFilm = 0;
    private static int choice;

    public static void main(String[] args) throws SQLException {
        FilmServiceImpl filmService = new FilmServiceImpl();
        System.out.println("1: signin \n 2: signout ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("enter your username");
                String name = scanner.nextLine();
                System.out.println("enter your password");
                String password = scanner.nextLine();
                if (userService.isExist(name, password)) {
                    idUser = userService.getId(name, password);
                    firstMenue();
                }
                break;
            case 2:
                System.out.println(" singup new user: ");
                user = getNewUser();
                userService.addNewUser(user);
                break;
        }
    }

    public static User getNewUser() {
        System.out.println(" enter new username: ");
        String userName = scanner.nextLine();
        System.out.println("enter new password: ");
        String password = scanner.nextLine();
        System.out.println("enter age user");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("enter numberPhone");
        String numberMobile = (scanner.nextLine());
        System.out.println("enter email");
        String email = scanner.nextLine();
        User user = new User(userName, age, password, numberMobile, email);
        return user;
    }

    public static void firstMenue() throws SQLException {
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
                break;
            case 2:
                List<Genre> genreList = new ArrayList<>();
                genreList = filmService.getMyFavoriteGenre();
                if (!genreList.isEmpty())
                    for (Genre genre : genreList) {
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
                break;
            case 4:
                films = null;
                films = filmService.getFavoriteGenresFilmsService();
                for (Film film : films) {
                    System.out.println(film.toString());
                    secondMenue();
                }
                break;
        }
    }
    public  static  void secondMenue() throws SQLException {
        System.out.println("1- Choose a Film to Watch\n 2- add To Favorite ");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("enter name film");
                String name1 = scanner.nextLine();
                idFilm = filmService.getIdFilm(name1);
                filmService.addToMyWatchedFilm(idUser, idFilm);
                System.out.println(" 1- rate\n 2- command ");
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
                        String commend = scanner.nextLine();
                        break;
                }
                break;
            case 2:
                filmService.addToMyFavoriteFilm(idUser, idFilm);
                break;
        }
    }
}