package com.ftn.sbnz.tim27.service.controller;

import com.ftn.sbnz.tim27.model.dto.KorisnikDTO;
import com.ftn.sbnz.tim27.model.dto.KredencijaliDTO;
import com.ftn.sbnz.tim27.model.models.*;
import com.ftn.sbnz.tim27.model.repos.AnimeRepo;
import com.ftn.sbnz.tim27.model.repos.MangaRepo;
import com.ftn.sbnz.tim27.model.repos.StudioRepo;
import com.ftn.sbnz.tim27.model.repos.ZanrRepo;
import com.ftn.sbnz.tim27.service.servis.KorisnikServis;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/korisnik")
public class KorisnikKontroler {
    private final KorisnikServis korisnikServis;
    @Autowired
    private AnimeRepo animeRepo;
    @Autowired
    private MangaRepo mangaRepo;

    @Autowired
    private ZanrRepo zanrRepo;

    @Autowired
    private StudioRepo studioRepo;

    @Autowired
    public KorisnikKontroler(KorisnikServis korisnikServis) {
        this.korisnikServis = korisnikServis;
    }

    @GetMapping("")
    public void pozdrav() {
        System.out.println("pozdrav");
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody KredencijaliDTO r) {
        System.out.println(r);
        Korisnik korisnik = korisnikServis.getKorisnikByEmail(r.getKorisniko_ime());
        System.out.println(korisnik);
        if (korisnik != null && korisnik.getLozinka().equals(r.getLozinka())) {
            return ResponseEntity.ok(new KorisnikDTO(korisnik));
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/manga/{id}")
    public ResponseEntity<?> getMangaRecs(@PathVariable Long id) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("mangaPreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();
//        DebugRuleRuntimeEventListener debugListener = new DebugRuleRuntimeEventListener();
//        kieSession.addEventListener(debugListener);
        try {
            Korisnik korisnik = korisnikServis.pronadjiPoId(id);


            for (Manga manga : mangaRepo.findAll()) {
                kieSession.insert(manga);
//                System.out.println(manga);
            }
            for (Zanr zanr : zanrRepo.findAll()) {
                ZanrBrojac zanrBrojac = new ZanrBrojac(zanr);
                kieSession.insert(zanrBrojac);
            }
            kieSession.insert(korisnik);
            List<Manga> li = new ArrayList<>();
            kieSession.insert(li);
            kieSession.fireAllRules();
            List<Manga> finalCollectedManga = new ArrayList<>();
            for (Object obj : kieSession.getObjects(new ClassObjectFilter(List.class))) {
                if (obj instanceof List) {
                    for (Object manga : (List) obj) {
                        if (manga instanceof Manga) {
                            finalCollectedManga.add((Manga) manga);
                        }
                    }
                }
            }
            kieSession.dispose();
            return ResponseEntity.ok(finalCollectedManga);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<?> getAnimeRecs(@PathVariable Long id) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("animePreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();
//        DebugRuleRuntimeEventListener debugListener = new DebugRuleRuntimeEventListener();
//        kieSession.addEventListener(debugListener);

        try {
            Korisnik korisnik = korisnikServis.pronadjiPoId(id);


            for (Anime anime : animeRepo.findAll()) {
                kieSession.insert(anime);
//                System.out.println(anime);
            }
            for (Zanr zanr : zanrRepo.findAll()) {
                ZanrBrojac zanrBrojac = new ZanrBrojac(zanr);
                kieSession.insert(zanrBrojac);
            }
            for (Studio studio : studioRepo.findAll()) {
                StudioBrojac studioBrojac = new StudioBrojac(studio);
                kieSession.insert(studioBrojac);
            }
            kieSession.insert(korisnik);
            List<Anime> li = new ArrayList<>();
            kieSession.insert(li);
            kieSession.fireAllRules();
            List<Anime> finalCollectedAnime = new ArrayList<>();
            for (Object obj : kieSession.getObjects(new ClassObjectFilter(List.class))) {
                if (obj instanceof List) {
                    for (Object anime : (List) obj) {
                        if (anime instanceof Anime) {
                            finalCollectedAnime.add((Anime) anime);
                        }
                    }
                }
            }
            kieSession.dispose();
            return ResponseEntity.ok(finalCollectedAnime);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/manga/{id}/dodajMangu")
    public ResponseEntity<?> dodajmangu(@RequestBody Long mid, @PathVariable Long id) {
        try {
            List<Manga> allManga = mangaRepo.findAll();
            Manga manga;
            Korisnik korisnik = korisnikServis.pronadjiPoId(id);
            allManga.removeAll(korisnik.getTrenutno_citanje());
            allManga.removeAll(korisnik.getIstorija2());
            allManga.removeAll(korisnik.getPlanira_citanje());
            allManga.removeAll(korisnik.getOdustao_citanje());
            allManga.removeAll(korisnik.getCrna_lista2());
            if (mid == 0L)
                manga = allManga.get(new Random().nextInt(allManga.size()));
            else
                manga = mangaRepo.findById(mid).get();
            korisnik.getPlanira_citanje().add(manga);
            korisnikServis.izmeniRadnika(korisnik);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/anime/{id}/dodajAnime")
    public ResponseEntity<?> dodajanime(@RequestBody Long aid, @PathVariable Long id) {
        try {
            List<Anime> allAnime = animeRepo.findAll();
            Anime anime;
            Korisnik korisnik = korisnikServis.pronadjiPoId(id);
            allAnime.removeAll(korisnik.getTrenutno_gledanje());
            allAnime.removeAll(korisnik.getIstorija());
            allAnime.removeAll(korisnik.getPlanira_gledanje());
            allAnime.removeAll(korisnik.getOdustao_gledanje());
            allAnime.removeAll(korisnik.getCrna_lista());
            if (aid == 0L)
                anime = allAnime.get(new Random().nextInt(allAnime.size()));
            else
                anime = animeRepo.findById(aid).get();
            korisnik.getPlanira_gledanje().add(anime);
            korisnikServis.izmeniRadnika(korisnik);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
