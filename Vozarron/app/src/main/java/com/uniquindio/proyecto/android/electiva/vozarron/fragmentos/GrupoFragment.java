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
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.AdaptadorDeParticipante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Entrenadores;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Participantes;

import java.util.ArrayList;

/**
 * Fragmento encargado de mostrar los datos de un grupo
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class GrupoFragment extends Fragment implements AdaptadorDeParticipante.OnClickAdaptadorDeParticipante{

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
     * Variable que almacena un entrenador seleccionado
     */
    private Entrenador entrenadorSeleccionado;

    /**
     * Metodo constructor del fragmento
     */
    public GrupoFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo para crear una instancia del fragmento del grupo
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento del grupo
     */
    public static GrupoFragment newInstance (int index) {
        GrupoFragment fragment = new GrupoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(INDICE, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);

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

       // if (view==null) {
        view = inflater.inflate(R.layout.fragment_grupo,
                container, false);

        mostrarDatosGrupo(view);
    //}
       return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_grupo, container, false);
    }

    /**
     * Metodo para mostrar los datos del grupo en el fragmento
     *
     * @param view vista del fragmento instanciada
     */
    private void mostrarDatosGrupo(View view) {
        //Se trae la lista de entrenadores
        Entrenadores lista_entrenadores =  new Entrenadores();
        int posicion = (int) (Math.random() * lista_entrenadores.getEntrenadores().size());
        entrenadorSeleccionado = lista_entrenadores.getEntrenadores().get(posicion);

        //se trae el nombre del entrenador
        TextView nombre = (TextView) view.findViewById(R.id.nombre_entrenador);
        nombre.setText("Grupo "+entrenadorSeleccionado.getNombre());

        //Se trae la imagen del participante
        ImageView foto = (ImageView) view.findViewById(R.id.imagen);
        int res_imagen = entrenadorSeleccionado.getFoto();
        foto.setImageResource(res_imagen);

    }

    /**
     * Metodo para mostrar mensajes por consola
     *
     * @param mensaje mensaje que se desea mostrar por consola
     */
    public static void mostrarMensajeLog(String mensaje) {
        Log.v("Mensaje: ", mensaje);
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
