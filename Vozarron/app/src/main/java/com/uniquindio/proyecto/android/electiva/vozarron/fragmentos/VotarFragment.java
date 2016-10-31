package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Participantes;

/**
 * A simple {@link Fragment} subclass.
 */
public class VotarFragment extends Fragment {

    private static final String INDICE = "indice";
    private Spinner combo_box_participantes;

    public VotarFragment() {
        // Required empty public constructor
    }

    public static VotarFragment newInstance (int index) {
        VotarFragment fragment = new VotarFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_votar,
                container, false);
        //Se inicializa el combo box con el id del xml
        combo_box_participantes = (Spinner) view.findViewById(R.id.combo_box_participantes);
        //Arreglo de cadenas con la informacion para mostrar
       // String[] personalidades = {"Ronaldinho","Albert Einstein","Leonardo da Vinci","Alejandro Magno", "Goku" , "Linus Torvalds"};
        Participantes lista=new Participantes();
        String [] listaParticipantes = lista.traerNombresDePartcipantes();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listaParticipantes);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo_box_participantes.setAdapter(adaptador);

        //return inflater.inflate(R.layout.fragment_votar, container, false);
        return view;
    }

    public static void mostrarMensajeLog(String mensaje) {
        Log.v("MyClonFragment", mensaje);
    }
}
