package com.jccl.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jccl.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ashnic gr on 16/03/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;


    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                       ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                       ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                       ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN + " TEXT, " +
                       ConstantesBaseDatos.TABLE_MASCOTA_HUESOS + " INTEGER" +
                       ")";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerTodasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));
            mascotaActual.setHuesos(registros.getInt(3));
            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA +
                        " ORDER BY " + ConstantesBaseDatos.TABLE_MASCOTA_HUESOS + " DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));
            mascotaActual.setHuesos(registros.getInt(3));
            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarHuesoMascota(Mascota mascota){
        int huesos = obtenerLikesMascota(mascota);
        huesos = huesos +1;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + ConstantesBaseDatos.TABLE_MASCOTA +
                       " SET " + ConstantesBaseDatos.TABLE_MASCOTA_HUESOS + " = " + huesos +
                       " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " + mascota.getId();
        db.execSQL(query);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTA_HUESOS + " FROM " +
                        ConstantesBaseDatos.TABLE_MASCOTA + " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " +
                        mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }


}
