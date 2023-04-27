package org.proyecto.integrador.ObjetsProject;

public enum ResultadoEnum {
    GANADOR("ganador", 10), EMPATE("empate", 5), PERDEDOR("perdedor", 10);
    private final String estado;
    private final int puntos;

    ResultadoEnum(String estado, int puntos) {
    this.estado = estado;
    this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getStatus() {
        return estado;
    }

}
