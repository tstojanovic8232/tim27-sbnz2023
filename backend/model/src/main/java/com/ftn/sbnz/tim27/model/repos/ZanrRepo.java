package com.ftn.sbnz.tim27.model.repos;


import com.ftn.sbnz.tim27.model.models.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZanrRepo extends JpaRepository<Zanr,Long> {
    Zanr findZanrById(Long id);
}
