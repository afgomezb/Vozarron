package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;
import com.uniquindio.proyecto.android.electiva.vozarron.util.AdaptadorDeEntrenador;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Entrenadores;

import java.util.ArrayList;

/**
 * Fragmento encargado de mostrar el listado de entrenadores
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class EntrenadoresFragment extends Fragment implements AdaptadorDeEntrenador.OnClickAdaptadorDeEntrenador{

    /**
     * Vista del fragmento
     */
    private View view;

    /**
     * Indice del view pager
     */
    private static final String INDICE = "indice";

    /**
     * Variable que contiene el listado de los entrenadores
     */
    private ArrayList<Entrenador> entrenadores;

    /**
     * Variable del adaptador de entrenadores
     */
    private AdaptadorDeEntrenador adaptador;

    /**
     * RecyclerView del listado de entrenadores
     */
    private RecyclerView listadoDeEntrenadores;

    /**
     * Escuchador para cuando un entrenador es seleccionado
     */
    private OnEntrenadorSeleccionadoListener listener;

    /**
     * MEtodo constructor del fragmento entrenadores
     */
    public EntrenadoresFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo para crear una instancia del fragmento de entrenadores
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento de entrenadores
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listadoDeEntrenadores = (RecyclerView) getView().findViewById(R.id.listaEntrenadores);
        entrenadores = new ArrayList<>();

        Entrenadores lista = new Entrenadores();

        entrenadores.addAll(lista.getEntrenadores());

        adaptador = new AdaptadorDeEntrenador(entrenadores, this);
        listadoDeEntrenadores.setAdapter(adaptador);
        listadoDeEntrenadores.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    /**
     * Metodo para asociar el contexto con la actividad
     *
     * @param context contexto
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            try {
                listener = (OnEntrenadorSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnEntrenadorSeleccionadoListener");
            }
        }
    }


    /**
     * Metodo para mostrar mensajes por consola
     *
     * @param mensaje mensaje que se desea mostrar por consola
     */
    public static void mostrarMensajeLog(String mensaje) {
        Log.v("Mensaje: ", mensaje);
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onEntrenadorSeleccionado(pos);
    }

    /**
     * Interface escuchador del entrenador seleccionado
     */
    public interface OnEntrenadorSeleccionadoListener {
        void onEntrenadorSeleccionado(int position);
    }

}
