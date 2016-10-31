package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;
import com.uniquindio.proyecto.android.electiva.vozarron.actividades.PrincipalActivity;
import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Entrenadores;

/**
 * Fragmento encargado de mostrar los datos de un entrenador
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class EntrenadorFragment extends Fragment implements View.OnClickListener {

    /**
     * variable de la imagen del entrenador
     */
    private TextView imagen;

    /**
     * Indice del view pager
     */
    private static final String INDICE = "indice";

    /**
     * Variable para el ImageButton de la lista de participantes
     */
    private ImageButton btn_image_lista_participantes;

    /**
     * Variable que almacena un entrenador cuando es selccionado
     */
    private Entrenador entrenadorSeleccionado;

    /**
     * Metodo constructo del fragmento
     */
    public EntrenadorFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo para crear una instancia del fragmento del entrenador
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento del entrenador
     */
    public static EntrenadorFragment newInstance(int index) {
        EntrenadorFragment fragment = new EntrenadorFragment();
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
        View view = inflater.inflate(R.layout.fragment_entrenador,
                container, false);

        mostrarDatosDeEntrenador(view);

        btn_image_lista_participantes = (ImageButton) view.findViewById(R.id.btn_image_lista_participantes);
        btn_image_lista_participantes.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_entrenador, container, false);
    }

    /**
     * Metodo para mostrar los datos del entrenador en el fragmento
     *
     * @param view vista del fragmento instanciada
     */
    private void mostrarDatosDeEntrenador(View view) {
        //Se trae la lista de entrenadores
        Entrenadores lista_entrenadores = new Entrenadores();
        int posicion = (int) (Math.random() * lista_entrenadores.getEntrenadores().size());
        entrenadorSeleccionado = lista_entrenadores.getEntrenadores().get(posicion);

        //se trae el id del entrenador
        TextView id = (TextView) view.findViewById(R.id.id_entrenador);
        id.setText(entrenadorSeleccionado.getId());

        //se trae el nombre del entrenador
        TextView nombre = (TextView) view.findViewById(R.id.nombre_entrenador);
        nombre.setText(entrenadorSeleccionado.getNombre());

        //se trae el genero del entrenador
        TextView genero = (TextView) view.findViewById(R.id.genero_entrenador);
        genero.setText(entrenadorSeleccionado.getGenero());

        //se trae el historial del entrenador
        TextView historial = (TextView) view.findViewById(R.id.historial_participante);
        historial.setText(entrenadorSeleccionado.getHistorial());

        //Se trae la imagen del participante
        ImageView foto = (ImageView) view.findViewById(R.id.imagen);
        String nombreImagen = entrenadorSeleccionado.getFoto();
        int res_imagen = getActivity().getResources().getIdentifier("drawable/" + nombreImagen, null, getActivity().getPackageName());
        foto.setImageResource(res_imagen);

    }

    /**
     * Metodo para mostrar mensajes por consola
     *
     * @param mensaje mensaje que se desea mostrar por consola
     */
    public static void mostrarMensajeLog(String mensaje) {
        Log.v("Mensaje", mensaje);
    }

    /**
     * Metodo encargado de capturar el evento de los botones del fragmento
     *
     * @param v vista del fragmento
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == btn_image_lista_participantes.getId()) {
            mostrarMensajeLog("Boton lista de participantes");
            ((PrincipalActivity) getActivity()).modificarVista(2);
        }
    }
}
