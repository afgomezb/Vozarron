package fragmentos;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParticipanteFragment extends Fragment implements View.OnClickListener {


    private static final String INDICE = "indice";
    private ImageButton btnImage_video;

    public ParticipanteFragment() {
        // Required empty public constructor
    }

    public static ParticipanteFragment newInstance (int index) {
        ParticipanteFragment fragment = new ParticipanteFragment();
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
        View view = inflater.inflate(R.layout.fragment_participante,
                container, false);

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
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=pO7STLF82Ro"));
            startActivity(intent);
        }
    }
}
