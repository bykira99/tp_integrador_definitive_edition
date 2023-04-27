package org.proyecto.integrador.ObjetsProject;

import java.util.ArrayList;

public class Ronda {
    private int numeroRonda;
    private ArrayList<Partido> partidos;

    public Ronda(int numeroRonda, ArrayList<Partido> partidos) {
        this.numeroRonda = numeroRonda;
        this.partidos = partidos;
    }
}
