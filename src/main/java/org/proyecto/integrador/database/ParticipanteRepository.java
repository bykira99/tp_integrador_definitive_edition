package org.proyecto.integrador.database;

import org.proyecto.integrador.ObjetsProject.Participante;
import org.proyecto.integrador.ObjetsProject.Pronostico;
import org.proyecto.integrador.factory.ParticipantesFactoy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParticipanteRepository {
    public static ArrayList<Participante> getParticipantes() throws SQLException {
        ResultSet rs;
        ArrayList<Participante> participantes = null;
        Connection con = GetConnection.getConnectionOfDataBase();
        if(con != null){
            PreparedStatement stmt = con.prepareStatement("select p.participante from pronostico p " +
                    "group by p.participante");
            rs = stmt.executeQuery();
            participantes = ParticipantesFactoy.buildParticipantes(rs);
        } else{
            System.out.println("Connection is null");
        }
        return participantes;
    }
}
