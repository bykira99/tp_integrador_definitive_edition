package org.proyecto.integrador.factory;

import org.proyecto.integrador.ObjetsProject.Equipo;
import org.proyecto.integrador.ObjetsProject.Partido;
import org.proyecto.integrador.ObjetsProject.Pronostico;
import org.proyecto.integrador.ObjetsProject.ResultadoEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PronosticoFactory {
    public static ArrayList<Pronostico> buildPronostico(ResultSet rs) throws SQLException {

        ArrayList<Pronostico> pronosticos = new ArrayList<>();
        while (rs.next()) {
            Partido partido = new Partido(rs.getInt("partido"), new Equipo(rs.getString("equipo1")), new Equipo(rs.getString("equipo2")), rs.getInt("ronda"));
            Equipo equipoDefinitivo = getEquipoDefinitivo(rs);
            ResultadoEnum resultado = getResultado(rs, equipoDefinitivo);
            Pronostico pronostico = new Pronostico(partido, equipoDefinitivo, resultado);
            pronosticos.add(pronostico);
        }
        return pronosticos;
    }


    private static ResultadoEnum getResultado(ResultSet rs, Equipo equipoDefinitivo) throws SQLException {
        ResultadoEnum resultado = null;
        if (equipoDefinitivo.getNombre() != null) {
            if (equipoDefinitivo.getNombre().equals(rs.getString("equipo1")) || equipoDefinitivo.getNombre().equals(rs.getString("equipo2"))) {
                resultado = ResultadoEnum.GANADOR;
            } else {
                resultado = null;
            }
        } else {
            resultado = ResultadoEnum.EMPATE;
        }
        return resultado;
    }

    private static Equipo getEquipoDefinitivo(ResultSet rs) throws SQLException {
        Equipo equipoDefinitivo = equipoPronosticado(rs.getString("equipo1"), rs.getInt("gana1"), rs.getInt("empata"), rs.getInt("gana2"), rs.getString("equipo2"));
        return equipoDefinitivo;
    }
    private static Equipo equipoPronosticado(String nombre1, int gana1, int empata, int gana2, String nombre2) {
        String nombre = null;
        if(gana1 == 1){
            nombre = nombre1;
        } else if(gana2 == 1){
            nombre = nombre2;
        } else if(empata == 1){
            nombre = nombre1;
        }
        Equipo equipo = new Equipo(nombre);
        return equipo;
    }

}
