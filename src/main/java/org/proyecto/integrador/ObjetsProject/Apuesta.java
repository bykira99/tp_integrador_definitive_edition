package org.proyecto.integrador.ObjetsProject;

import java.util.ArrayList;

public class Apuesta {
    private Participante participante;
    private ArrayList<Pronostico> pronosticos;
    private int puntos = 0;
    private int aciertos = 0;

    public Apuesta(Participante participante, ArrayList<Pronostico> pronosticos) {
        this.participante = participante;
        this.pronosticos = pronosticos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getPuntos(){
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Participante getParticipante() {
        return participante;
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

}
