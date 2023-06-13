package com.ftn.sbnz.tim27.model.repos;

import com.ftn.sbnz.tim27.model.models.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepo extends JpaRepository<Manga,Long> {

}
