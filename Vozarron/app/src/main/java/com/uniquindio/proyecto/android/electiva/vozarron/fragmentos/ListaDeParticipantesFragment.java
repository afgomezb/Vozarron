package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.AdaptadorDeParticipante;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeParticipantesFragment extends Fragment implements AdaptadorDeParticipante.OnClickAdaptadorDeParticipante{


    private ArrayList<Participante> participantes;
    private AdaptadorDeParticipante adaptador;
    private RecyclerView listadoDeParticipantes;
    private OnParticipanteSeleccionadoListener listener;

    public ListaDeParticipantesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_participantes, container, false);
    }

    @Override
    public void onClickPosition(int pos) {

        listener.onParticipanteSeleccionado(pos);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Se ha completado el onCreate de la actividad
        listadoDeParticipantes = (RecyclerView) getView().findViewById(R.id.listaParticipantes);
        participantes= new ArrayList<>();
        Participante participante = new Participante("Valentina", 22, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante);
        Participante participante2 = new Participante("Andres", 22, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante2);
        Participante participante3 = new Participante("Melissa", 23, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante3);
        Participante participante4 = new Participante("Jose", 23, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante4);
        Participante participante5 = new Participante("Jorge", 23, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante5);
        Participante participante6 = new Participante("Mario", 23, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante6);
        Participante participante7 = new Participante("Pablo", 23, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante7);
        Participante participante8 = new Participante("Luisa", 23, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante8);
        Participante participante9 = new Participante("Rosa", 23, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante9);
        Participante participante10 = new Participante("Juana", 23, new Entrenador(), "Estudiante","foto", "video");
        participantes.add(participante10);
        adaptador = new AdaptadorDeParticipante(participantes, this);
        listadoDeParticipantes.setAdapter(adaptador);
        listadoDeParticipantes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public interface OnParticipanteSeleccionadoListener {
        void onParticipanteSeleccionado(int position);
    }


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

    public ArrayList<Participante> getPersonajes() {
        return participantes;
    }

    public void setPersonajes(ArrayList<Participante> personajes) {
        this.participantes = personajes;
    }

}
