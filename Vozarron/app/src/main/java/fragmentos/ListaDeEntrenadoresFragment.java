package fragmentos;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

import java.util.ArrayList;

import VO.Entrenador;
import util.AdaptadorDeEntrenador;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeEntrenadoresFragment extends Fragment implements AdaptadorDeEntrenador.OnClickAdaptadorDeEntrenador {


    private ArrayList<Entrenador> entrenadores;
    private AdaptadorDeEntrenador adaptador;
    private RecyclerView listadoDeEntrenadores;
    private OnEntrenadorSeleccionadoListener listener;

    public ListaDeEntrenadoresFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_entrenadores, container, false);
    }

    @Override
    public void onClickPosition(int pos) {

        listener.onEntrenadorSeleccionado(pos);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Se ha completado el onCreate de la actividad
      //  if (getView()!= null)
            listadoDeEntrenadores = (RecyclerView) getView().findViewById(R.id.listaEntrenadores);
        entrenadores = new ArrayList<>();
        Entrenador entre = new Entrenador("00001", "Jhonny Rivera", "Despecho", "Jhon Jairo Rivera Valencia nació en Pereira, Colombia es el tercero de cuatro hijos, sus padres Maria Mabel Valencia y Jose Oscar Rivera'.7 y sus hermanos Julieta, Luz Piedad y Oscar Mario unos campesinos como él.");
        entrenadores.add(entre);
        mostrarMensajeLog("Cantidad de entrenadores:" + entrenadores.size());

        Entrenador entre2 = new Entrenador("00002", "Rihanna", "Pop", "Jhon Jairo Rivera Valencia nació en Pereira, Colombia es el tercero de cuatro hijos, sus padres Maria Mabel Valencia y Jose Oscar Rivera'.7 y sus hermanos Julieta, Luz Piedad y Oscar Mario unos campesinos como él.");
        entrenadores.add(entre2);

        Entrenador entre3 = new Entrenador("00003", "Adele", "Pop", "Jhon Jairo Rivera Valencia nació en Pereira, Colombia es el tercero de cuatro hijos, sus padres Maria Mabel Valencia y Jose Oscar Rivera'.7 y sus hermanos Julieta, Luz Piedad y Oscar Mario unos campesinos como él.");
        entrenadores.add(entre3);

        adaptador = new AdaptadorDeEntrenador(entrenadores, this);
        listadoDeEntrenadores.setAdapter(adaptador);
        listadoDeEntrenadores.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public interface OnEntrenadorSeleccionadoListener {
        void onEntrenadorSeleccionado(int position);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            try {
                listener = (OnEntrenadorSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnEntrenadorSeleccionadoListener");
            }
        }
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public static void mostrarMensajeLog(String mensaje) {
        Log.v("Mensaje", mensaje);
    }
}
