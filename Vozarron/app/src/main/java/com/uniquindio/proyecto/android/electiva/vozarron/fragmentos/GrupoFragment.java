package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Entrenadores;

/**
 * Fragmento encargado de mostrar los datos de un grupo
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class GrupoFragment extends Fragment {

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
        Log.v("Mensaje: ", mensaje);
    }

}
