package com.ftn.sbnz.tim27.model.repos;

import com.ftn.sbnz.tim27.model.models.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepo extends JpaRepository<Studio, Long> {
}
