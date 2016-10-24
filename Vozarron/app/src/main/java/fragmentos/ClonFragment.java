package fragmentos;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClonFragment extends Fragment {


    private TextView txtInfo;
    private static final String COLOR_FONDO = "color";
    private static final String INDICE = "indice";
    private int color;
    private int indice;

    public ClonFragment() {}
    public static ClonFragment newInstance(int color, int index) {
        ClonFragment fragment = new ClonFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(COLOR_FONDO, color);
        bundle.putInt(INDICE, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);
        mostrarMensajeLog("" + index);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.color = (getArguments() != null) ? getArguments().getInt(
                COLOR_FONDO) : Color.GRAY;
        this.indice = (getArguments() != null) ?
                getArguments().getInt(INDICE)
                : -1;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_clon, container, false);
        txtInfo = (TextView) vista.findViewById(R.id.texto);
        txtInfo.setText(String.valueOf(this.indice));
        return vista;
    }
    public static void mostrarMensajeLog(String mensaje) {
        Log.v("MyClonFragment", mensaje);
    }
}


