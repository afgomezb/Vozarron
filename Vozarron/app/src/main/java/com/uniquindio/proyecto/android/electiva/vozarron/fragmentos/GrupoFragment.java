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
 * A simple {@link Fragment} subclass.
 */
public class GrupoFragment extends Fragment {

    private static final String INDICE = "indice";
    private View view;
    private Entrenador entrenadorSeleccionado;

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

        mostrarDatosGrupo(view);
    //}
       return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_grupo, container, false);
    }

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
