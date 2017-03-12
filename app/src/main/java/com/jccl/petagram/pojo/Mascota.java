package com.jccl.petagram.pojo;

import android.media.Image;

/**
 * Created by ashnic gr on 28/02/2017.
 */

public class Mascota {

    private String nombre;
    private int Imagen;
    private int Huesos = 0;
    private boolean favorito;

    public Mascota(String nombre, int imagen) {
        this.nombre = nombre;
        Imagen = imagen;
    }

    public Mascota(String nombre, int imagen, int huesos) {
        this.nombre = nombre;
        Imagen = imagen;
        this.Huesos = huesos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public int getHuesos() {
        return Huesos;
    }

    public void setHuesos(int huesos) {
        Huesos = huesos;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public void DarHueso(){
        this.Huesos = this.Huesos +1;
    }
}
