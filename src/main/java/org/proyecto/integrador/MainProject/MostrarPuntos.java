package org.proyecto.integrador.MainProject;

import org.proyecto.integrador.ObjetsProject.Apuesta;

import java.sql.SQLException;
import java.util.ArrayList;

public class MostrarPuntos {
    public static void participantes(ArrayList<Apuesta> apuestas) throws SQLException {
        for(int i = 0; i< apuestas.size(); i++) {
            Apuesta apuesta = CrearApuesta.apuestas(apuestas.get(i).getParticipante(), apuestas.get(i).getPronosticos());
            int aux = CalcularPuntos.calcular(apuesta.getPronosticos());
            System.out.println("---------------------------------------------------------------");
            System.out.println("Los puntos de " + apuesta.getParticipante().getNombre() + " son: " + aux);
            System.out.println("---------------------------------------------------------------");
        }


    }
}
