package fragmentos;


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
public class GruposFragment extends Fragment {

    private static final String INDICE = "indice";
    private int indice;


    public GruposFragment() {

    }

    public static GruposFragment newInstance (int index) {
            GruposFragment fragment = new GruposFragment();
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
        return inflater.inflate(R.layout.fragment_grupos, container, false);
    }

    public static void mostrarMensajeLog(String mensaje) {
        Log.v("MyClonFragment", mensaje);
    }
}
