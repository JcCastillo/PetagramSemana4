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

import com.jccl.petagram.presentador.HomeFragmentPresenter;
import com.jccl.petagram.presentador.iHomeFragmentPresenter;

/**
 * Created by ashnic gr on 11/03/2017.
 */

public class homeFragment extends Fragment implements iHomeFragment{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private iHomeFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragmente_home, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascota);
        presenter = new HomeFragmentPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity() ,0);
        return adaptador;

    }

    @Override
    public void inicializarAdaptadorRv(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
