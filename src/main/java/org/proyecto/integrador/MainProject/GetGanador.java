package org.proyecto.integrador.MainProject;

import org.proyecto.integrador.ObjetsProject.Apuesta;

import java.util.ArrayList;

public class GetGanador {
    public static Apuesta determinar(ArrayList<Apuesta> apuestas){
        Apuesta apuestaGanadora = null;
        int val=0;
        for (Apuesta apuesta : apuestas) {
            if(apuesta.getPuntos() >= val){
                apuestaGanadora = apuesta;
                val = apuesta.getPuntos();
            }
        }

        return apuestaGanadora;
    }



}
