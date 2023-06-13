package com.ftn.sbnz.tim27.model.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@org.springframework.data.annotation.AccessType(org.springframework.data.annotation.AccessType.Type.FIELD)
@Table(name = "zanr")
@Data
@NoArgsConstructor
public class Zanr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String naziv;
    private Long m_mal_id;
    private Long a_mal_id;



    public Zanr(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Zanr(Long id, String naziv, Long m_mal_id, Long a_mal_id) {
        this.id = id;
        this.naziv = naziv;
        this.m_mal_id = m_mal_id;
        this.a_mal_id = a_mal_id;
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

    public Long getM_mal_id() {
        return m_mal_id;
    }

    public void setM_mal_id(Long m_mal_id) {
        this.m_mal_id = m_mal_id;
    }

    public Long getA_mal_id() {
        return a_mal_id;
    }

    public void setA_mal_id(Long a_mal_id) {
        this.a_mal_id = a_mal_id;
    }

    @Override
    public String toString() {
        return "Zanr{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", m_mal_id=" + m_mal_id +
                ", a_mal_id=" + a_mal_id +
                '}';
    }
}
