package com.jccl.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jccl.petagram.pojo.Mascota;
import com.jccl.petagram.R;

import java.util.ArrayList;

/**
 * Created by ashnic gr on 01/03/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    int opcion;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, int opcion){
        this.mascotas = mascotas;
        this.opcion = opcion;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_layout, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        if (opcion == 0) {
            mascotaViewHolder.tvNombre.setText(mascota.getNombre());
            mascotaViewHolder.imgvMascota.setImageResource(mascota.getImagen());
            mascotaViewHolder.imgvHuesoLike.setImageResource(R.drawable.icon);
            mascotaViewHolder.imgvNoLike.setImageResource(R.drawable.bones);
            mascotaViewHolder.tvNolike.setText(Integer.toString(mascota.getHuesos()));
        } else{
            mascotaViewHolder.tvNombre.setVisibility(View.GONE);
            mascotaViewHolder.tvNolike.setText(Integer.toString(mascota.getHuesos()));
            mascotaViewHolder.imgvMascota.setImageResource(mascota.getImagen());
            mascotaViewHolder.imgvNoLike.setVisibility(View.VISIBLE);
            mascotaViewHolder.imgvHuesoLike.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {


        private ImageView imgvMascota;
        private ImageView imgvHuesoLike;
        private TextView tvNombre;
        private TextView tvNolike;
        private ImageView imgvNoLike;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgvMascota = (ImageView) itemView.findViewById(R.id.imgvMascota);
            imgvHuesoLike = (ImageView) itemView.findViewById(R.id.imgvHuesoLike);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvNolike = (TextView) itemView.findViewById(R.id.tvNolike);
            imgvNoLike = (ImageView) itemView.findViewById(R.id.imgvNoLike);

        }
    }

}
