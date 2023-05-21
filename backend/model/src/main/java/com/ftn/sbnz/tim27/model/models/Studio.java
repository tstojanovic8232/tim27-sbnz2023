package com.ftn.sbnz.tim27.model.models;

public class Studio {
    private Long id;
    private String naziv;

    public Studio() {
    }

    public Studio(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
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

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
