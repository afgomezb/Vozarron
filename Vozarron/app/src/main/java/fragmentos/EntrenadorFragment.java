package fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.PrincipalActivity;
import com.uniquindio.proyecto.android.electiva.vozarron.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntrenadorFragment extends Fragment implements View.OnClickListener{

    TextView imagen;
    private static final String INDICE = "indice";
    private ImageButton btn_image_lista_participantes;

    public EntrenadorFragment() {
        // Required empty public constructor
    }

    public static EntrenadorFragment newInstance (int index) {
        EntrenadorFragment fragment = new  EntrenadorFragment();
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
        View view = inflater.inflate(R.layout.fragment_entrenador,
                container, false);

        btn_image_lista_participantes = (ImageButton) view.findViewById(R.id.btn_image_lista_participantes);
        btn_image_lista_participantes.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_entrenador, container, false);
    }

    public static void mostrarMensajeLog(String mensaje) {
        Log.v("MyClonFragment", mensaje);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_image_lista_participantes.getId()) {
            mostrarMensajeLog("Boton lista de participantes");
            ((PrincipalActivity)getActivity()).modificarVista(2);
        }
    }
}
