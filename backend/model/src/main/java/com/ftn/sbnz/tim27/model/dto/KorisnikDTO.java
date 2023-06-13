package com.ftn.sbnz.tim27.model.dto;

import com.ftn.sbnz.tim27.model.models.Korisnik;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KorisnikDTO {
    private String korisniko_ime;
    private String lozinka;
    private String email;
    private Long id;

    public KorisnikDTO(Korisnik korisnik){
        this.korisniko_ime=korisnik.getKorisniko_ime();
        this.lozinka=korisnik.getLozinka();
        this.email=korisnik.getEmail();
        this.id=korisnik.getId();


    }
}
