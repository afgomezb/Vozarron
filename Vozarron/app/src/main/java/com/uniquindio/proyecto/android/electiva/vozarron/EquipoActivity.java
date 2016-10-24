package com.uniquindio.proyecto.android.electiva.vozarron;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import VO.Entrenador;
import VO.Participante;
import fragmentos.ListaDeParticipantesFragment;

public class EquipoActivity extends AppCompatActivity {

    private RecyclerView listadoDeParticipantes;

    private ArrayList<Participante> participantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        participantes = new ArrayList();
        participantes.add(new Participante("Valentina", 22, new Entrenador(), "Estudiante", "Foto", "Video"));
        participantes.add(new Participante("Melissa", 22, new Entrenador(), "Estudiante", "Foto", "Video"));
        participantes.add(new Participante("Liliana", 22, new Entrenador(), "Estudiante", "Foto", "Video"));
        participantes.add(new Participante("Martha", 22, new Entrenador(), "Estudiante", "Foto", "Video"));
        listadoDeParticipantes = (RecyclerView) findViewById(R.id.listaParticipantes);

        ListaDeParticipantesFragment listaDePersonajesFragment = (ListaDeParticipantesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participantes);
        listaDePersonajesFragment.setPersonajes(participantes);
    }
}
