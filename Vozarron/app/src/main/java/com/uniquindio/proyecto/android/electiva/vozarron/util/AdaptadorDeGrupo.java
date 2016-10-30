package com.uniquindio.proyecto.android.electiva.vozarron.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

import java.util.ArrayList;

import com.uniquindio.proyecto.android.electiva.vozarron.VO.Entrenador;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.ListaDeGruposFragment;

/**
 * Created by USUARIO WINDOWS on 28/10/2016.
 */
public class AdaptadorDeGrupo extends RecyclerView.Adapter<AdaptadorDeGrupo.GrupoViewHolder> {

    ArrayList<Entrenador> grupos;
    private static OnClickAdaptadorDeGrupo listener;

    public AdaptadorDeGrupo (ArrayList<Entrenador> grupos, ListaDeGruposFragment listaDeGruposFragment) {
        this.grupos = grupos;
        listener = (OnClickAdaptadorDeGrupo) listaDeGruposFragment;
    }

    @Override
    public GrupoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_grupo, parent, false);
        GrupoViewHolder grupoVH = new
                GrupoViewHolder(itemView);
        return grupoVH;
    }

    @Override
    public void onBindViewHolder(AdaptadorDeGrupo.GrupoViewHolder holder, int position) {
        Entrenador grupo = grupos.get(position);
        holder.binGrupo(grupo);
    }

    public interface OnClickAdaptadorDeGrupo {
        public void onClickPosition(int pos);
    }

    @Override
    public int getItemCount() {
        if (grupos != null)
            return grupos.size();
        else
            return 0;
    }

    public static class GrupoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtNombreEntrenador;
        private TextView txtGrupo;


        public GrupoViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreEntrenador = (TextView)
                    itemView.findViewById(R.id.nombre);
            txtGrupo = (TextView)
                    itemView.findViewById(R.id.grupo);
        }

        public void binGrupo(Entrenador grupo) {
            txtNombreEntrenador.setText(grupo.getNombre());

            txtGrupo.setText("Grupo");
        }

        @Override
        public void onClick(View v) {
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " +
                    txtNombreEntrenador.getText());
            listener.onClickPosition(getAdapterPosition());

        }
    }
}
