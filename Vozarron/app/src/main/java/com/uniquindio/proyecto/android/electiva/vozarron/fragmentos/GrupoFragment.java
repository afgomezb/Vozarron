package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrupoFragment extends Fragment {

    private static final String INDICE = "indice";
    private View view;

    public GrupoFragment() {
        // Required empty public constructor
    }

    public static GrupoFragment newInstance (int index) {
        GrupoFragment fragment = new GrupoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(INDICE, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);
        mostrarMensajeLog("" + index);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
       // if (view==null) {
        view = inflater.inflate(R.layout.fragment_grupo,
                container, false);

    //}
       return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_grupo, container, false);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
           ParticipantesFragment f = (ParticipantesFragment) getFragmentManager()
         .findFragmentById(R.id.fragmento_lista_participantes);
         if (f != null)
         getFragmentManager().beginTransaction().remove(f).commit();
    }


    public static void mostrarMensajeLog(String mensaje) {
        Log.v("MyClonFragment", mensaje);
    }

}
