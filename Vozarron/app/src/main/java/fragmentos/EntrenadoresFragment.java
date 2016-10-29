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
public class EntrenadoresFragment extends Fragment {

    private View view;
    private static final String INDICE = "indice";

    public EntrenadoresFragment() {
        // Required empty public constructor
    }

    public static EntrenadoresFragment newInstance (int index) {
        EntrenadoresFragment fragment = new  EntrenadoresFragment();
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
      //  if (view == null) {
            view = inflater.inflate(R.layout.fragment_entrenadores,
                    container, false);
       //}
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_entrenadores, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EntrenadoresFragment f = (EntrenadoresFragment) getFragmentManager()
                .findFragmentById(R.id.fragmento_lista_entrenadores);
        if (f != null)
            getFragmentManager().beginTransaction().remove(f).commit();
    }

    public static void mostrarMensajeLog(String mensaje) {
        Log.v("MyClonFragment", mensaje);
    }
}
