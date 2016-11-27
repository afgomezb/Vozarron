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
 * Clase encargada de servir como adaptador de las lista de grupos
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class AdaptadorDeGrupo extends RecyclerView.Adapter<AdaptadorDeGrupo.GrupoViewHolder> {

    /**
     * Listado de grupos del concurso
     */
    private ArrayList<Entrenador> grupos;

    /**
     * escuchador del adaptador de grupo
     */
    private static OnClickAdaptadorDeGrupo listener;

    /**
     * Metodo constructor de adaptador de grupo
     *
     * @param grupos                lista de grupos
     * @param listaDeGruposFragment fragmeto donde se mostrara la lista de grupos
     */
    public AdaptadorDeGrupo (ArrayList<Entrenador> grupos, Fragment listaDeGruposFragment) {
        this.grupos = grupos;
        listener = (OnClickAdaptadorDeGrupo) listaDeGruposFragment;
    }

    /**
     * Metodo onCreateViewHolder del grupo
     *
     * @param parent   ViewGroup
     * @param viewType ViewType
     * @return Entrenador View Holder
     */
    @Override
    public GrupoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_grupo, parent, false);
        GrupoViewHolder grupoVH = new
                GrupoViewHolder(itemView);
        return grupoVH;
    }

    /**
     * Metodo onBindViewHolder del grupo
     *
     * @param holder   holder
     * @param position posicion de la lista de grupos
     */
    @Override
    public void onBindViewHolder(AdaptadorDeGrupo.GrupoViewHolder holder, int position) {
        Entrenador grupo = grupos.get(position);
        holder.binGrupo(grupo);
    }

    /**
     * Interace para el on click del adaptador de grupo
     */
    public interface OnClickAdaptadorDeGrupo {
        public void onClickPosition(int pos);
    }

    /**
     * Metodo para contarlos grupos
     *
     * @return cantidad de grupos
     */
    @Override
    public int getItemCount() {
        if (grupos != null)
            return grupos.size();
        else
            return 0;
    }

    /**
     * Clase para el grupo view holder
     */
    public static class GrupoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * textview nombre del XML
         */
        private TextView txtNombreEntrenador;

        /**
         * textview grupo del XML
         */
        private TextView txtGrupo;

        /**
         * imageview foto del XML
         */
        private ImageView foto;

        /**
         * Metodo constructor del grupo view holder
         *
         * @param itemView vista
         */
        public GrupoViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreEntrenador = (TextView)
                    itemView.findViewById(R.id.nombre);
            txtGrupo = (TextView)
                    itemView.findViewById(R.id.grupo);
            foto = (ImageView) itemView.findViewById(R.id.imagen);
        }

        /**
         * Metodo encargado de mostrar los datos de un grupo en el fragmento
         *
         * @param grupo grupo con los datos
         */
        public void binGrupo(Entrenador grupo) {
            txtNombreEntrenador.setText(grupo.getNombre());

            txtGrupo.setText("Grupo");

            int res_imagen = grupo.getFoto();
            foto.setImageResource(res_imagen);
        }

        /**
         * Metodo para capturar el evento cuando es seleccionado un grupo de la lista
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
