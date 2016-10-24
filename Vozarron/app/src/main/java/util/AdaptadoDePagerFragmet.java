package util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.uniquindio.proyecto.android.electiva.vozarron.R;

import java.util.ArrayList;

import fragmentos.ClonFragment;
import fragmentos.GruposFragment;

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
    }
    @Override
    public Fragment getItem(int position) {
        ClonFragment f = null;
        Fragment g =null;
        ClonFragment.mostrarMensajeLog("pos: "+position);
        switch (position) {
            case 0:
                g = GruposFragment.newInstance(position+1);
                break;
            case 1:
                g = ClonFragment.newInstance(R.color.android_green,
                        position+1);
                break;
            case 2:
                g = ClonFragment.newInstance(R.color.android_green,
                        position+1);
                break;
            case 3:
                g = ClonFragment.newInstance(R.color.android_green,
                        position+1);
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