package org.proyecto.integrador.factory;

import org.proyecto.integrador.ObjetsProject.Equipo;
import org.proyecto.integrador.ObjetsProject.Partido;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartidoFactory {

    public static ArrayList<Partido> buildPartido(ResultSet rs) throws SQLException {
        ArrayList<Partido> partidos = new ArrayList<>();
        while (rs.next()) {
            Equipo equipo1 = new Equipo(rs.getString("equipo1"));
            int golesEquipo1 = rs.getInt("cantGoles1");
            int golesEquipo2 = rs.getInt("cantGoles2");
            Equipo equipo2 = new Equipo(rs.getString("equipo2"));
            int numeroPartido = rs.getInt("partido");
            int numeroRonda = rs.getInt("ronda");
            Partido partido = new Partido(numeroPartido, equipo1, equipo2, golesEquipo1, golesEquipo2, numeroRonda);
            partidos.add(partido);
        }
        return partidos;
    }

}



       /* HashMap<String, Participantes> participantes = new HashMap<>();
        ArrayList<Pronostico> pronosticos = new ArrayList<>();
        while (rs.next()) {
           // String nombreParticipante = rs.getString("participante");
              /*  if (participantes.get(nombreParticipante) == null){
                    nombreParticipante = rs.getString("participante");
                    Participantes participante = CreacionParticipante.creacionParticipante(nombreParticipante, null);
                    participantes.put(nombreParticipante, participante);
                    pronosticos.clear();
            }

            Partido partidoApostado = getPartidoApostado(rs, partidos);
            Pronostico pronostico = CreacionPronostico.creacionPronostico(partidoApostado,equipoDefinitivo, resultado, rs.getInt("partido"), rs.getInt("ronda"));
            pronosticos.add(pronostico);
            participantes.get(nombreParticipante).setPronosticos(pronosticos);
            participantes.get(nombreParticipante).calculoPuntos();*
        }

        for (Map.Entry<String,Participantes> entrada : participantes.entrySet()) {
            String nombre = entrada.getKey();
            Participantes dato = entrada.getValue();
            System.out.println("nombre tabla " + nombre + " nombre dato " + dato.getNombre() + " puntos " + dato.getPuntos());

        }*/




