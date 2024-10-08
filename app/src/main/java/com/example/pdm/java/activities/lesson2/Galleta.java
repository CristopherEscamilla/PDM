package com.example.pdm.java.activities.lesson2;

import android.os.Parcel;
import android.os.Parcelable;

public class Galleta implements Parcelable {
    private String sabor;
    private int tamano; // Tamaño en centímetros

    // Constructor
    public Galleta(String sabor, int tamano) {
        this.sabor = sabor;
        this.tamano = tamano;
    }

    // Constructor para crear un objeto desde un Parcel
    protected Galleta(Parcel in) {
        sabor = in.readString();
        tamano = in.readInt();
    }

    // Métodos del Parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sabor);
        dest.writeInt(tamano);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Galleta> CREATOR = new Creator<Galleta>() {
        @Override
        public Galleta createFromParcel(Parcel in) {
            return new Galleta(in);
        }

        @Override
        public Galleta[] newArray(int size) {
            return new Galleta[size];
        }
    };

    // Métodos getter
    public String getSabor() {
        return sabor;
    }

    public int getTamaño() {
        return tamano;
    }
}