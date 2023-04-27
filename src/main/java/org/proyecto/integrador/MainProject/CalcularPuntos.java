package org.proyecto.integrador.MainProject;

import org.proyecto.integrador.ObjetsProject.Participante;
import org.proyecto.integrador.ObjetsProject.Partido;
import org.proyecto.integrador.ObjetsProject.Pronostico;
import org.proyecto.integrador.database.PronosticoRepository;
import org.proyecto.integrador.database.ResultadoRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class CalcularPuntos {
    public static int calcular(ArrayList<Pronostico> pronosticos) throws SQLException {
        int calculoPuntos = 0;

        ArrayList<Partido> partidos = ResultadoRepository.getPartidos();
        for (Pronostico pronostico : pronosticos) {
            Partido partido = partidos.stream().filter(p -> pronostico.getPartido().equals(p)).findFirst().get();
            if(pronostico.getResultado().getStatus().equals(partido.resultado(pronostico.getEquipo()).getStatus())){
                calculoPuntos+= pronostico.getResultado().getPuntos();
            }
        }
        return calculoPuntos;
    }

}
