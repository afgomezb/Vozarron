package fragmentos;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

import java.util.ArrayList;

import VO.Participante;
import util.AdaptadorDeParticipante;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeParticipantesFragment extends Fragment implements AdaptadorDeParticipante.OnClickAdaptadorDeParticipante{


    private ArrayList<Participante> participantes;
    private AdaptadorDeParticipante adaptador;
    private RecyclerView listadoDeParticipantes;
    private OnParticipanteSeleccionadoListener listener;

    public ListaDeParticipantesFragment() {
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
        return inflater.inflate(R.layout.fragment_lista_de_participantes, container, false);
    }

    @Override
    public void onClickPosition(int pos) {

        listener.onParticipanteSeleccionado(pos);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Se ha completado el onCreate de la actividad
        listadoDeParticipantes = (RecyclerView) getView().findViewById(R.id.listaParticipantes);
        adaptador = new AdaptadorDeParticipante(participantes, this);
        listadoDeParticipantes.setAdapter(adaptador);
        listadoDeParticipantes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
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

    public interface OnParticipanteSeleccionadoListener {
        void onParticipanteSeleccionado(int position);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
            try {
                listener = (OnParticipanteSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPersonajeSeleccionadoListener");
            }
        }
    }

    public ArrayList<Participante> getPersonajes() {
        return participantes;
    }

    public void setPersonajes(ArrayList<Participante> personajes) {
        this.participantes = personajes;
    }

}
