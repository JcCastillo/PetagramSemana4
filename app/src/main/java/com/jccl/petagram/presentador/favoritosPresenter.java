package com.jccl.petagram.presentador;

import android.content.Context;

import com.jccl.petagram.db.ConstructorMascotas;
import com.jccl.petagram.fragment.iHomeFragment;
import com.jccl.petagram.mascotas_favoritas;
import com.jccl.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ashnic gr on 17/03/2017.
 */

public class favoritosPresenter implements ifavoritosPresenter {

    private mascotas_favoritas favoritas;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public favoritosPresenter(mascotas_favoritas favoritas, Context context){
        this.favoritas = favoritas;
        this.context = context;
        obtenerMascotasFavoritos();
    }


    @Override
    public void obtenerMascotasFavoritos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerFavoritos();
        mostrarMascotasrRV();
    }

    @Override
    public void mostrarMascotasrRV() {
        favoritas.inicializarAdaptadorRv(favoritas.crearAdaptador(mascotas));
        favoritas.generarLinearLayoutVertical();
    }
}
