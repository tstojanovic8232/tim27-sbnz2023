package com.ftn.sbnz.tim27.model.dto;

import com.ftn.sbnz.tim27.model.models.Zanr;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MangaDTO {
    private String title;
    private ArrayList<Zanr> genres;

}
