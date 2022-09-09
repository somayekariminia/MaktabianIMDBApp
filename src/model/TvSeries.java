package model;

import java.util.Date;

public class TvSeries extends Film{
    private int numberOfSeasons;
    private int numberOfEpisodes;
    public TvSeries(int id, String name, String genre, String directorName, int createdYear, String country, Comment comment, int rate, double duration, AgeCategory ageCategory) {
        super(id, name, genre, directorName, createdYear, country, comment, rate, duration, ageCategory);
    }
}
