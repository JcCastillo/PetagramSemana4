package com.jccl.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jccl.petagram.R;
import com.jccl.petagram.adapter.MascotaAdaptador;
import com.jccl.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ashnic gr on 11/03/2017.
 */

public class homeFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragmente_home, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,0);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Rocky",R.drawable.dog1));
        mascotas.add(new Mascota("Rufo",R.drawable.dog2));
        mascotas.add(new Mascota("Terry", R.drawable.dog3));
        mascotas.add(new Mascota("Pelusa", R.drawable.dog4));
        mascotas.add(new Mascota("Rafa", R.drawable.dog5));
        mascotas.add(new Mascota("Jefe", R.drawable.dog6));
        mascotas.add(new Mascota("Canelo", R.drawable.dog7));
    }
}
