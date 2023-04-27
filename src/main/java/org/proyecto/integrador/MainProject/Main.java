package org.proyecto.integrador.MainProject;
import org.proyecto.integrador.ObjetsProject.*;
import org.proyecto.integrador.database.ParticipanteRepository;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        ArrayList<Participante> participantes = ParticipanteRepository.getParticipantes();
        ArrayList<Apuesta> apuestaList = new ArrayList<>();
        CrearApuestas.getApuestas(participantes, apuestaList);
        MostrarPuntos.participantes(apuestaList);
        Apuesta apuestaGanadora = GetGanador.determinar(apuestaList);
        MensajesEnPantalla.ganador(apuestaGanadora);
    }


}