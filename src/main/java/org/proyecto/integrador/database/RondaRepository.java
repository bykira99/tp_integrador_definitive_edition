package org.proyecto.integrador.database;

import org.proyecto.integrador.ObjetsProject.Ronda;
import org.proyecto.integrador.factory.RondaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RondaRepository {
    public static ArrayList<Ronda> getRonda() throws SQLException {
        ResultSet rs = null;
        Connection con = GetConnection.getConnectionOfDataBase();
        if (con != null) {
            PreparedStatement stmt = con.prepareStatement("SELECT ronda, equipo1, " +
                    "equipo2, partido FROM resultados");
            rs = stmt.executeQuery();
        } else {
            System.out.println("Connection is null");
        }
        return RondaFactory.buildRondas(rs);

    }
}
