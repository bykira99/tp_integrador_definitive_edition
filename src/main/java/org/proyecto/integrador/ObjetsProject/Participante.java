package org.proyecto.integrador.ObjetsProject;

import java.util.ArrayList;

public class Participante {

    private String nombre;
    private int puntos = 0;

    public Participante(String nombre) {
        this.nombre = nombre;
    }


    private int puntos() {
        puntos++;
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }
}
