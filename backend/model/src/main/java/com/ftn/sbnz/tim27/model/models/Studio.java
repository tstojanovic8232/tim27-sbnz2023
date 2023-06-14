package com.ftn.sbnz.tim27.model.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@org.springframework.data.annotation.AccessType(org.springframework.data.annotation.AccessType.Type.FIELD)
@Table(name="studio")
@Data
@NoArgsConstructor
public class Studio {
    @Id
    @Column(nullable = false, updatable = false)
    private Long id;
    private String naziv;



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
