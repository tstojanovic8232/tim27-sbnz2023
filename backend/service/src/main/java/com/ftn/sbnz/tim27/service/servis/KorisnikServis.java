package com.ftn.sbnz.tim27.service.servis;


import com.ftn.sbnz.tim27.model.models.Korisnik;
import com.ftn.sbnz.tim27.model.repos.KorisnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class KorisnikServis {
    @Autowired
    private  KorisnikRepo korisnikRepo;

    public Korisnik dodajRadnika(Korisnik radnik){
        return korisnikRepo.save(radnik);
    }
    public List<Korisnik> pronadjiSveRadnike(){
        return korisnikRepo.findAll();
    }

    public Korisnik izmeniRadnika(Korisnik radnik){
        return korisnikRepo.save(radnik);
    }

    public Korisnik pronadjiPoId(Long id){
        return korisnikRepo.getById(id);

    }
    public void izbrisiRadnika(Long id){
        korisnikRepo.deleteRadnikById(id);

    }


    public Korisnik getKorisnikByEmail(String email) {
        System.out.println(email);
        return this.korisnikRepo.getKorisnikByEmail(email);
    }
}