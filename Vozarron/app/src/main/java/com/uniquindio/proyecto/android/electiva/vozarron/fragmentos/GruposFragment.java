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
import com.uniquindio.proyecto.android.electiva.vozarron.util.AdaptadorDeGrupo;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Entrenadores;

import java.util.ArrayList;

/**
 * Fragmento encargado de mostrar los datos de un grupos
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class GruposFragment extends Fragment implements AdaptadorDeGrupo.OnClickAdaptadorDeGrupo{

    /**
     * Variable que contiene el listado de los grupos
     */
    private ArrayList<Entrenador> grupos;

    /**
     * Variable del adaptador de grupo
     */
    private AdaptadorDeGrupo adaptador;

    /**
     * RecyclerView del listado de grupos
     */
    private RecyclerView listadoDeGrupos;

    /**
     * Escuchador para cuando un grupo es seleccionado
     */
    private OnGrupoSeleccionadoListener listener;

    /**
     * Indice del view pager
     */
    private static final String INDICE = "indice";

    /**
     * Variable que guarda la vista del fragmento
     */
    private View view;

    /**
     * Metodo constructor del fragmento
     */
    public GruposFragment() {

    }

    /**
     * Metodo para crear una instancia del fragmento del grupos
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento del grupos
     */
    public static GruposFragment newInstance (int index) {
            GruposFragment fragment = new GruposFragment();
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
       // if (view == null) {
            view = inflater.inflate(R.layout.fragment_grupos,
                    container, false);
        //}
        return view;

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_grupos, container, false);
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
        listener.onGrupoSeleccionado(pos);

    }

    /**
     * Metodo encargado de administrar el listado de grupos y el adaptador
     *
     * @param savedInstanceState instancia estado
     */
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Se ha completado el onCreate de la actividad
        //  if (getView()!= null)
        listadoDeGrupos = (RecyclerView) getView().findViewById(R.id.listaGrupos);
        grupos = new ArrayList<>();

        Entrenadores lista = new Entrenadores();

        grupos.addAll(lista.getEntrenadores());

        adaptador = new AdaptadorDeGrupo(grupos, this);
        listadoDeGrupos.setAdapter(adaptador);
        listadoDeGrupos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    /**
     * Interface escuchado del grupo seleccionado
     */
    public interface OnGrupoSeleccionadoListener {
        void onGrupoSeleccionado(int position);
    }

    /**
     * Metodo para asociar el contexto con la actividad
     * @param context contexto
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            try {
                listener = (OnGrupoSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnEntrenadorSeleccionadoListener");
            }
        }
    }
}
