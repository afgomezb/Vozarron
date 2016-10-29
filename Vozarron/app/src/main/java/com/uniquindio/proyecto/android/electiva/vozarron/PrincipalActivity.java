package com.uniquindio.proyecto.android.electiva.vozarron;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import VO.Participante;
import fragmentos.ListaDeEntrenadoresFragment;
import fragmentos.ListaDeGruposFragment;
import fragmentos.ListaDeParticipantesFragment;
import util.AdaptadoDePagerFragmet;

public class PrincipalActivity extends AppCompatActivity implements ListaDeParticipantesFragment.OnParticipanteSeleccionadoListener, ListaDeEntrenadoresFragment.OnEntrenadorSeleccionadoListener, ListaDeGruposFragment.OnGrupoSeleccionadoListener, View.OnClickListener {

    private ViewPager viewPager;
    private ArrayList<Participante> participantes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        AdaptadoDePagerFragmet adapter = new AdaptadoDePagerFragmet(
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
}
