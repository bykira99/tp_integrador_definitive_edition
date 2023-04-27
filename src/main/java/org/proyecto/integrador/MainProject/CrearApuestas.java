package org.proyecto.integrador.MainProject;

import org.proyecto.integrador.ObjetsProject.Apuesta;
import org.proyecto.integrador.ObjetsProject.Participante;
import org.proyecto.integrador.database.PronosticoRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class CrearApuestas {
    public static ArrayList<Apuesta> getApuestas(ArrayList<Participante> participantes, ArrayList<Apuesta> apuestaList) throws SQLException {
            for (int recorridoArray = 0; recorridoArray < participantes.size(); recorridoArray++) {
                Apuesta apuesta = new Apuesta(participantes.get(recorridoArray), PronosticoRepository.getPronosticos(participantes.get(recorridoArray).getNombre()));
                apuesta.setPuntos(CalcularPuntos.calcular(apuesta.getPronosticos()));
                apuestaList.add(apuesta);
            }
        return apuestaList;
    }
    //ArrayList<Apuesta> apuestaList = new ArrayList<>();
        /*for (Participante participante : participantes) {
            Apuesta apuesta = CrearApuesta.apuestas(participante, pronosticos);
            apuesta.setPuntos(CalcularPuntos.calcular(apuesta.getPronosticos()));
            apuestaList.add(apuesta);
        }*/

}
