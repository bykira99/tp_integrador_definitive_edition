package org.proyecto.integrador.factory;

import org.proyecto.integrador.ObjetsProject.Equipo;
import org.proyecto.integrador.ObjetsProject.Partido;
import org.proyecto.integrador.ObjetsProject.Ronda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RondaFactory {
    public static ArrayList<Ronda> buildRondas(ResultSet rs) throws SQLException {
        ArrayList<Partido> partidos = new ArrayList<>();
        ArrayList<Ronda> rondas = new ArrayList<>();
        int numeroRonda = 1;
        while (rs.next()) {
            if (numeroRonda < rs.getInt("ronda")) {
                rondas.add(new Ronda(numeroRonda, partidos));
                numeroRonda++;
                partidos.clear();
            }
            buildPartido(rs, partidos);
        }
        return rondas;
    }

    private static void buildPartido(ResultSet rs, ArrayList<Partido> partidos) throws SQLException {
        int numeroRonda;
        numeroRonda = rs.getInt("ronda");
        Equipo equipo1 = new Equipo(rs.getString("equipo1"));
        Equipo equipo2 = new Equipo(rs.getString("equipo2"));
        int numeroPartido = rs.getInt("partido");
        Partido partido = new Partido(numeroPartido, equipo1, equipo2, numeroRonda);
        partidos.add(partido);
    }


}
