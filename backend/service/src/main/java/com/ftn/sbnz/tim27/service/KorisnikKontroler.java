package com.ftn.sbnz.tim27.service;

import com.ftn.sbnz.tim27.model.models.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KorisnikKontroler {
    @Autowired
    private KorisnikRepo korisnikRepo;

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody Korisnik r){
        System.out.println(r);
        Korisnik korisnik=korisnikRepo.getKorisnikByEmail(r.getEmail());
        System.out.println(korisnik);
        if(korisnik.getKorisniko_ime().equals(r.getKorisniko_ime()) && korisnik.getLozinka().equals(r.getLozinka()))

            return ResponseEntity.ok(korisnik);

        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }

}
