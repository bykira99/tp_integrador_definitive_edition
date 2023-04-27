package org.proyecto.integrador.MainProject;

import org.proyecto.integrador.ObjetsProject.Apuesta;
import org.proyecto.integrador.ObjetsProject.Participante;
import org.proyecto.integrador.ObjetsProject.Pronostico;
import org.proyecto.integrador.database.PronosticoRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class CrearApuestas {
    public static ArrayList<Apuesta> apuestas (ArrayList<Participante> participantes, ArrayList<Pronostico> pronosticos) throws SQLException {
        ArrayList<Apuesta> apuestaList = new ArrayList<>();
        for (Participante participante : participantes) {
            Apuesta apuesta = CrearApuesta.apuestas(participante, pronosticos);
            apuesta.setPuntos(CalcularPuntos.calcular(apuesta.getPronosticos()));
            apuestaList.add(apuesta);
        }
        return apuestaList;
    }
}
