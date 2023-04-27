package org.proyecto.integrador.MainProject;
import org.proyecto.integrador.ObjetsProject.*;
import org.proyecto.integrador.database.ParticipanteRepository;
import org.proyecto.integrador.database.PronosticoRepository;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        ArrayList<Participante> participantes = ParticipanteRepository.getParticipantes();
        ArrayList<Apuesta> apuestaList = null;
        ArrayList<Pronostico> pronosticos;
        for (int recorridoArray = 0; recorridoArray < participantes.size(); recorridoArray++) {
            pronosticos = PronosticoRepository.getPronosticos(participantes.get(recorridoArray).getNombre());
            apuestaList = (CrearApuestas.apuestas(participantes, pronosticos));
        }

        
        MostrarPuntos.participantes(apuestaList);

        Apuesta apuestaGanadora = GetGanador.determinar(apuestaList);

        System.out.println("El participante ganador es: " + apuestaGanadora.getParticipante().getNombre()
                + " sumando un total de " + apuestaGanadora.getPuntos() + " puntos");

    }
}