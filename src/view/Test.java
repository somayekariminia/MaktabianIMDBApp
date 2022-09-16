package view;

import model.Film;
import model.Genre;
import repository.FilmRepository;
import repository.TableCreatorRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        TableCreatorRepository tableCreatorRepository=new TableCreatorRepository();
        // tableCreatorRepository.createFilmTable();
        FilmRepository filmRepository=new FilmRepository();
        List<Film> filmList=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        filmRepository.addCommentToFilm("verygood",8,1,2);
        list=filmRepository.getRateList(1);
        if(filmRepository.isWatched("father"))
            System.out.println("mother");
        else
            System.out.println("no");
        System.out.println(list.get(0).toString());
    }
}
