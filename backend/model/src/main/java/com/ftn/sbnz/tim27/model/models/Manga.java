package com.ftn.sbnz.tim27.model.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@org.springframework.data.annotation.AccessType(org.springframework.data.annotation.AccessType.Type.FIELD)
@Table(name="manga")
@Data
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String naziv;
    private String autor;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id")
    private List<Zanr> lista_zanrova;


    public Manga(){

    }

    public Manga(Long id, String naziv, String autor, ArrayList<Zanr> lista_zanrova) {
        this.id = id;
        this.naziv = naziv;
        this.autor = autor;
        this.lista_zanrova = lista_zanrova;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ArrayList<Zanr> getLista_zanrova() {
        return (ArrayList<Zanr>) lista_zanrova;
    }

    public void setLista_zanrova(ArrayList<Zanr> lista_zanrova) {
        this.lista_zanrova = lista_zanrova;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", autor='" + autor + '\'' +
                ", lista_zanrova=" + lista_zanrova +
                '}';
    }
}
