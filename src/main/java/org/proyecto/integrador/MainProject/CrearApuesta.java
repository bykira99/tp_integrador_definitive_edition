package org.proyecto.integrador.MainProject;
import org.proyecto.integrador.ObjetsProject.Apuesta;
import org.proyecto.integrador.ObjetsProject.Participante;
import org.proyecto.integrador.ObjetsProject.Pronostico;

import java.util.ArrayList;

public class CrearApuesta {
    public static Apuesta apuestas(Participante participante, ArrayList<Pronostico> pronosticos){

        Apuesta apuesta = new Apuesta(participante, pronosticos);
        return apuesta;
    }
}
