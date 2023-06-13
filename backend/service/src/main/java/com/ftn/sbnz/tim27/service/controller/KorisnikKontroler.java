package com.ftn.sbnz.tim27.service.controller;

import com.ftn.sbnz.tim27.model.dto.KorisnikDTO;
import com.ftn.sbnz.tim27.model.dto.KredencijaliDTO;
import com.ftn.sbnz.tim27.model.models.Korisnik;
import com.ftn.sbnz.tim27.service.servis.KorisnikServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/korisnik")
public class KorisnikKontroler {
    private final KorisnikServis korisnikServis;

    @Autowired
    public KorisnikKontroler(KorisnikServis korisnikServis) {
        this.korisnikServis = korisnikServis;
    }
    @GetMapping("")
    public void pozdrav(){
        System.out.println("pozdrav");
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody KredencijaliDTO r) {
        System.out.println(r);
        Korisnik korisnik = korisnikServis.getKorisnikByEmail(r.getKorisniko_ime());
        System.out.println(korisnik);
        if (korisnik != null &&  korisnik.getLozinka().equals(r.getLozinka())) {
            return ResponseEntity.ok(new KorisnikDTO(korisnik));
        }
        return ResponseEntity.internalServerError().build();
    }
}
