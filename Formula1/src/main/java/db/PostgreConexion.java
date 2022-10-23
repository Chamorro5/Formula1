package db;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class PostgreConexion
{
    private final String url = "jdbc:postgresql://localhost:5432/Formula1";
    private final String user = "postgres";
    private final String password = "1234";
    Connection conn;
    
    public PostgreConexion() {
        this.conn = null;
    }
    
    public Connection connect() {
        if (this.conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Formula1", "postgres", "1234");
                System.out.println("Connected to the PostgreSQL server successfully.");
            }
            catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return this.conn;
    }
}