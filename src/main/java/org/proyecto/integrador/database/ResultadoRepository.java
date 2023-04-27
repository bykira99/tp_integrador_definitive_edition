package org.proyecto.integrador.database;

import org.proyecto.integrador.ObjetsProject.Partido;
import org.proyecto.integrador.factory.PartidoFactory;

import java.sql.*;
import java.util.ArrayList;

public class ResultadoRepository {

    public static ArrayList<Partido> getPartidos() throws SQLException {
        ResultSet rs = null;
        Connection con = GetConnection.getConnectionOfDataBase();
        if (con != null) {
            PreparedStatement stmt = con.prepareStatement("SELECT ronda, equipo1, cantGoles1, " +
                    "cantGoles2, equipo2, partido FROM resultados");
            rs = stmt.executeQuery();
        } else {
            System.out.println("Connection is null");
        }
        return PartidoFactory.buildPartido(rs);

    }

}