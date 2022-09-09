package view;

import repository.TableCreatorRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        TableCreatorRepository tableCreatorRepository=new TableCreatorRepository();
        tableCreatorRepository.creatUserTable();
    }
}
