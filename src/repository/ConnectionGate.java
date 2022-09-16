package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionGate {
    public static Connection getConnection() throws SQLException {
         return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
    }

}
