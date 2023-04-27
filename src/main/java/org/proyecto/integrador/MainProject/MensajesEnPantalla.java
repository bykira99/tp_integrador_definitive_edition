package org.proyecto.integrador.MainProject;

import org.proyecto.integrador.ObjetsProject.Apuesta;

public class MensajesEnPantalla {
    public static void ganador(Apuesta apuestaGanadora){
        System.out.println("El participante ganador es: " + apuestaGanadora.getParticipante().getNombre()
                + " sumando un total de " + apuestaGanadora.getPuntos() + " puntos");
    }
}
