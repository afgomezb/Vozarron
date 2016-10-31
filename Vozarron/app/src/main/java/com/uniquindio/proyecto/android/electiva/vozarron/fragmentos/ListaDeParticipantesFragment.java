package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.AdaptadorDeParticipante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Participantes;

import java.util.ArrayList;

/**
 * Fragmento encargado de representar el listado de participantes
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class ListaDeParticipantesFragment extends Fragment implements AdaptadorDeParticipante.OnClickAdaptadorDeParticipante {

    /**
     * Variable que contiene el listado de los participantes
     */
    private ArrayList<Participante> participantes;

    /**
     * Variable del adaptador de participante
     */
    private AdaptadorDeParticipante adaptador;

    /**
     * RecyclerView del listado de participantes
     */
    private RecyclerView listadoDeParticipantes;

    /**
     * Escuchador para cuando un participante es seleccionado
     */
    private OnParticipanteSeleccionadoListener listener;

    /**
     * Metodo constructor del listado de particpantes fragment
     */
    public ListaDeParticipantesFragment() {
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
        return inflater.inflate(R.layout.fragment_lista_de_participantes, container, false);
    }

    /**
     * Metodo para guardar el participante selecionado
     *
     * @param pos posicion del participante seleccionado dentro de la lista
     */
    @Override
    public void onClickPosition(int pos) {
        listener.onParticipanteSeleccionado(pos);
    }

    /**
     * Metodo encargado de administrar el listado de participantes y el adaptador
     *
     * @param savedInstanceState instancia estado
     */
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Se ha completado el onCreate de la actividad
        listadoDeParticipantes = (RecyclerView) getView().findViewById(R.id.listaParticipantes);
        participantes = new ArrayList<>();

        Participantes lista = new Participantes();

        participantes.addAll(lista.getParticipantes());

        adaptador = new AdaptadorDeParticipante(participantes, this);
        listadoDeParticipantes.setAdapter(adaptador);
        listadoDeParticipantes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }


    /**
     * Interface escuchado del grupo seleccionado
     */
    public interface OnParticipanteSeleccionadoListener {
        void onParticipanteSeleccionado(int position);
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
                listener = (OnParticipanteSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnParticipantePersonajeSeleccionadoListener");
            }
        }
    }

}
