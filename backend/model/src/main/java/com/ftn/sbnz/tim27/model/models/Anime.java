package com.ftn.sbnz.tim27.model.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@org.springframework.data.annotation.AccessType(org.springframework.data.annotation.AccessType.Type.FIELD)
@Table(name="anime")
@Data
@NoArgsConstructor
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String naziv;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "anime_studio",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id")
    )
    private List<Studio> studiji;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "anime_zanr",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "zanr_id")
    )
    private List<Zanr> zanrovi;

    private String sezona;
    private String godina;
    private String izvor;

    public Anime(Long id) {
        this.id = id;
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
