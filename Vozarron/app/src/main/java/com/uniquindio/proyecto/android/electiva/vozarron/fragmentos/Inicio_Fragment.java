package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.actividades.PrincipalActivity;

/**
 * Fragmento encargado de mostrar los datos del inicio de la aplicacion
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class Inicio_Fragment extends Fragment implements View.OnClickListener {

    /**
     * Indice del view pager
     */
    private static final String INDICE = "indice";

    /**
     * Variable para el boton que redirije a la vista votar
     */
    private Button btn_votar;

    /**
     * Variable para el imagen boton registrar
     */
    private ImageButton btnImage_registrar;

    /**
     * Variable para el imagen boton internacionalizacion
     */
    private ImageButton btn_image_internacionalizacion;

    /**
     * Metodo constructor del fragmento
     */
    public Inicio_Fragment() {
        // Required empty public constructor
    }

    /**
     * Metodo para crear una instancia del fragmento delinicio
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento del inicio
     */
    public static Inicio_Fragment newInstance(int index) {
        Inicio_Fragment fragment = new Inicio_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt(INDICE, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);
        mostrarMensajeLog("prueba" + index);

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
        View view = inflater.inflate(R.layout.fragment_inicio,
                container, false);
        btn_votar = (Button) view.findViewById(R.id.btn_votar);
        btn_votar.setOnClickListener(this);

        btnImage_registrar = (ImageButton) view.findViewById(R.id.btn_image_registrar);
        btnImage_registrar.setOnClickListener(this);

        btn_image_internacionalizacion = (ImageButton) view.findViewById(R.id.btn_image_internacionalizacion);
        btn_image_internacionalizacion.setOnClickListener(this);

        return view;
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
     * Metodo que captura los eventos de los botones de la vista
     * @param v vista que contiene los botones
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == btnImage_registrar.getId()) {
            mostrarMensajeLog("Boton registrar");
            ((PrincipalActivity)getActivity()).modificarVista(8);
        } else if (v.getId() == btn_votar.getId()) {
            mostrarMensajeLog("esta es una prueba");
            ((PrincipalActivity)getActivity()).modificarVista(7);
        } else if (v.getId() == btn_image_internacionalizacion.getId()) {
            mostrarMensajeLog("ImageButton para la internacionalizacion");
        }
    }
}
