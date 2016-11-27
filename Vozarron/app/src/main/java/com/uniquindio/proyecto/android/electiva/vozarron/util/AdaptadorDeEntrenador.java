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
import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;

import java.util.ArrayList;

/**
 * Clase encargada de servir como adaptador de las lista de entrenadores
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class AdaptadorDeEntrenador extends RecyclerView.Adapter<AdaptadorDeEntrenador.EntrenadorViewHolder> {

    /**
     * lista de entrenadores
     */
    private ArrayList<Entrenador> entrenadores;

    /**
     * escuchador del adaptador de entrenador
     */
    private static OnClickAdaptadorDeEntrenador listener;

    /**
     * Metodo constructor de adaptador de entrenador
     *
     * @param entrenadores                lista de entrenadores
     * @param listaDeEntrenadoresFragment fragmeto donde se mostrara la lista de entrenadores
     */
    public AdaptadorDeEntrenador(ArrayList<Entrenador> entrenadores, Fragment listaDeEntrenadoresFragment) {
        this.entrenadores = entrenadores;
        listener = (OnClickAdaptadorDeEntrenador) listaDeEntrenadoresFragment;
    }

    /**
     * Metodo onCreateViewHolder del entrenador
     *
     * @param parent   ViewGroup
     * @param viewType ViewType
     * @return Entrenador View Holder
     */
    @Override
    public EntrenadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_entrenadores, parent, false);
        EntrenadorViewHolder entrenadorVH = new
                EntrenadorViewHolder(itemView);
        return entrenadorVH;
    }

    /**
     * Metodo onBindViewHolder del entrenador
     *
     * @param holder   holder
     * @param position posicion de la lista de entrenadores
     */
    @Override
    public void onBindViewHolder(AdaptadorDeEntrenador.EntrenadorViewHolder holder, int position) {
        Entrenador entrenador = entrenadores.get(position);
        holder.binEntrenador(entrenador);
    }

    /**
     * Interace para el on click del adaptador de entrenador
     */
    public interface OnClickAdaptadorDeEntrenador {
        public void onClickPosition(int pos);
    }

    /**
     * Metodo para contarlos entrenadores
     *
     * @return cantidad de entrenadores
     */
    @Override
    public int getItemCount() {
        if (entrenadores != null)
            return entrenadores.size();
        else
            return 0;
    }

    /**
     * Clase para el entrenador view holder
     */
    public static class EntrenadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * textview nombre del XML
         */
        private TextView txtNombreEntrenador;

        /**
         * textview genero del XML
         */
        private TextView txtGeneroEntrenador;

        /**
         * imageview foto del XML
         */
        private ImageView foto;

        /**
         * Metodo constructor del entrenador view holder
         *
         * @param itemView vista
         */
        public EntrenadorViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreEntrenador = (TextView)
                    itemView.findViewById(R.id.nombre);
            txtGeneroEntrenador = (TextView)
                    itemView.findViewById(R.id.genero);
            foto = (ImageView) itemView.findViewById(R.id.imagen);
        }

        /**
         * Metodo encargado de mostrar los datos de un entrenador en el fragmento
         *
         * @param entrenador entrenador con los datos
         */
        public void binEntrenador(Entrenador entrenador) {
            txtNombreEntrenador.setText(entrenador.getNombre());

            txtGeneroEntrenador.setText(entrenador.getGenero());

             int res_imagen = entrenador.getFoto();
             foto.setImageResource(res_imagen);
        }

        /**
         * Metodo para capturar el evento cuando es seleccionado un entrenador de la lista
         *
         * @param v vista
         */
        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " +
                    txtNombreEntrenador.getText());
            listener.onClickPosition(getAdapterPosition());

        }
    }


}
