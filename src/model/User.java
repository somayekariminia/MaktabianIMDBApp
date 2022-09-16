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
    private List<Genre> favoriteGenre=new ArrayList<>();
private int id;
    public User(String userName, int age, String password, String mobileNumber, String email) {
        this.userName = userName;
        this.age = age;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

public  int getId(){
        return id;
}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Film> getFavoriteFilms() {
        return favoriteFilms;
    }

    public void setFavoriteFilms(List<Film> favoriteFilms) {
        this.favoriteFilms = favoriteFilms;
    }

    public List<Film> getWatchFilm() {
        return watchFilm;
    }

    public void setWatchFilm(List<Film> watchFilm) {
        this.watchFilm = watchFilm;
    }

    public List<Genre> getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(List<Genre> favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }
}
