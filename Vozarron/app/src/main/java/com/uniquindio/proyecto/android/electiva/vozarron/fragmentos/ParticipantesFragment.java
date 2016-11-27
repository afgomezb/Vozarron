package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.AdaptadorDeParticipante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.ConexionServicioWeb;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Utilidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragmento encargado de mostrar los datos de los participantes
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class ParticipantesFragment extends Fragment implements AdaptadorDeParticipante.OnClickAdaptadorDeParticipante {

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
    public ParticipantesFragment() {
        // Required empty public constructor
    }

    public List<Participante> lista_participantes = new ArrayList<>();

    /**
     * Metodo para crear una instancia del fragmento del participantes
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento del participantes
     */
    public static ParticipantesFragment newInstance(int index) {
        ParticipantesFragment fragment = new ParticipantesFragment();
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

        // mapFragment.getMapAsync(callback);
        // if(view == null) {

        view = inflater.inflate(R.layout.fragment_participantes,
                container, false);

        //}

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_participantes, container, false);
        return view;
    }

    /**
     * Metodo para mostrar mensajes por consola
     *
     * @param mensaje mensaje que se desea mostrar por consola
     */
    public static void mostrarMensajeLog(String mensaje) {
        Log.v("MyClonFragment", mensaje);
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
       // participantes = new ArrayList<>();

        HiloSecundario hiloSecundario = new HiloSecundario(this.getContext(),listadoDeParticipantes);
        hiloSecundario.execute(Utilidades.LISTAR);


       // Participantes lista = new Participantes();

        //participantes.addAll(lista.getParticipantes());

        //adaptador = new AdaptadorDeParticipante(participantes, this);
        //listadoDeParticipantes.setAdapter(adaptador);
        //listadoDeParticipantes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
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

    public class HiloSecundario extends AsyncTask<Integer, Integer, Integer> {

        private ProgressDialog progress;
        private Context context;
        private Participante participante;
        private ArrayList<Participante> participantes = new ArrayList<>();
        private RecyclerView listadoDeParticipantes;


        public HiloSecundario(Context context, RecyclerView listadoDeParticipantes) {
            this.context = context;
            participante = null;
            this.listadoDeParticipantes = listadoDeParticipantes;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress = ProgressDialog.show(context, context.getString(R.string.cargando_participante),
                    context.getString(R.string.esperar), true);
        }

        @Override
        protected Integer doInBackground(Integer... params) {

            if (params[0] == Utilidades.LISTAR)
                setParticipantes(ConexionServicioWeb.getListaDePartcipantes());


            return params[0];
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            progress.dismiss();

            if(integer == Utilidades.LISTAR){

                if(adaptador==null)
                    adaptador = new AdaptadorDeParticipante(participantes, ParticipantesFragment.this);

                listadoDeParticipantes.setAdapter(adaptador);
                listadoDeParticipantes.setLayoutManager(new
                        LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }


        }

        public Participante getParticipante() {
            return participante;
        }

        public void setParticipante(Participante participante) {
            this.participante = participante;
        }

        public List<Participante> getParticipantes() {
            return participantes;
        }

        public void setParticipantes(ArrayList<Participante> participantes) {
            this.participantes = participantes;
        }
    }

}
