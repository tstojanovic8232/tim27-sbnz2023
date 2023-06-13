package com.ftn.sbnz.tim27.model.repos;

import com.ftn.sbnz.tim27.model.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepo extends JpaRepository<Anime, Long> {
}
