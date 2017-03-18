package com.jccl.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.jccl.petagram.R;
import com.jccl.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ashnic gr on 16/03/2017.
 */

public class ConstructorMascotas {

    private Context context;
    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Rocky", R.drawable.dog1));
        mascotas.add(new Mascota("Rufo",R.drawable.dog2));
        mascotas.add(new Mascota("Terry", R.drawable.dog3));
        mascotas.add(new Mascota("Pelusa", R.drawable.dog4));
        mascotas.add(new Mascota("Rafa", R.drawable.dog5));
        mascotas.add(new Mascota("Jefe", R.drawable.dog6));
        mascotas.add(new Mascota("Canelo", R.drawable.dog7));
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasMascotas();
    }

    public ArrayList<Mascota> obtenerFavoritos(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rocky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN, R.drawable.dog1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_HUESOS, 0);
        db.insertarMascota(contentValues);

        new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rufo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN, R.drawable.dog2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_HUESOS, 0);
        db.insertarMascota(contentValues);

        new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Terry");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN, R.drawable.dog3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_HUESOS, 0);
        db.insertarMascota(contentValues);

        new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Pelusa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN, R.drawable.dog4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_HUESOS, 0);
        db.insertarMascota(contentValues);

        new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rafa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN, R.drawable.dog5);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_HUESOS, 0);
        db.insertarMascota(contentValues);

        new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Jefe");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN, R.drawable.dog6);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_HUESOS, 0);
        db.insertarMascota(contentValues);

        new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Canelo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN, R.drawable.dog7);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_HUESOS, 0);
        db.insertarMascota(contentValues);
    }

    public void darLike(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        db.insertarHuesoMascota(mascota);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }


}
