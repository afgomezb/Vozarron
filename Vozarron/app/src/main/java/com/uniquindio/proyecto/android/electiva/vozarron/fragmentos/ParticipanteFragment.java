package com.uniquindio.proyecto.android.electiva.vozarron.fragmentos;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.util.Participantes;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParticipanteFragment extends Fragment implements View.OnClickListener {


    private static final String INDICE = "indice";
    private ImageButton btnImage_video;
    private Participante partiSeleccionado;

    public ParticipanteFragment() {
        // Required empty public constructor
    }

    public static ParticipanteFragment newInstance (int index, Participante participante) {
        ParticipanteFragment fragment = new ParticipanteFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(INDICE, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);
        mostrarMensajeLog("" + index);

        fragment.setPartiSeleccionado(participante);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_participante,
                container, false);

        mostrarDatosDeParticipante(view);

        btnImage_video = (ImageButton) view.findViewById(R.id.btn_image_video);
        btnImage_video.setOnClickListener(this);

        return view;
    }

    public static void mostrarMensajeLog(String mensaje) {
        Log.v("MyClonFragment", mensaje);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnImage_video.getId()) {
            mostrarMensajeLog("Se presiono el boton del video");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(partiSeleccionado.getUrlVideo()));
            startActivity(intent);
        }
    }

    public Participante getPartiSeleccionado() {
        return partiSeleccionado;
    }

    public void setPartiSeleccionado(Participante partiSeleccionado) {
        this.partiSeleccionado = partiSeleccionado;
    }

    public void mostrarDatosDeParticipante (View view) {
        //Se trae la lista de participantes
        Participantes lista_participantes =  new Participantes();
        int posicion = (int) (Math.random() * lista_participantes.getParticipantes().size());
        partiSeleccionado = lista_participantes.getParticipantes().get(posicion);

        //se trae nombre del participante
        TextView nombre = (TextView) view.findViewById(R.id.nom_participante);
        nombre.setText(partiSeleccionado.getNombre());

        //se trae la edad del participante
        TextView edad = (TextView) view.findViewById(R.id.edad_participante);
        edad.setText(partiSeleccionado.getEdad()+" años");

        //se trae el nombre del entrenador del participante
        TextView nombre_entrenador = (TextView) view.findViewById(R.id.entrenador_nombre);
        nombre_entrenador.setText(partiSeleccionado.getEntrenador().getNombre());

        //se trae el estado del participante
        TextView estado = (TextView) view.findViewById(R.id.estado_particiapnte);
        estado.setText(partiSeleccionado.getEstado());

        //Se trae la imagen del participante
        ImageView foto = (ImageView) view.findViewById(R.id.imagen);
        String nombreImagen = lista_participantes.getParticipantes().get(posicion).getFoto();
        int res_imagen = getActivity().getResources().getIdentifier("drawable/" + nombreImagen, null, getActivity().getPackageName());
        foto.setImageResource(res_imagen);

    }
}
