package com.uniquindio.proyecto.android.electiva.vozarron.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.ListaDeParticipantesFragment;

import java.util.ArrayList;

/**
 * Created by USUARIO WINDOWS on 23/10/2016.
 */
public class AdaptadorDeParticipante extends RecyclerView.Adapter<AdaptadorDeParticipante.ParticipanteViewHolder>{

    ArrayList<Participante> participantes;
    private static OnClickAdaptadorDeParticipante listener;

    public AdaptadorDeParticipante(ArrayList<Participante> participantes, ListaDeParticipantesFragment listaDeParticipantesFragment) {
        this.participantes = participantes;
        listener = (OnClickAdaptadorDeParticipante) listaDeParticipantesFragment;
    }

    @Override
    public ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_participante, parent, false);
        ParticipanteViewHolder participanteVH = new
                ParticipanteViewHolder(itemView);
        return participanteVH;
    }

    @Override
    public void onBindViewHolder(AdaptadorDeParticipante.ParticipanteViewHolder holder, int position) {
        Participante participante = participantes.get(position);
        holder.binParticipante(participante);
    }

    public interface OnClickAdaptadorDeParticipante {
        public void onClickPosition(int pos);
    }

    @Override
    public int getItemCount() {
        return participantes.size();
    }

    public static class ParticipanteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtNombreParticipante;
        private TextView txtRolParticipante;



        public ParticipanteViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreParticipante = (TextView)
                    itemView.findViewById(R.id.nombre);
            txtRolParticipante = (TextView)
                    itemView.findViewById(R.id.rol);
        }

        public void binParticipante(Participante participante) {
            txtNombreParticipante.setText(participante.getNombre());

            txtRolParticipante.setText(participante.getRol());
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", "Elemento " + getAdapterPosition() + " clicked. " +
                    txtNombreParticipante.getText());
            listener.onClickPosition(getAdapterPosition());
        }
    }


}
