package com.uniquindio.proyecto.android.electiva.vozarron.util;

import android.os.AsyncTask;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;

import java.util.ArrayList;

/**
 * Created by USUARIO WINDOWS on 30/10/2016.
 */
public class Entrenadores {

    private ArrayList <Entrenador> entrenadores = new ArrayList<>();

    public Entrenadores() {
        Entrenador entre = new Entrenador("00001", "Jhonny Rivera", "Despecho", "Nacido en Pereira, Colombia.", R.drawable.jhonny);
        entrenadores.add(entre);

        Entrenador entre2 = new Entrenador("00002", "Rihanna", "Pop", "Cantante, actriz y diseñadora de moda.", R.drawable.rihanna);
        entrenadores.add(entre2);

        Entrenador entre3 = new Entrenador("00003", "Adele", "Pop", "Cantante y compositora británica.", R.drawable.adele);
        entrenadores.add(entre3);
    }

    public Entrenador buscarPorNombre (String nombre) {
        for (int i=0; i<entrenadores.size();i++) {
            if (entrenadores.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return entrenadores.get(i);
            }
        }
        return null;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public String[] traerNombresDeEntrenadores () {
        String nombreEntrenadores [] = new String[entrenadores.size()];
        for (int i = 0; i < entrenadores.size(); i++) {
            nombreEntrenadores[i]=entrenadores.get(i).getNombre();

        }
        return nombreEntrenadores;
    }


}
