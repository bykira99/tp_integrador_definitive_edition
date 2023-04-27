package org.proyecto.integrador.ObjetsProject;

import java.util.HashMap;
import java.util.Objects;

public class Partido {

    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int numeroPartido;
    private int numeroRonda;
    private HashMap<String, ResultadoEnum> resultadoEquipos = new HashMap();


    public Partido(int numeroPartido, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, int numeroRonda) {
        this.numeroPartido = numeroPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.numeroRonda = numeroRonda;
        calculoResultado();
    }
    public Partido(int numeroPartido, Equipo equipo1, Equipo equipo2, int numeroRonda){
        this.numeroPartido = numeroPartido;
        this.numeroRonda = numeroRonda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public int getNumeroPartido() {
        return numeroPartido;
    }

    public ResultadoEnum resultado(Equipo equipo) {
        return resultadoEquipos.get(equipo.getNombre());
    }

    private void calculoResultado() {
        if (golesEquipo1 == golesEquipo2) {
            resultadoEquipos.put(equipo1.getNombre(), ResultadoEnum.EMPATE);
            resultadoEquipos.put(equipo2.getNombre(), ResultadoEnum.EMPATE);
        } else if (golesEquipo1 > golesEquipo2) {
                resultadoEquipos.put(equipo1.getNombre(), ResultadoEnum.GANADOR);
                resultadoEquipos.put(equipo2.getNombre(), ResultadoEnum.PERDEDOR);
        } else if (golesEquipo1 < golesEquipo2) {
                resultadoEquipos.put(equipo1.getNombre(), ResultadoEnum.PERDEDOR);
                resultadoEquipos.put(equipo2.getNombre(), ResultadoEnum.GANADOR);
        }
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public HashMap<String, ResultadoEnum> getResultadoEquipos() {
        return resultadoEquipos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return  numeroPartido == partido.numeroPartido && numeroRonda == partido.numeroRonda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPartido, numeroRonda);
    }
}
