package com.ftn.sbnz.tim27.model.models;




import javax.persistence.*;
import javax.persistence.Entity;

import java.io.Serializable;
import java.util.ArrayList;


@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String email;
    private String korisniko_ime;
    private String lozinka;
    private ArrayList<Anime> trenutno_gledanje;
    private ArrayList<Anime> istorija;
    private ArrayList<Anime> planira_gledanje;
    private ArrayList<Anime> odustao_gledanje;
    private ArrayList<Anime> crna_lista;

    private ArrayList<Manga> trenutno_citanje;
    private ArrayList<Manga> istorija2;
    private ArrayList<Manga> planira_citanje;
    private ArrayList<Manga> odustao_citanje;
    private ArrayList<Manga> crna_lista2;

    public Korisnik() {

    }

    public Korisnik(Long id, String email, String korisniko_ime, String lozinka, ArrayList<Anime> trenutno_gledanje, ArrayList<Anime> istorija, ArrayList<Anime> planira_gledanje, ArrayList<Anime> odustao_gledanje, ArrayList<Anime> crna_lista, ArrayList<Manga> trenutno_citanje, ArrayList<Manga> istorija2, ArrayList<Manga> planira_citanje, ArrayList<Manga> odustao_citanje, ArrayList<Manga> crna_lista2) {
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

    public ArrayList<Anime> getTrenutno_gledanje() {
        return trenutno_gledanje;
    }

    public void setTrenutno_gledanje(ArrayList<Anime> trenutno_gledanje) {
        this.trenutno_gledanje = trenutno_gledanje;
    }

    public ArrayList<Anime> getIstorija() {
        return istorija;
    }

    public void setIstorija(ArrayList<Anime> istorija) {
        this.istorija = istorija;
    }

    public ArrayList<Anime> getPlanira_gledanje() {
        return planira_gledanje;
    }

    public void setPlanira_gledanje(ArrayList<Anime> planira_gledanje) {
        this.planira_gledanje = planira_gledanje;
    }

    public ArrayList<Anime> getOdustao_gledanje() {
        return odustao_gledanje;
    }

    public void setOdustao_gledanje(ArrayList<Anime> odustao_gledanje) {
        this.odustao_gledanje = odustao_gledanje;
    }

    public ArrayList<Anime> getCrna_lista() {
        return crna_lista;
    }

    public void setCrna_lista(ArrayList<Anime> crna_lista) {
        this.crna_lista = crna_lista;
    }

    public ArrayList<Manga> getTrenutno_citanje() {
        return trenutno_citanje;
    }

    public void setTrenutno_citanje(ArrayList<Manga> trenutno_citanje) {
        this.trenutno_citanje = trenutno_citanje;
    }

    public ArrayList<Manga> getIstorija2() {
        return istorija2;
    }

    public void setIstorija2(ArrayList<Manga> istorija2) {
        this.istorija2 = istorija2;
    }

    public ArrayList<Manga> getPlanira_citanje() {
        return planira_citanje;
    }

    public void setPlanira_citanje(ArrayList<Manga> planira_citanje) {
        this.planira_citanje = planira_citanje;
    }

    public ArrayList<Manga> getOdustao_citanje() {
        return odustao_citanje;
    }

    public void setOdustao_citanje(ArrayList<Manga> odustao_citanje) {
        this.odustao_citanje = odustao_citanje;
    }

    public ArrayList<Manga> getCrna_lista2() {
        return crna_lista2;
    }

    public void setCrna_lista2(ArrayList<Manga> crna_lista2) {
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
