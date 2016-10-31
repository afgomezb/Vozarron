package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Participantes;

/**
 * A simple {@link Fragment} subclass.
 */
public class VotarFragment extends Fragment {

    /**
     * Indice del view pager
     */
    private static final String INDICE = "indice";

    /**
     * Variable que guarda la vista del fragmento
     */
    private View view;

    /**
     * Variable del combo box que mostrara el listado de participantes
     */
    private Spinner combo_box_participantes;

    /**
     * Metodo constructor del fragmento
     */
    public VotarFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo para crear una instancia del fragmento votar
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento votar
     */
    public static VotarFragment newInstance(int index) {
        VotarFragment fragment = new VotarFragment();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_votar,
                container, false);

        mostrarDatosDeParticipante();

        //return inflater.inflate(R.layout.fragment_votar, container, false);
        return view;
    }

    /**
     * Metodo para llenar el combo box con los nombres de los participantes del concurso
     */
    private void mostrarDatosDeParticipante() {

        //Se inicializa el combo box con el id del xml
        combo_box_participantes = (Spinner) view.findViewById(R.id.combo_box_participantes);
        //Arreglo de cadenas con la informacion para mostrar
        // String[] personalidades = {"Ronaldinho","Albert Einstein","Leonardo da Vinci","Alejandro Magno", "Goku" , "Linus Torvalds"};
        final Participantes lista = new Participantes();
        String[] listaParticipantes = lista.traerNombresDePartcipantes();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listaParticipantes);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo_box_participantes.setAdapter(adaptador);

        combo_box_participantes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       android.view.View v, int position, long id) {
                mostrarMensajeLog(parent.getItemAtPosition(position) + "-seleccionado");
                Participante parti = lista.buscarParticipantePorNombre(parent.getItemAtPosition(position) + "");

                //Se trae la imagen del participante
                ImageView foto = (ImageView) view.findViewById(R.id.imagen);
                String nombreImagen = parti.getFoto();
                int res_imagen = getActivity().getResources().getIdentifier("drawable/" + nombreImagen, null, getActivity().getPackageName());
                foto.setImageResource(res_imagen);
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
