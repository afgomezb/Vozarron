package com.uniquindio.proyecto.android.electiva.vozarron.util;

import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;

import java.util.ArrayList;

/**
 * Created by USUARIO WINDOWS on 30/10/2016.
 */
public class Participantes {

    /**
     * Llstado de participantes del concurso
     */
    private ArrayList<Participante> participantes = new ArrayList<>();

    /**
     * Metodo constructor de la clase participantes
     */
    public Participantes() {

        Participante participante = new Participante("Valentina", 22, new Entrenador(),"Activo", "Estudiante", "valentina", "https://www.youtube.com/watch?v=OT7AiM-vzks");
        participante.getEntrenador().setNombre("Jhonny");
        participantes.add(participante);

        Participante participante2 = new Participante("Andres", 22, new Entrenador(),"Activo", "Estudiante", "andres", "https://www.youtube.com/watch?v=RhoyUZDeBcQ");
        participante2.getEntrenador().setNombre("Jhonny");
        participantes.add(participante2);

        Participante participante3 = new Participante("Melissa", 23, new Entrenador(),"Activo", "Estudiante", "melissa", "https://www.youtube.com/watch?v=OT7AiM-vzks");
        participante3.getEntrenador().setNombre("Jhonny");
        participantes.add(participante3);

        Participante participante4 = new Participante("Jose", 23, new Entrenador(),"Eliminado", "Docente", "jose", "https://www.youtube.com/watch?v=8z9cZD7AMF8");
        participante4.getEntrenador().setNombre("Rihanna");
        participantes.add(participante4);

        Participante participante5 = new Participante("Jorge", 23, new Entrenador(),"Activo", "Estudiante", "jorge", "https://www.youtube.com/watch?v=8z9cZD7AMF8");
        participante5.getEntrenador().setNombre("Rihanna");
        participantes.add(participante5);

        Participante participante6 = new Participante("Mario", 23, new Entrenador(),"Activo", "Docente", "mario", "https://www.youtube.com/watch?v=8z9cZD7AMF8");
        participante6.getEntrenador().setNombre("Rihanna");
        participantes.add(participante6);

        Participante participante7 = new Participante("Pablo", 23, new Entrenador(),"Eliminado", "Estudiante", "pablo", "https://www.youtube.com/watch?v=RhoyUZDeBcQ");
        participante7.getEntrenador().setNombre("Rihanna");
        participantes.add(participante7);

        Participante participante8 = new Participante("Luisa", 23, new Entrenador(),"Activo", "Estudiante", "luisa", "https://www.youtube.com/watch?v=RhoyUZDeBcQ");
        participante8.getEntrenador().setNombre("Adele");
        participantes.add(participante8);

        Participante participante9 = new Participante("Rosa", 23, new Entrenador(),"Eliminado", "Estudiante", "rosa", "https://www.youtube.com/watch?v=OT7AiM-vzks");
        participante9.getEntrenador().setNombre("Adele");
        participantes.add(participante9);

        Participante participante10 = new Participante("Juana", 23, new Entrenador(),"Activo", "Docente", "juana", "https://www.youtube.com/watch?v=RhoyUZDeBcQ");
        participante10.getEntrenador().setNombre("Adele");
        participantes.add(participante10);

    }

    /**
     * Metodo para acceder a la lista de participantes del concurso
     *
     * @return listado de participantes del concurso
     */
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    /**
     * Metodo para modificar la lista de participantes del concurso
     *
     * @param participantes nuevo listado de participantes del concurso
     */
    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    /**
     * Metodo para buscar un participante del concurso por su nombre
     *
     * @param nombre nombre del participante que se desea buscar
     * @return participante
     */
    public Participante buscarParticipantePorNombre(String nombre) {
        for (int i = 0; i < participantes.size(); i++) {
            if (participantes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return participantes.get(i);
            }
        }
        return null;
    }

    public String[] traerNombresDePartcipantes () {
        String nombreParticipantes [] = new String[participantes.size()];
        for (int i = 0; i < participantes.size(); i++) {
            nombreParticipantes[i]=participantes.get(i).getNombre();

        }
        return nombreParticipantes;
    }

    public Participante buscarParticipantePorPosicion(int posicion) {
        if (participantes.size()>0)
            return participantes.get(posicion);
        return null;
    }
}
