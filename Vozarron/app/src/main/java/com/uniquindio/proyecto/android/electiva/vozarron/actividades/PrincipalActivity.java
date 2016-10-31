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

/**
 * Clase que representa la actividad principal de la aplicacion, esta contiene los diferentes fragmentos del menu
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class PrincipalActivity extends AppCompatActivity implements ListaDeParticipantesFragment.OnParticipanteSeleccionadoListener, ListaDeEntrenadoresFragment.OnEntrenadorSeleccionadoListener, ListaDeGruposFragment.OnGrupoSeleccionadoListener, View.OnClickListener {

    /**
     * ViewPager
     */
    private ViewPager viewPager;

    /**
     * Personaje seleccionado
     */
    private Participante participanteSeleccionado;

    /**
     * Adaptador de view pager
     */
    private AdaptadoDePagerFragmet adapter;

    /**
     * Metodo encargado de inicializar los elementos que se asociados a esta vista
     *
     * @param savedInstanceState instancia
     */
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

    /**
     * Metodo para guardar un participante que es seleccionado de una lista
     *
     * @param position posicion del participante seleccionado en la lista
     */
    @Override
    public void onParticipanteSeleccionado(int position) {
        Participantes lista = new Participantes();
        participanteSeleccionado = lista.buscarParticipantePorPosicion(position);
        mostrarMensaje("Participante seleccionado----> " + participanteSeleccionado.getNombre());
        if (participanteSeleccionado != null) {
            mostrarMensaje("PArticipante enviado al adaptador" + participanteSeleccionado.getNombre());
            adapter.setPartiSeleccionado(participanteSeleccionado);
        }
        modificarVista(5);
    }

    /**
     * Metodo para mostrar una vista especifica del view pager
     *
     * @param nVista numero de la vista que se desea mostrar
     */
    public void modificarVista(int nVista) {
        viewPager.setCurrentItem(nVista);
    }

    /**
     * Metodo para capturar el evento de los botones utilizados
     *
     * @param v vista que contiene los ids de los botones
     */
    @Override
    public void onClick(View v) {

    }

    /**
     * Metodo para mostrar un mensaje por consola
     *
     * @param mensaje mensaje que se deesea mostrar
     */
    public static void mostrarMensaje(String mensaje) {
        Log.v("Mensaje", mensaje);
    }

    /**
     * Metodo para guardar un entrenador que es seleccionado de una lista
     *
     * @param position posicion del entrenador seleccionado en la lista
     */
    @Override
    public void onEntrenadorSeleccionado(int position) {
        modificarVista(6);
    }

    /**
     * Metodo para guardar un grupo que es seleccionado de una lista
     *
     * @param position posicion del grupo seleccionado en la lista
     */
    @Override
    public void onGrupoSeleccionado(int position) {
        modificarVista(4);
    }

    /**
     * MEtodo que retorna el participante seleccionado en la lista
     *
     * @return participante seleccionado
     */
    public Participante getParticipanteSeleccionado() {
        return participanteSeleccionado;
    }

    /**
     * Metodo encargado de modificar el valor de la variable participanteSeleccionado
     *
     * @param participanteSeleccionado nuevo valor de la variable participanteSeleccinado
     */
    public void setParticipanteSeleccionado(Participante participanteSeleccionado) {
        this.participanteSeleccionado = participanteSeleccionado;
    }
}
