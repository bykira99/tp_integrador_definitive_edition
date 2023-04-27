package org.proyecto.integrador.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

    public static Connection getConnectionOfDataBase() throws SQLException {
        Connection con = null;
        try {
            String sURL = "jdbc:mysql://db4free.net:3306/integradorutnap";
            con = DriverManager.getConnection(sURL, "enanot", "C0ntraseña");
        } catch (SQLException e) {
            System.out.println("Fallo la conexión con la base de datos, error " + e);
        }
        return con;
    }
}
