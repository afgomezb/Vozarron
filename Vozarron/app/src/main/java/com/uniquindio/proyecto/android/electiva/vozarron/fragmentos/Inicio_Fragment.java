package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.actividades.PrincipalActivity;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Utilidades;

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
     * Variable para el icono de la conexion
     */
    private ImageButton icono_conexion;

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

        icono_conexion = (ImageButton) view.findViewById(R.id.conexion);
        icono_conexion.setOnClickListener(this);

        mostrarComprobacionDeConexion();

        return view;
    }

    /**
     * MEtodo para mostrar si la aplicacion tiene conexcion a internet y modificar el icono de la conexion
     */
    public void mostrarComprobacionDeConexion () {

        boolean conexion=compruebaConexion(this.getContext());

        if (!conexion) {
            mostrarMensaje(getContext(), "Sin conexion a internet");
            icono_conexion.setImageResource(R.mipmap.ic_sin_conexion);
        } else {
            mostrarMensaje(getContext(), "Conectado a internet");
            icono_conexion.setImageResource(R.mipmap.ic_conexion);
        }
    }


    /**
     * Función para comprobar si hay conexión a Internet
     * @param context
     * @return boolean
     */
    public static boolean compruebaConexion(Context context) {

        boolean connected = false;

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }

    /**
     * Metodo encargado de mostrar mensajes
     *
     * @param message Mensaje que se desea mostrar
     */
    public static void mostrarMensaje(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
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
            Utilidades.cambiarIdioma(getContext());
            Intent intent = getActivity().getIntent();
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().finish();
            startActivity(intent);
        } else if (v.getId() == icono_conexion.getId()) {
            mostrarComprobacionDeConexion();
        }
    }
}
