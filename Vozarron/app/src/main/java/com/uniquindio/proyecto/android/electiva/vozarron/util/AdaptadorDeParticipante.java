package com.uniquindio.proyecto.android.electiva.vozarron.util;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;

import java.util.ArrayList;

/**
 * Clase encargada de servir como adaptador de las lista de participantes
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class AdaptadorDeParticipante extends RecyclerView.Adapter<AdaptadorDeParticipante.ParticipanteViewHolder> {

    /**
     * Listado de participantes del concurso
     */
    ArrayList<Participante> participantes;

    /**
     * escuchador del adaptador de participantes
     */
    private static OnClickAdaptadorDeParticipante listener;

    /**
     * Metodo constructor de adaptador de participantes
     *
     * @param participantes                lista de participantes
     * @param listaDeParticipantesFragment fragmeto donde se mostrara la lista de grupos
     */
    public AdaptadorDeParticipante(ArrayList<Participante> participantes, Fragment listaDeParticipantesFragment) {
        this.participantes = participantes;
        listener = (OnClickAdaptadorDeParticipante) listaDeParticipantesFragment;
    }

    /**
     * Metodo onCreateViewHolder del grupo
     *
     * @param parent   ViewGroup
     * @param viewType ViewType
     * @return Entrenador View Holder
     */
    @Override
    public ParticipanteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_participante, parent, false);
        ParticipanteViewHolder participanteVH = new
                ParticipanteViewHolder(itemView);
        return participanteVH;
    }

    /**
     * Metodo onBindViewHolder del participante
     *
     * @param holder   holder
     * @param position posicion de la lista de participantes
     */
    @Override
    public void onBindViewHolder(AdaptadorDeParticipante.ParticipanteViewHolder holder, int position) {
        Participante participante = participantes.get(position);
        holder.binParticipante(participante);
    }

    /**
     * Interace para el on click del adaptador de participante
     */
    public interface OnClickAdaptadorDeParticipante {
        public void onClickPosition(int pos);
    }

    /**
     * Metodo para contarlos participantes
     *
     * @return cantidad de participantes
     */
    @Override
    public int getItemCount() {
        return participantes.size();
    }

    /**
     * Clase para el participante view holder
     */
    public static class ParticipanteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * textview nombre del XML
         */
        private TextView txtNombreParticipante;

        /**
         * textview rol del XML
         */
        private TextView txtRolParticipante;

        /**
         * imageview foto del XML
         */
        private ImageView foto;

        /**
         * Metodo constructor del participante view holder
         *
         * @param itemView vista
         */
        public ParticipanteViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreParticipante = (TextView)
                    itemView.findViewById(R.id.nombre);
            txtRolParticipante = (TextView)
                    itemView.findViewById(R.id.rol);
            foto = (ImageView) itemView.findViewById(R.id.imagen);
        }

        /**
         * Metodo encargado de mostrar los datos de un participante en el fragmento
         *
         * @param participante participante con los datos
         */
        public void binParticipante(Participante participante) {
            txtNombreParticipante.setText(participante.getNombre());

            txtRolParticipante.setText(participante.getRol());

            int res_imagen = participante.getFoto();
            foto.setImageResource(res_imagen);
        }

        /**
         * Metodo para capturar el evento cuando es seleccionado un participante de la lista
         *
         * @param v vista
         */
        @Override
        public void onClick(View v) {
            Log.d("TAG", "Elemento " + getAdapterPosition() + " clicked. " +
                    txtNombreParticipante.getText());
            listener.onClickPosition(getAdapterPosition());
        }
    }


}
