package model;

import java.util.Date;

public class Film {
    private int id;
    private String name;
    private Genre genre;
    private String directorName;
   private int createdYear;
   private String country;
   private  Comment comment;
   private int rate;
   private double duration;
   private AgeCategory ageCategory;

    public Film(int id, String name, String genre, String directorName, int createdYear, String country, Comment comment, int rate, double duration, AgeCategory ageCategory) {
        this.id = id;
        this.name = name;
        this.genre = Genre.valueOf(genre);
        this.directorName = directorName;
        this.createdYear = createdYear;
        this.country = country;
        this.comment = comment;
        this.rate = rate;
        this.duration = duration;
        this.ageCategory = ageCategory;
    }

    public Film(String name, String genre, String directorName, int createdYear, String country) {
        this.name = name;
        this.genre = Genre.valueOf(genre);
        this.directorName = directorName;
        this.createdYear = createdYear;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(int createdYear) {
        this.createdYear = createdYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        if(rate>=1 && rate<=10 )
           this.rate = rate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }
}
