package org.proyecto.integrador.factory;

import org.proyecto.integrador.ObjetsProject.Participante;
import org.proyecto.integrador.ObjetsProject.Pronostico;
import org.proyecto.integrador.database.PronosticoRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParticipantesFactoy {
    public static ArrayList<Participante> buildParticipantes(ResultSet rs) throws SQLException {
        ArrayList<Participante> participantes = new ArrayList<>();
        while(rs.next()){
            String nombre = rs.getString("p.participante");
            participantes.add(new Participante(nombre));
        }
        return participantes;
    }
}
