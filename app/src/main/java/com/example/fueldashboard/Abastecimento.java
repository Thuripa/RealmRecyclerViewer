package com.example.fueldashboard;

import android.os.Parcel;
import android.os.Parcelable;

public class Abastecimento implements Parcelable {

    private int id;
    private String posto;
    private float litros;
    private float valor;
    private float km;

    public Abastecimento() {

    }

    public Abastecimento(int id, String posto, float litros, float valor, int km) {
        this.setId(id);
        this.setPosto(posto);
        this.setLitros(litros);
        this.setValor(valor);
        this.setKm(km);
    }


    protected Abastecimento(Parcel in) {
        id = in.readInt();
        posto = in.readString();
        litros = in.readFloat();
        valor = in.readFloat();
        km = in.readFloat();
    }

    public static final Creator<Abastecimento> CREATOR = new Creator<Abastecimento>() {
        @Override
        public Abastecimento createFromParcel(Parcel in) {
            return new Abastecimento(in);
        }

        @Override
        public Abastecimento[] newArray(int size) {
            return new Abastecimento[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(posto);
        dest.writeFloat(litros);
        dest.writeFloat(valor);
        dest.writeFloat(km);
    }




    // Getter's e Setter's

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }
}
