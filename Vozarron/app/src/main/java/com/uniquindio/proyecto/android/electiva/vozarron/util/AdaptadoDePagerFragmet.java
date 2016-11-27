package com.uniquindio.proyecto.android.electiva.vozarron.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.uniquindio.proyecto.android.electiva.vozarron.R;
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
 * Clase encargada de servir como adaptador de las vistas del view pager
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class AdaptadoDePagerFragmet extends FragmentPagerAdapter {

    /**
     * Cadena para la vista Inicio
     */
    private static final String INICIO = "INICIO";

    /**
     * Cadena para la vista Grupos
     */
    private static final String GRUPOS = "GRUPOS";

    /**
     * Cadena para la vista Participantes
     */
    private static final String PARTICIPANTES = "PARTICIPANTES";

    /**
     * Cadena para la vista Entrenadores
     */
    private static final String ENTRENADORES = "ENTRENADORES";

    /**
     * Cadena para la vista Grupo
     */
    private static final String GRUPO = "GRUPO";

    /**
     * Cadena para la vista Participante
     */
    private static final String PARTICIPANTE = "PARTICIPANTE";

    /**
     * Cadena para la vista Entrenador
     */
    private static final String ENTRENADOR = "ENTRENADOR";

    /**
     * Cadena para la vista Votar
     */
    private static final String VOTAR = "VOTAR";

    /**
     * Cadena para la vista Registrar
     */
    private static final String REGISTRAR = "REGISTRAR";

    /**
     * Lista de titulos del menu
     */
    private ArrayList<String> listaDeTiulos;

    /**
     * Participante seleccionado
     */
    private Participante partiSeleccionado;

    /**
     * Metodo constructor del adaptador
     *
     * @param fm fragmento que va tener los demas fragmentos
     */
    public AdaptadoDePagerFragmet(FragmentManager fm, Context context) {
        super(fm);

        listaDeTiulos = new ArrayList<>();

        listaDeTiulos.add(context.getString(R.string.tab_inicio));
        listaDeTiulos.add(context.getString(R.string.tab_grupos));
        listaDeTiulos.add(context.getString(R.string.tab_participantes));
        listaDeTiulos.add(context.getString(R.string.tab_entrenadores));
        listaDeTiulos.add(context.getString(R.string.tab_grupo));
        listaDeTiulos.add(context.getString(R.string.tab_participante));
        listaDeTiulos.add(context.getString(R.string.tab_entrenador));
        listaDeTiulos.add(context.getString(R.string.tab_votar));
        listaDeTiulos.add(context.getString(R.string.tab_registrar));
    }

    /**
     * Metodo para mostrar un fragmeto determinado
     *
     * @param position posicion del fragmento que se desea mostrar
     * @return fragmento que se va mostrar
     */
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
                if (partiSeleccionado != null)
                    mostrarMensaje("---Participante en el adaptador: " + partiSeleccionado.getNombre());
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

    /**
     * Metodo encargado de retorna la cnatidad de titulos de la lista
     *
     * @return cantidad de titulos
     */
    @Override
    public int getCount() {
        return listaDeTiulos.size();
    }

    /**
     * Metodo que retorna los titulos de las vistas segun la posicion en la lista
     *
     * @param position posicion en la lista del titulo
     * @return titulo
     */
    @Override
    public CharSequence getPageTitle(int position) {

        return listaDeTiulos.get(position);
    }

    /**
     * Metodo para modificar el valor de la variable partiSeleccionado
     *
     * @param partiSeleccionado paticipante seleccionado
     */
    public void setPartiSeleccionado(Participante partiSeleccionado) {
        this.partiSeleccionado = partiSeleccionado;
    }

    /**
     * Metodo para mostrar mensajes por consola
     *
     * @param mensaje mensaje que se desea mostrar por consola
     */
    public static void mostrarMensaje(String mensaje) {
        Log.v("Mensaje", mensaje);
    }
}