package com.jccl.petagram.presentador;

import android.content.Context;

import com.jccl.petagram.adapter.MascotaAdaptador;
import com.jccl.petagram.db.ConstructorMascotas;
import com.jccl.petagram.fragment.homeFragment;
import com.jccl.petagram.fragment.iHomeFragment;
import com.jccl.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ashnic gr on 16/03/2017.
 */

public class HomeFragmentPresenter implements iHomeFragmentPresenter{

    private iHomeFragment iHomeFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public HomeFragmentPresenter(iHomeFragment iHomeFragment, Context context){
        this.iHomeFragment = iHomeFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasrRV();
    }

    @Override
    public void mostrarMascotasrRV() {
        iHomeFragment.inicializarAdaptadorRv(iHomeFragment.crearAdaptador(mascotas));
        iHomeFragment.generarLinearLayoutVertical();
    }

}
