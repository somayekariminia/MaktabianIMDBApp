package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private int age;
    private  String password;
    private String mobileNumber;
    private String email;
    private List<Film> favoriteFilms=new ArrayList<>();
    private List<Film> watchFilm=new ArrayList<>();
    private Genre favoriteGenre;

}
