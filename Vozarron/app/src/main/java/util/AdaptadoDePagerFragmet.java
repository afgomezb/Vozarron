package util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import fragmentos.EntrenadorFragment;
import fragmentos.EntrenadoresFragment;
import fragmentos.GrupoFragment;
import fragmentos.GruposFragment;
import fragmentos.Inicio_Fragment;
import fragmentos.ParticipanteFragment;
import fragmentos.ParticipantesFragment;
import fragmentos.RegistrarFragment;
import fragmentos.VotarFragment;

/**
 * Created by USUARIO WINDOWS on 24/10/2016.
 */
public class AdaptadoDePagerFragmet extends FragmentPagerAdapter {
    private ArrayList<String> listaDeTiulos;

    public AdaptadoDePagerFragmet(FragmentManager fm) {
        super(fm);
        listaDeTiulos = new ArrayList<>();
        listaDeTiulos.add("Inicio");
        listaDeTiulos.add("Grupos");
        listaDeTiulos.add("Participantes");
        listaDeTiulos.add("Entrenadores");
        listaDeTiulos.add("Grupo");
        listaDeTiulos.add("Participante");
        listaDeTiulos.add("Entrenador");
        listaDeTiulos.add("Votar");
        listaDeTiulos.add("Registrar");

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
                g = ParticipanteFragment.newInstance(position + 1);
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


}