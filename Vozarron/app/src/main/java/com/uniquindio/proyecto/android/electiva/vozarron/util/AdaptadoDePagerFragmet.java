package com.uniquindio.proyecto.android.electiva.vozarron.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.uniquindio.proyecto.android.electiva.vozarron.VO.Participante;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.EntrenadorFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.EntrenadoresFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.GrupoFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.GruposFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.Inicio_Fragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.ParticipanteFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.ParticipantesFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.RegistrarFragment;
import com.uniquindio.proyecto.android.electiva.vozarron.fragmentos.VotarFragment;

import java.util.ArrayList;

/**
 * Created by USUARIO WINDOWS on 24/10/2016.
 */
public class AdaptadoDePagerFragmet extends FragmentPagerAdapter {

    private static final String INICIO = "INICIO";

    private static final String GRUPOS = "GRUPOS";

    private static final String PARTICIPANTES = "PARTICIPANTES";

    private static final String ENTRENADORES = "ENTRENADORES";

    private static final String GRUPO = "GRUPO";

    private static final String PARTICIPANTE = "PARTICIPANTE";

    private static final String ENTRENADOR = "ENTRENADOR";

    private static final String VOTAR = "VOTAR";

    private static final String REGISTRAR = "REGISTRAR";

    private ArrayList<String> listaDeTiulos;

    private Participante partiSeleccionado;

    public AdaptadoDePagerFragmet(FragmentManager fm) {
        super(fm);
        listaDeTiulos = new ArrayList<>();

        listaDeTiulos.add(INICIO);
        listaDeTiulos.add(GRUPOS);
        listaDeTiulos.add(PARTICIPANTES);
        listaDeTiulos.add(ENTRENADORES);
        listaDeTiulos.add(GRUPO);
        listaDeTiulos.add(PARTICIPANTE);
        listaDeTiulos.add(ENTRENADOR);
        listaDeTiulos.add(VOTAR);
        listaDeTiulos.add(REGISTRAR);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment g = null;

        switch (position) {
            case 0:
                g = Inicio_Fragment.newInstance(position + 1);
                break;
            case 1:
                g = GruposFragment.newInstance(position + 1);
                break;
            case 2:
                g = ParticipantesFragment.newInstance(position + 1);
                break;
            case 3:
                g = EntrenadoresFragment.newInstance(position + 1);
                break;
            case 4:
                g = GrupoFragment.newInstance(position + 1);
                break;
            case 5:
                if (partiSeleccionado!= null)
                    mostrarMensaje("---Participante en el adaptador: "+partiSeleccionado.getNombre());
                else
                    mostrarMensaje("Participante null");
                g = ParticipanteFragment.newInstance(position + 1, partiSeleccionado);
                break;
            case 6:
                g = EntrenadorFragment.newInstance(position + 1);
                break;
            case 7:
                g = VotarFragment.newInstance(position + 1);
                break;
            case 8:
                g = RegistrarFragment.newInstance(position + 1);
                break;
        }
        return g;
    }

    @Override
    public int getCount() {
        return listaDeTiulos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return listaDeTiulos.get(position);
    }

    public Participante getPartiSeleccionado() {
        return partiSeleccionado;
    }

    public void setPartiSeleccionado(Participante partiSeleccionado) {
        this.partiSeleccionado = partiSeleccionado;
    }
    public static void mostrarMensaje(String mensaje) {
        Log.v("Mensaje", mensaje);
    }
}