package util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

import java.util.ArrayList;

import VO.Entrenador;
import fragmentos.ListaDeEntrenadoresFragment;

/**
 * Created by USUARIO WINDOWS on 25/10/2016.
 */
public class AdaptadorDeEntrenador extends RecyclerView.Adapter<AdaptadorDeEntrenador.EntrenadorViewHolder> {

    ArrayList<Entrenador> entrenadores;
    private static OnClickAdaptadorDeEntrenador listener;

    public AdaptadorDeEntrenador(ArrayList<Entrenador> entrenadores, ListaDeEntrenadoresFragment listaDeEntrenadoresFragment) {
        this.entrenadores = entrenadores;
        listener = (OnClickAdaptadorDeEntrenador) listaDeEntrenadoresFragment;
    }

    @Override
    public EntrenadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_entrenadores, parent, false);
        EntrenadorViewHolder entrenadorVH = new
                EntrenadorViewHolder(itemView);
        return entrenadorVH;
    }

    @Override
    public void onBindViewHolder(AdaptadorDeEntrenador.EntrenadorViewHolder holder, int position) {
        Entrenador entrenador = entrenadores.get(position);
        holder.binEntrenador(entrenador);
    }

    public interface OnClickAdaptadorDeEntrenador {
        public void onClickPosition(int pos);
    }

    @Override
    public int getItemCount() {
        if (entrenadores != null)
            return entrenadores.size();
        else
            return 0;
    }

    public static class EntrenadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtNombreEntrenador;
        private TextView txtGeneroEntrenador;


        public EntrenadorViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreEntrenador = (TextView)
                    itemView.findViewById(R.id.nombre);
            txtGeneroEntrenador = (TextView)
                    itemView.findViewById(R.id.genero);
        }

        public void binEntrenador(Entrenador entrenador) {
            txtNombreEntrenador.setText(entrenador.getNombre());

            txtGeneroEntrenador.setText(entrenador.getGenero());
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " +
                    txtNombreEntrenador.getText());
            listener.onClickPosition(getAdapterPosition());

        }
    }


}
