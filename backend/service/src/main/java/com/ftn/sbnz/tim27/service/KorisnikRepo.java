package com.ftn.sbnz.tim27.service;

import com.ftn.sbnz.tim27.model.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepo extends JpaRepository<Korisnik,Long> {
    Korisnik getKorisnikByEmail(String email);
    void deleteRadnikById(Long id);

    Korisnik findRadnikById(Long id);

    }