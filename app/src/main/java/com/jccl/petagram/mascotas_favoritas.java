package com.jccl.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jccl.petagram.adapter.MascotaAdaptador;
import com.jccl.petagram.pojo.Mascota;
import com.jccl.petagram.presentador.favoritosPresenter;

import java.util.ArrayList;

public class mascotas_favoritas extends AppCompatActivity implements imascotas_favoritas{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private favoritosPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);
        presenter = new favoritosPresenter(this, getBaseContext());
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this ,0);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRv(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
