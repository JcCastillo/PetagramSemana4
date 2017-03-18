package com.jccl.petagram;

import com.jccl.petagram.adapter.MascotaAdaptador;
import com.jccl.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ashnic gr on 17/03/2017.
 */

public interface imascotas_favoritas {
    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRv(MascotaAdaptador adaptador);

}
