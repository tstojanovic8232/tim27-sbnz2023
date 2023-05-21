package models;

import java.util.ArrayList;

public class Korisnik {
    private Long id;
    private String korisniko_ime;
    private String lozinka;
    private ArrayList<Anime> trenutno_gledanje;
    private ArrayList<Anime> istorija;
    private ArrayList<Anime> planira_gledanje;
    private ArrayList<Anime> odustao_gledanje;
    private ArrayList<Anime> crna_lista;

    public Korisnik(){

    }

    public Korisnik(Long id, String korisniko_ime, String lozinka, ArrayList<Anime> trenutno_gledanje, ArrayList<Anime> istorija, ArrayList<Anime> planira_gledanje, ArrayList<Anime> odustao_gledanje, ArrayList<Anime> crna_lista) {
        this.id = id;
        this.korisniko_ime = korisniko_ime;
        this.lozinka = lozinka;
        this.trenutno_gledanje = trenutno_gledanje;
        this.istorija = istorija;
        this.planira_gledanje = planira_gledanje;
        this.odustao_gledanje = odustao_gledanje;
        this.crna_lista = crna_lista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Korisnik{" +
                "id='" + id + '\'' +
                ", korisniko_ime='" + korisniko_ime + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", trenutno_gledanje=" + trenutno_gledanje +
                ", istorija=" + istorija +
                ", planira_gledanje=" + planira_gledanje +
                ", odustao_gledanje=" + odustao_gledanje +
                ", crna_lista=" + crna_lista +
                '}';
    }
}
