package org.proyecto.integrador.database;

import org.proyecto.integrador.ObjetsProject.Pronostico;
import org.proyecto.integrador.factory.ParticipantesFactoy;
import org.proyecto.integrador.factory.PronosticoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PronosticoRepository {
    public static ArrayList<Pronostico> getPronosticos(String nombreParticipante) throws SQLException {
        ResultSet rs = null;
        Connection con = GetConnection.getConnectionOfDataBase();
        if(con != null){
            PreparedStatement stmt = con.prepareStatement("SELECT participante, ronda, equipo1," +
                    " gana1, empata, gana2, equipo2, partido FROM pronostico WHERE participante = \"" + nombreParticipante + "\"");
            rs = stmt.executeQuery();
        } else{
            System.out.println("Connection is null");
        }
        return PronosticoFactory.buildPronostico(rs);

    }
}
