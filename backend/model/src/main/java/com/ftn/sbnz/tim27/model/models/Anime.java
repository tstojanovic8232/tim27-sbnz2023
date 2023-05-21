package com.ftn.sbnz.tim27.model.models;

import java.util.List;

public class Anime {
    private Long id;
    private String naziv;
    private List<Studio> studiji;
    private List<Zanr> zanrovi;
    private String sezona;
    private String godina;
    private String izvor;

    public Anime() {
    }

    public Anime(Long id, String naziv, List<Studio> studiji, List<Zanr> zanrovi, String sezona, String godina, String izvor) {
        this.id = id;
        this.naziv = naziv;
        this.studiji = studiji;
        this.zanrovi = zanrovi;
        this.sezona = sezona;
        this.godina = godina;
        this.izvor = izvor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Studio> getStudiji() {
        return studiji;
    }

    public void setStudiji(List<Studio> studiji) {
        this.studiji = studiji;
    }

    public List<Zanr> getZanrovi() {
        return zanrovi;
    }

    public void setZanrovi(List<Zanr> zanrovi) {
        this.zanrovi = zanrovi;
    }

    public String getSezona() {
        return sezona;
    }

    public void setSezona(String sezona) {
        this.sezona = sezona;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    public String getIzvor() {
        return izvor;
    }

    public void setIzvor(String izvor) {
        this.izvor = izvor;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", studiji=" + studiji +
                ", zanrovi=" + zanrovi +
                ", sezona='" + sezona + '\'' +
                ", godina='" + godina + '\'' +
                ", izvor='" + izvor + '\'' +
                '}';
    }
}
