package DB;

import util.ApplicationUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConfig {

    private static final String DB_HOST1 = "jdbc:mysql://localhost:3306/SMAppOne"; //Final variable-lar her zaman boyuk herfle yazilir
    private static final String DB_HOST2 = "jdbc:mysql://localhost:3306/TMAppOne";
    private static final String DB_USERNAME = "root";

    private static final String DB_PASSWORD = "root";

    private static Connection connection1;
    private static Connection connection2;
    //Bazaya connect olmagimizi bize verir
    public static Connection getConnection1() {
        try {
            connection1 = DriverManager.getConnection(DB_HOST1, DB_USERNAME, DB_PASSWORD); //Iki proqram arasinda elaqeni Drive-lar saxlayir
        } catch (SQLException ex) {
            ApplicationUtil.printError("Cannot create Database connection");
        }
        return connection1;
    }

    public static Connection getConnection2() {
        try {
            connection2 = DriverManager.getConnection(DB_HOST2, DB_USERNAME, DB_PASSWORD); //Iki proqram arasinda elaqeni Drive-lar saxlayir
        } catch (SQLException ex) {
            ApplicationUtil.printError("Cannot create Database connection");
        }
        return connection2;
    }
}

