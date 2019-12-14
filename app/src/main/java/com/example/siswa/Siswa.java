package com.example.siswa;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Siswa implements Serializable {
    private String nama;
    private String email;
    private String nisn;
    private String hp;
    private String alamat;
    private String key;

    public Siswa(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return " nama "+nama+"\n" +
                " "+email +"\n" +
                " "+nisn +"\n" +
                " "+hp +"\n" +
                " alamat "+alamat;
    }

    public Siswa(String nm, String eml, String nis, String h, String almt){
        nama = nm;
        email = eml;
        nisn = nis;
        hp = h;
        alamat = almt;
    }
}
