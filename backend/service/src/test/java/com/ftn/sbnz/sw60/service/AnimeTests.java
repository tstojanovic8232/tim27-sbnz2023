package com.ftn.sbnz.sw60.service;
import com.ftn.sbnz.tim27.model.models.*;
import org.junit.jupiter.api.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AnimeTests {

    @Test
    public void testPravilaZaNajgledanijeFaktore() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("animePreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();
        
        Anime anime1 = new Anime();
        anime1.setId(1L);
        anime1.setNaziv("Anime 1");
        anime1.setStudiji(Arrays.asList(new Studio(1L, "Studio 1")));
        anime1.setZanrovi(Arrays.asList(new Zanr(1L, "Zanr 1")));

        Anime anime2 = new Anime();
        anime2.setId(2L);
        anime2.setNaziv("Anime 2");
        anime2.setStudiji(Arrays.asList(new Studio(3L, "Studio 3")));
        anime2.setZanrovi(Arrays.asList(new Zanr(2L, "Zanr 2")));

        Anime anime3 = new Anime();
        anime3.setId(3L);
        anime3.setNaziv("Anime 3");
        anime3.setStudiji(Arrays.asList(new Studio(3L, "Studio 3")));
        anime3.setZanrovi(Arrays.asList(new Zanr(1L, "Zanr 1")));

        Korisnik korisnik = new Korisnik();
        korisnik.setId(1L);
        korisnik.setEmail("email@example.com");
        korisnik.setKorisniko_ime("korisniko_ime");
        korisnik.setLozinka("lozinka");
        korisnik.setTrenutno_gledanje(new ArrayList<>(Arrays.asList(anime1)));
        korisnik.setIstorija(new ArrayList<>(Arrays.asList(anime2)));
        korisnik.setPlanira_gledanje(new ArrayList<>(Arrays.asList(anime3)));
        korisnik.setOdustao_gledanje(new ArrayList<>());
        korisnik.setCrna_lista(new ArrayList<>());

        kieSession.insert(korisnik);
        kieSession.insert(anime1);
        kieSession.insert(anime2);
        kieSession.insert(anime3);

        kieSession.fireAllRules();

        List<String> najgledanijiZanrovi = new ArrayList<>();
        List<String> najgledanijiStudiji = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger();

        kieSession.getObjects().forEach(obj -> {
            if (obj instanceof List && ((List<?>) obj).get(0) instanceof String) {
                List<String> rezultati = (List<String>) obj;
                if (counter.get() < 1) {
                    najgledanijiStudiji.addAll(rezultati);
                } else {
                    najgledanijiZanrovi.addAll(rezultati);
                }
                counter.getAndIncrement();
            }
        });

        System.out.println("Najgledaniji zanrovi: " + najgledanijiZanrovi);
        System.out.println("Najgledaniji studiji: " + najgledanijiStudiji);
        assert najgledanijiZanrovi.size() == 1;
        assert najgledanijiStudiji.size() == 1;

        kieSession.dispose();
    }

    @Test
    public void testNegativeFeedbackForOneAnime() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("animeKieBase");

        KieSession kieSession = kieBase.newKieSession();

        Feedback feedback = new Feedback();
        feedback.setPozitivan(false);
        feedback.setZaZanr(false);
        feedback.setTip("anime");
        feedback.setMediaId(1L);

        Korisnik korisnik = new Korisnik();
        korisnik.setCrna_lista(new ArrayList<>());

        Anime anime = new Anime();
        anime.setId(1L);

        kieSession.insert(feedback);
        kieSession.insert(korisnik);
        kieSession.insert(anime);

        kieSession.fireAllRules();

        List<Anime> crnaLista = korisnik.getCrna_lista();
        System.out.println(crnaLista);
        assert crnaLista.size() == 1;
        assert crnaLista.contains(anime);

        kieSession.dispose();
    }

    @Test
    public void testNegativeFeedbackForWholeAnimeGenre() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("animeKieBase");

        KieSession kieSession = kieBase.newKieSession();

        Feedback feedback = new Feedback();
        feedback.setPozitivan(false);
        feedback.setZaZanr(true);
        feedback.setTip("anime");
        feedback.setMediaId(1L);

        Korisnik korisnik = new Korisnik();
        korisnik.setCrna_lista(new ArrayList<>());

        Anime anime = new Anime();
        anime.setId(1L);
        List<Zanr> zanrovi = new ArrayList<>();
        Zanr zanr = new Zanr();
        zanr.setId(1L);
        zanr.setNaziv("Action");
        zanrovi.add(zanr);
        anime.setZanrovi(zanrovi);

        Anime relatedAnime1 = new Anime();
        relatedAnime1.setId(2L);
        List<Zanr> relatedZanrovi1 = new ArrayList<>();
        Zanr relatedZanr1 = new Zanr();
        relatedZanr1.setId(2L);
        relatedZanr1.setNaziv("Romance");
        relatedZanrovi1.add(relatedZanr1);
        relatedAnime1.setZanrovi(relatedZanrovi1);

        Anime relatedAnime2 = new Anime();
        relatedAnime2.setId(3L);
        List<Zanr> relatedZanrovi2 = new ArrayList<>();
        Zanr relatedZanr2 = new Zanr();
        relatedZanr2.setId(3L);
        relatedZanr2.setNaziv("Adventure");
        relatedZanrovi2.add(relatedZanr2);
        relatedZanrovi2.add(zanr);
        relatedAnime2.setZanrovi(relatedZanrovi2);

        kieSession.insert(feedback);
        kieSession.insert(korisnik);
        kieSession.insert(anime);
        kieSession.insert(relatedAnime1);
        kieSession.insert(relatedAnime2);

        kieSession.fireAllRules();

        List<Anime> crnaLista = korisnik.getCrna_lista();
        System.out.println(crnaLista);
        assert crnaLista.size() == 2;
        assert crnaLista.contains(anime);
        assert crnaLista.contains(relatedAnime2);

        kieSession.dispose();
    }
}


