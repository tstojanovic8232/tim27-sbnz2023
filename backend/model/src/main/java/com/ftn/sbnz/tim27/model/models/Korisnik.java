package com.ftn.sbnz.tim27.model.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.List;


@Entity
@org.springframework.data.annotation.AccessType(org.springframework.data.annotation.AccessType.Type.FIELD)
@Table(name = "korisnik")
@Data

public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String email;
    private String korisniko_ime;
    private String lozinka;

    public Korisnik() {
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Anime> trenutno_gledanje;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Anime> istorija;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Anime> planira_gledanje;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Anime> odustao_gledanje;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Anime> crna_lista;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Manga> trenutno_citanje;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Manga> istorija2;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Manga> planira_citanje;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Manga> odustao_citanje;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Manga> crna_lista2;


    public Korisnik(Long id, String email, String korisniko_ime, String lozinka, List<Anime> trenutno_gledanje, List<Anime> istorija, List<Anime> planira_gledanje, List<Anime> odustao_gledanje, List<Anime> crna_lista, List<Manga> trenutno_citanje, List<Manga> istorija2, List<Manga> planira_citanje, List<Manga> odustao_citanje, List<Manga> crna_lista2) {
        this.id = id;
        this.email = email;
        this.korisniko_ime = korisniko_ime;
        this.lozinka = lozinka;
        this.trenutno_gledanje = trenutno_gledanje;
        this.istorija = istorija;
        this.planira_gledanje = planira_gledanje;
        this.odustao_gledanje = odustao_gledanje;
        this.crna_lista = crna_lista;
        this.trenutno_citanje = trenutno_citanje;
        this.istorija2 = istorija2;
        this.planira_citanje = planira_citanje;
        this.odustao_citanje = odustao_citanje;
        this.crna_lista2 = crna_lista2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisniko_ime() {
        return korisniko_ime;
    }

    public void setKorisniko_ime(String korisniko_ime) {
        this.korisniko_ime = korisniko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public List<Anime> getTrenutno_gledanje() {
        return trenutno_gledanje;
    }

    public void setTrenutno_gledanje(List<Anime> trenutno_gledanje) {
        this.trenutno_gledanje = trenutno_gledanje;
    }

    public List<Anime> getIstorija() {
        return istorija;
    }

    public void setIstorija(List<Anime> istorija) {
        this.istorija = istorija;
    }

    public List<Anime> getPlanira_gledanje() {
        return planira_gledanje;
    }

    public void setPlanira_gledanje(List<Anime> planira_gledanje) {
        this.planira_gledanje = planira_gledanje;
    }

    public List<Anime> getOdustao_gledanje() {
        return odustao_gledanje;
    }

    public void setOdustao_gledanje(List<Anime> odustao_gledanje) {
        this.odustao_gledanje = odustao_gledanje;
    }

    public List<Anime> getCrna_lista() {
        return crna_lista;
    }

    public void setCrna_lista(List<Anime> crna_lista) {
        this.crna_lista = crna_lista;
    }

    public List<Manga> getTrenutno_citanje() {
        return (List<Manga>) trenutno_citanje;
    }

    public void setTrenutno_citanje(List<Manga> trenutno_citanje) {
        this.trenutno_citanje = trenutno_citanje;
    }

    public List<Manga> getIstorija2() {
        return (List<Manga>) istorija2;
    }

    public void setIstorija2(List<Manga> istorija2) {
        this.istorija2 = istorija2;
    }

    public List<Manga> getPlanira_citanje() {
        return (List<Manga>) planira_citanje;
    }

    public void setPlanira_citanje(List<Manga> planira_citanje) {
        this.planira_citanje = planira_citanje;
    }

    public List<Manga> getOdustao_citanje() {
        return (List<Manga>) odustao_citanje;
    }

    public void setOdustao_citanje(List<Manga> odustao_citanje) {
        this.odustao_citanje = odustao_citanje;
    }

    public List<Manga> getCrna_lista2() {
        return (List<Manga>) crna_lista2;
    }

    public void setCrna_lista2(List<Manga> crna_lista2) {
        this.crna_lista2 = crna_lista2;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", korisniko_ime='" + korisniko_ime + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", trenutno_gledanje=" + trenutno_gledanje +
                ", istorija=" + istorija +
                ", planira_gledanje=" + planira_gledanje +
                ", odustao_gledanje=" + odustao_gledanje +
                ", crna_lista=" + crna_lista +
                ", trenutno_citanje=" + trenutno_citanje +
                ", istorija2=" + istorija2 +
                ", planira_citanje=" + planira_citanje +
                ", odustao_citanje=" + odustao_citanje +
                ", crna_lista2=" + crna_lista2 +
                '}';
    }
}
