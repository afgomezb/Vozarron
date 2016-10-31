package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
 * Fragmento encargado de representar el listado de entrenadores
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class ListaDeEntrenadoresFragment extends Fragment implements AdaptadorDeEntrenador.OnClickAdaptadorDeEntrenador {

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
     * Metodo constructor del listado de entrenadores fragment
     */
    public ListaDeEntrenadoresFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo encargado de inicializar los elemtos del fragmento
     *
     * @param savedInstanceState instancia del estado
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_entrenadores, container, false);
    }

    /**
     * Metodo para guardar el entrenador selecionado
     *
     * @param pos posicion del entrenador seleccionado dentro de la lista
     */
    @Override
    public void onClickPosition(int pos) {
        listener.onEntrenadorSeleccionado(pos);
    }

    /**
     * Metodo encargado de administrar el listado de entrenadores y el adaptador
     *
     * @param savedInstanceState instancia estado
     */
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Se ha completado el onCreate de la actividad
        //  if (getView()!= null)
        listadoDeEntrenadores = (RecyclerView) getView().findViewById(R.id.listaEntrenadores);
        entrenadores = new ArrayList<>();

        Entrenadores lista = new Entrenadores();

        entrenadores.addAll(lista.getEntrenadores());

        adaptador = new AdaptadorDeEntrenador(entrenadores, this);
        listadoDeEntrenadores.setAdapter(adaptador);
        listadoDeEntrenadores.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    /**
     * Interface escuchador del entrenador seleccionado
     */
    public interface OnEntrenadorSeleccionadoListener {
        void onEntrenadorSeleccionado(int position);
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
     * @param mensaje mensaje que se desea mostrar
     */
    public static void mostrarMensajeLog(String mensaje) {
        Log.v("Mensaje: ", mensaje);
    }
}
