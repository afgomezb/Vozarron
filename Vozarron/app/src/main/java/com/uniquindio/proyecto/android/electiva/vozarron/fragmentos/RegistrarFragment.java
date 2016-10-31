package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Entrenadores;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrarFragment extends Fragment {

    /**
     * Indice del view pager
     */
    private static final String INDICE = "indice";

    /**
     * Variable que guarda la vista del fragmento
     */
    private View view;

    /**
     * Variable para el combo box de entrenadores
     */
    private Spinner combo_box_entrenadores;

    /**
     * Variable para el combo box de roles
     */
    private Spinner combo_box_roles;

    /**
     * Metodo constructor del fragmento
     */
    public RegistrarFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo para crear una instancia del fragmento de registrar
     *
     * @param index posicion de la nueva instancia en el menu
     * @return fragmento de registrar particpante
     */
    public static RegistrarFragment newInstance (int index) {
        RegistrarFragment fragment = new RegistrarFragment();
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
        view = inflater.inflate(R.layout.fragment_registrar,
                container, false);

        mostrarDatosDeEntrenador();
        mostrarDatosDeRol();
        // Inflate the layout for this fragment
        return view;
    }

    /**
     * Metodo encargado de llenar el combo box de roles
     */
    private void mostrarDatosDeRol() {
        //Se inicializa el combo box con el id del xml
        combo_box_roles = (Spinner) view.findViewById(R.id.combo_box_rol);
        String [] listaRoles =new String [] {"Estudiante","Docente"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listaRoles);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo_box_roles.setAdapter(adaptador);
        combo_box_roles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       android.view.View v, int position, long id) {
                mostrarMensajeLog(parent.getItemAtPosition(position)+" - seleccionado");

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Metodo encargado de llenar el combo box de entrenadores del concurso
     */
    private void mostrarDatosDeEntrenador() {
        //Se inicializa el combo box con el id del xml
        combo_box_entrenadores = (Spinner) view.findViewById(R.id.combo_box_entrenadores);
        //Arreglo de cadenas con la informacion para mostrar
        // String[] personalidades = {"Ronaldinho","Albert Einstein","Leonardo da Vinci","Alejandro Magno", "Goku" , "Linus Torvalds"};
        final Entrenadores lista=new Entrenadores();
        String [] listaEntrenadores = lista.traerNombresDeEntrenadores();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listaEntrenadores);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo_box_entrenadores.setAdapter(adaptador);
        combo_box_entrenadores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       android.view.View v, int position, long id) {
                mostrarMensajeLog(parent.getItemAtPosition(position)+" - seleccionado");

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
