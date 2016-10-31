package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

/**
 * Fragmento encargado de mostrar el listado de entrenadores
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class EntrenadoresFragment extends Fragment {

    /**
     * Vista del fragmento
     */
    private View view;

    /**
     * Indice del view pager
     */
    private static final String INDICE = "indice";

    /**
     * MEtodo constructor del fragmento entrenadores
     */
    public EntrenadoresFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo para crear una instancia del fragmento del entrenadores
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento del entrenadores
     */
    public static EntrenadoresFragment newInstance (int index) {
        EntrenadoresFragment fragment = new  EntrenadoresFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(INDICE, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);
        mostrarMensajeLog("" + index);

        return fragment;
    }

    /**
     * Metodo encargado de dibujar la interfaz del fragmento
     *
     * @param inflater           inflater
     * @param container          contenedor donde estara la interfaz
     * @param savedInstanceState estado de la instancia
     * @return retorna la vista que se va mostrar
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      //  if (view == null) {
            view = inflater.inflate(R.layout.fragment_entrenadores,
                    container, false);
       //}
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_entrenadores, container, false);
    }

    /**
     * Metodo para mostrar mensajes por consola
     *
     * @param mensaje mensaje que se desea mostrar por consola
     */
    public static void mostrarMensajeLog(String mensaje) {
        Log.v("Mensaje: ", mensaje);
    }
}
