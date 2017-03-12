package com.jccl.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jccl.petagram.R;
import com.jccl.petagram.adapter.MascotaAdaptador;
import com.jccl.petagram.pojo.Mascota;

import java.util.ArrayList;


public class perfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public perfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotaPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listaMascotas.setLayoutManager(glm);
        inicializarMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,1);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,2));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,3));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,6));;
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,7));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,8));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,10));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,11));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,2));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,3));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,4));;
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,5));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,6));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,7));
        mascotas.add(new Mascota("Rocky",R.drawable.dog10,8));
    }

}
