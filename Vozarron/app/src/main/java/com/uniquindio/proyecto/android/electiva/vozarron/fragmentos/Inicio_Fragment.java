package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.uniquindio.proyecto.android.electiva.vozarron.actividades.PrincipalActivity;
import com.uniquindio.proyecto.android.electiva.vozarron.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Inicio_Fragment extends Fragment implements View.OnClickListener {

    private static final String INDICE = "indice";
    private Button btn_votar;
    private ImageButton btnImage_registrar;

    public Inicio_Fragment() {
        // Required empty public constructor
    }

    public static Inicio_Fragment newInstance(int index) {
        Inicio_Fragment fragment = new Inicio_Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt(INDICE, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);
        mostrarMensajeLog("prueba" + index);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inicio,
                container, false);
        btn_votar = (Button) view.findViewById(R.id.btn_votar);
        btn_votar.setOnClickListener(this);

        btnImage_registrar = (ImageButton) view.findViewById(R.id.btn_image_registrar);
        btnImage_registrar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        mostrarMensajeLog("El fragmento esta en pausa en este momento");
        onDestroy();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Limpieza total del fragmento
        mostrarMensajeLog("El fragmento ha sido destruido");
    }

    public static void mostrarMensajeLog(String mensaje) {
        Log.v("Mensaje", mensaje);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnImage_registrar.getId()) {
            mostrarMensajeLog("Boton registrar");
            ((PrincipalActivity)getActivity()).modificarVista(8);
        } else if (v.getId() == btn_votar.getId()) {
            mostrarMensajeLog("esta es una prueba");
            ((PrincipalActivity)getActivity()).modificarVista(7);
        }
    }
}
