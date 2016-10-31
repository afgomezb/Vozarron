package com.uniquindio.proyecto.android.electiva.vozarron.actividades;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.ListaDeEntrenadoresFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.ListaDeGruposFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.ListaDeParticipantesFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.util.AdaptadoDePagerFragmet;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Participantes;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity implements ListaDeParticipantesFragment.OnParticipanteSeleccionadoListener, ListaDeEntrenadoresFragment.OnEntrenadorSeleccionadoListener, ListaDeGruposFragment.OnGrupoSeleccionadoListener, View.OnClickListener {

    private ViewPager viewPager;

    private Participante participanteSeleccionado;

    private ArrayList<Participante> participantes = new ArrayList<>();

    private AdaptadoDePagerFragmet adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        adapter = new AdaptadoDePagerFragmet(
                getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new AdaptadoDePagerFragmet(
                getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onParticipanteSeleccionado(int position) {
        Participantes lista = new Participantes();
        participanteSeleccionado = lista.buscarParticipantePorPosicion(position);
        mostrarMensaje("Participante seleccionado----> "+participanteSeleccionado.getNombre());
        if(participanteSeleccionado != null) {
            mostrarMensaje("PArticipante enviado al adaptador"+participanteSeleccionado.getNombre());
            adapter.setPartiSeleccionado(participanteSeleccionado);
        }
        modificarVista(5);
    }

    public void modificarVista(int nVista){
        viewPager.setCurrentItem(nVista);
    }

    @Override
    public void onClick(View v) {


    }
    public static void mostrarMensaje(String mensaje) {
        Log.v("Mensaje", mensaje);
    }

    @Override
    public void onEntrenadorSeleccionado(int position) {
        modificarVista(6);
    }

    @Override
    public void onGrupoSeleccionado(int position) {
        modificarVista(4);
    }

    public Participante getParticipanteSeleccionado() {
        return participanteSeleccionado;
    }

    public void setParticipanteSeleccionado(Participante participanteSeleccionado) {
        this.participanteSeleccionado = participanteSeleccionado;
    }
}
