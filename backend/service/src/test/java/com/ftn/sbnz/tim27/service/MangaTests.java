package com.ftn.sbnz.tim27.service;
import com.ftn.sbnz.tim27.model.models.*;
import org.junit.jupiter.api.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MangaTests {
    @Test
    public void testPravilaZaNajcitanijiZanr() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("mangaPreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();
        Manga manga1 = new Manga();
        manga1.setId(1L);
        manga1.setNaziv("Manga 1");
        manga1.setAutor("Autor 1");
        manga1.setLista_zanrova(new ArrayList<>(Arrays.asList(new Zanr(1L, "Zanr 1"))));

        Manga manga2 = new Manga();
        manga2.setId(2L);
        manga2.setNaziv("Manga 2");
        manga2.setAutor("Autor 2");
        manga2.setLista_zanrova(new ArrayList<>(Arrays.asList(new Zanr(2L, "Zanr 2"))));

        Manga manga3 = new Manga();
        manga3.setId(3L);
        manga3.setNaziv("Manga 3");
        manga3.setAutor("Autor 3");
        manga3.setLista_zanrova(new ArrayList<>(Arrays.asList(new Zanr(1L, "Zanr 1"))));

        Korisnik korisnik = new Korisnik();
        korisnik.setId(1L);
        korisnik.setEmail("email@example.com");
        korisnik.setKorisniko_ime("korisniko_ime");
        korisnik.setLozinka("lozinka");
        korisnik.setTrenutno_citanje(new ArrayList<>(Arrays.asList(manga1)));
        korisnik.setIstorija2(new ArrayList<>(Arrays.asList(manga2)));
        korisnik.setPlanira_citanje(new ArrayList<>(Arrays.asList(manga3)));
        korisnik.setOdustao_citanje(new ArrayList<>());
        korisnik.setCrna_lista2(new ArrayList<>());
// Set the properties of the Korisnik object as needed


        ZanrBrojac zanrBrojac1 = new ZanrBrojac(new Zanr(1L, "Zanr 1"));
        ZanrBrojac zanrBrojac2 = new ZanrBrojac(new Zanr(2L, "Zanr 2"));



        kieSession.insert(korisnik);
        kieSession.insert(zanrBrojac1);
        kieSession.insert(zanrBrojac2);

        kieSession.insert(manga1);
        kieSession.insert(manga2);
        kieSession.insert(manga3);

        kieSession.fireAllRules();

        List<Zanr> najcitanijiZanrovi = new ArrayList<>();

        for (Object obj : kieSession.getObjects(new ClassObjectFilter(Zanr.class))) {
            if (obj instanceof Zanr) {
                najcitanijiZanrovi.add((Zanr) obj);
            }
        }

        System.out.println("Najcitaniji zanrovi: " + najcitanijiZanrovi);

        assert najcitanijiZanrovi.size() == 1;


        kieSession.dispose();

    }
    @Test
    public void testNegativniFeedbackZaJednuMangu() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("mangaPreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();

        Feedback feedback = new Feedback();
        feedback.setPozitivan(false);
        feedback.setZaZanr(false);
        feedback.setTip("manga");
        feedback.setMediaId(1L);

        Korisnik korisnik = new Korisnik();
        korisnik.setCrna_lista2(new ArrayList<>());

        Manga manga = new Manga();
        manga.setId(1L);

        kieSession.insert(feedback);
        kieSession.insert(korisnik);
        kieSession.insert(manga);

        kieSession.fireAllRules();

        List<Manga> crnaLista = korisnik.getCrna_lista2();
        System.out.println(crnaLista);
        assert crnaLista.size() == 1;
        assert crnaLista.contains(manga);

        kieSession.dispose();
    }

    @Test
    public void testNegativniFeedbackZaCeoAnimeZanr() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("mangaPreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();

        Feedback feedback = new Feedback();
        feedback.setPozitivan(false);
        feedback.setZaZanr(true);
        feedback.setTip("anime");
        feedback.setMediaId(1L);

        Korisnik korisnik = new Korisnik();
        korisnik.setCrna_lista2(new ArrayList<>());

        Manga manga = new Manga();
        manga.setId(1L);
        ArrayList<Zanr> zanrovi = new ArrayList<>();
        Zanr zanr = new Zanr();
        zanr.setId(1L);
        zanr.setNaziv("Action");
        zanrovi.add(zanr);
        manga.setLista_zanrova(zanrovi);

        Manga relatedManga1 = new Manga();
        relatedManga1.setId(2L);
        ArrayList<Zanr> relatedZanrovi1 = new ArrayList<>();
        Zanr relatedZanr1 = new Zanr();
        relatedZanr1.setId(2L);
        relatedZanr1.setNaziv("Romance");
        relatedZanrovi1.add(relatedZanr1);
        relatedManga1.setLista_zanrova(relatedZanrovi1);

        Manga relatedmanga2 = new Manga();
        relatedmanga2.setId(3L);
        ArrayList<Zanr> relatedZanrovi2 = new ArrayList<>();
        Zanr relatedZanr2 = new Zanr();
        relatedZanr2.setId(3L);
        relatedZanr2.setNaziv("Adventure");
        relatedZanrovi2.add(relatedZanr2);
        relatedZanrovi2.add(zanr);
        relatedmanga2.setLista_zanrova(relatedZanrovi2);

        kieSession.insert(feedback);
        kieSession.insert(korisnik);
        kieSession.insert(manga);
        kieSession.insert(relatedManga1);
        kieSession.insert(relatedmanga2);

        kieSession.fireAllRules();

        List<Manga> crnaLista = korisnik.getCrna_lista2();
        System.out.println(crnaLista);
        assert crnaLista.size() == 2;
        assert crnaLista.contains(manga);
        assert crnaLista.contains(relatedmanga2);

        kieSession.dispose();
    }
    @Test
    public void testCollectMangaPerGenre() {
        // Create KieServices and KieContainer
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("mangaPreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();

        try {
            // Prepare test data
            List<Manga> allManga = new ArrayList<>();
            List<Manga> collectedManga = new ArrayList<>();
            Zanr zanr = new Zanr();
            zanr.setId(1L); // Set the desired genre ID

            // Populate the allManga list with example manga
            Manga manga1 = new Manga();
            manga1.setId(1L);
            manga1.setNaziv("Manga 1");
            manga1.setLista_zanrova(new ArrayList<>());
            manga1.getLista_zanrova().add(zanr);
            allManga.add(manga1);

            Manga manga2 = new Manga();
            manga2.setId(2L);
            manga2.setNaziv("Manga 2");
            manga2.setLista_zanrova(new ArrayList<>());
            manga2.getLista_zanrova().add(zanr);
            allManga.add(manga2);

            // Populate the collectedManga list with example already collected manga
            Manga collectedManga1 = new Manga();
            collectedManga1.setId(3L);
            collectedManga1.setNaziv("Collected Manga 1");
            collectedManga1.setLista_zanrova(new ArrayList<>());
            collectedManga1.getLista_zanrova().add(zanr);
            collectedManga.add(collectedManga1);

            // Insert objects into the KieSession
            kieSession.insert(zanr);
            kieSession.insert(allManga);
            kieSession.insert(collectedManga);

            // Fire the rules
            kieSession.fireAllRules();

            // Retrieve the updated lists
            List<Manga> updatedCollectedManga = (List<Manga>) kieSession.getObjects(o -> o instanceof Manga);

            // Print the updated lists
            System.out.println("Collected Manga:");
            for (Manga manga : updatedCollectedManga) {
                System.out.println(manga);
            }
        } finally {
            // Dispose the KieSession
            kieSession.dispose();
        }
    }

    @Test
    public void testForwardChaining() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("mangaPreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();

        Korisnik korisnik = new Korisnik();
        korisnik.setId(1L);
        korisnik.setEmail("example@example.com");
        korisnik.setKorisniko_ime("example_user");
        korisnik.setLozinka("password");
        korisnik.setTrenutno_citanje(new ArrayList<>());
        korisnik.setIstorija2(new ArrayList<>());
        korisnik.setPlanira_citanje(new ArrayList<>());
        korisnik.setOdustao_citanje(new ArrayList<>());
        korisnik.setCrna_lista2(new ArrayList<>());

        Manga manga1 = new Manga();
        manga1.setId(1L);
        manga1.setNaziv("Attack on Titan");
        manga1.setAutor("Hajime Isayama");
        manga1.setLista_zanrova(Arrays.asList(new Zanr(1L, "Action"), new Zanr(2L, "Drama"), new Zanr(3L, "Fantasy"), new Zanr(4L, "Horror")));

        Manga manga2 = new Manga();
        manga2.setId(2L);
        manga2.setNaziv("Death Note");
        manga2.setAutor("Tsugumi Ohba");
        manga2.setLista_zanrova(Arrays.asList(new Zanr(5L, "Psychological"), new Zanr(6L, "Mystery"), new Zanr(7L, "Supernatural"), new Zanr(8L, "Thriller")));

        Manga manga3 = new Manga();
        manga3.setId(3L);
        manga3.setNaziv("One Piece");
        manga3.setAutor("Eiichiro Oda");
        manga3.setLista_zanrova(Arrays.asList(new Zanr(9L, "Adventure"), new Zanr(1L, "Action"), new Zanr(10L, "Comedy"), new Zanr(3L, "Fantasy")));

        Manga manga4 = new Manga();
        manga4.setId(4L);
        manga4.setNaziv("Naruto");
        manga4.setAutor("Masashi Kishimoto");
        manga4.setLista_zanrova(Arrays.asList(new Zanr(9L, "Adventure"), new Zanr(1L, "Action"), new Zanr(10L, "Comedy"), new Zanr(11L, "Drama")));

        Manga manga5 = new Manga();
        manga5.setId(5L);
        manga5.setNaziv("Bleach");
        manga5.setAutor("Tite Kubo");
        manga5.setLista_zanrova(Arrays.asList(new Zanr(1L, "Action"), new Zanr(10L, "Comedy"), new Zanr(18L, "Supernatural"), new Zanr(20L, "Adventure")));

        Manga manga6 = new Manga();
        manga6.setId(6L);
        manga6.setNaziv("Fullmetal Alchemist");
        manga6.setAutor("Hiromu Arakawa");
        manga6.setLista_zanrova(Arrays.asList(new Zanr(1L, "Action"), new Zanr(12L, "Adventure"), new Zanr(13L, "Drama"), new Zanr(14L, "Fantasy")));

        Manga manga7 = new Manga();
        manga7.setId(7L);
        manga7.setNaziv("Tokyo Ghoul");
        manga7.setAutor("Sui Ishida");
        manga7.setLista_zanrova(Arrays.asList(new Zanr(1L, "Action"), new Zanr(15L, "Horror"), new Zanr(16L, "Psychological"), new Zanr(17L, "Supernatural")));

        Manga manga8 = new Manga();
        manga8.setId(8L);
        manga8.setNaziv("Hunter x Hunter");
        manga8.setAutor("Yoshihiro Togashi");
        manga8.setLista_zanrova(Arrays.asList(new Zanr(1L, "Action"), new Zanr(12L, "Adventure"), new Zanr(18L, "Fantasy"), new Zanr(19L, "Supernatural")));

        Manga manga9 = new Manga();
        manga9.setId(9L);
        manga9.setNaziv("My Hero Academia");
        manga9.setAutor("Kohei Horikoshi");
        manga9.setLista_zanrova(Arrays.asList(new Zanr(1L, "Action"), new Zanr(10L, "Comedy"), new Zanr(21L, "School"), new Zanr(12L, "Adventure")));

        Manga manga10 = new Manga();
        manga10.setId(10L);
        manga10.setNaziv("Demon Slayer: Kimetsu no Yaiba");
        manga10.setAutor("Koyoharu Gotouge");
        manga10.setLista_zanrova(Arrays.asList(new Zanr(1L, "Action"), new Zanr(15L, "Horror"), new Zanr(18L, "Fantasy"), new Zanr(22L, "Supernatural")));


        korisnik.getTrenutno_citanje().add(manga1);
        korisnik.getTrenutno_citanje().add(manga2);

        korisnik.getIstorija2().add(manga3);

        korisnik.getPlanira_citanje().add(manga6);
        korisnik.getOdustao_citanje().add(manga7);

        korisnik.getCrna_lista2().add(manga9);

        ZanrBrojac zanrBrojac1 = new ZanrBrojac(new Zanr(1L, "Action"));
        ZanrBrojac zanrBrojac2 = new ZanrBrojac(new Zanr(2L, "Drama"));
        ZanrBrojac zanrBrojac3 = new ZanrBrojac(new Zanr(3L, "Fantasy"));
        ZanrBrojac zanrBrojac4 = new ZanrBrojac(new Zanr(4L, "Horror"));
        ZanrBrojac zanrBrojac5 = new ZanrBrojac(new Zanr(5L, "Psychological"));
        ZanrBrojac zanrBrojac6 = new ZanrBrojac(new Zanr(6L, "Mystery"));
        ZanrBrojac zanrBrojac7 = new ZanrBrojac(new Zanr(7L, "Supernatural"));
        ZanrBrojac zanrBrojac8 = new ZanrBrojac(new Zanr(8L, "Thriller"));
        ZanrBrojac zanrBrojac9 = new ZanrBrojac(new Zanr(9L, "Adventure"));
        ZanrBrojac zanrBrojac10 = new ZanrBrojac(new Zanr(10L, "Comedy"));
        ZanrBrojac zanrBrojac11 = new ZanrBrojac(new Zanr(11L, "Drama"));
        ZanrBrojac zanrBrojac12 = new ZanrBrojac(new Zanr(12L, "Adventure"));
        ZanrBrojac zanrBrojac13 = new ZanrBrojac(new Zanr(13L, "Fantasy"));
        ZanrBrojac zanrBrojac14 = new ZanrBrojac(new Zanr(14L, "Horror"));
        ZanrBrojac zanrBrojac15 = new ZanrBrojac(new Zanr(15L, "Psychological"));
        ZanrBrojac zanrBrojac16 = new ZanrBrojac(new Zanr(16L, "Supernatural"));
        ZanrBrojac zanrBrojac17 = new ZanrBrojac(new Zanr(17L, "Supernatural"));
        ZanrBrojac zanrBrojac18 = new ZanrBrojac(new Zanr(18L, "Fantasy"));
        ZanrBrojac zanrBrojac19 = new ZanrBrojac(new Zanr(19L, "Supernatural"));
        ZanrBrojac zanrBrojac20 = new ZanrBrojac(new Zanr(20L, "Adventure"));
        ZanrBrojac zanrBrojac21 = new ZanrBrojac(new Zanr(21L, "School"));
        ZanrBrojac zanrBrojac22 = new ZanrBrojac(new Zanr(22L, "Supernatural"));


        List<Manga> collectedManga=new ArrayList<>();
        // Insert manga and user into the session
        kieSession.insert(korisnik);
        kieSession.insert(manga1);
        kieSession.insert(manga2);
        kieSession.insert(manga3);
        kieSession.insert(manga4);
        kieSession.insert(manga5);
        kieSession.insert(manga6);
        kieSession.insert(manga7);
        kieSession.insert(manga8);
        kieSession.insert(manga9);
        kieSession.insert(manga10);

        kieSession.insert(zanrBrojac1);
        kieSession.insert(zanrBrojac2);
        kieSession.insert(zanrBrojac3);
        kieSession.insert(zanrBrojac4);
        kieSession.insert(zanrBrojac5);
        kieSession.insert(zanrBrojac6);
        kieSession.insert(zanrBrojac7);
        kieSession.insert(zanrBrojac8);
        kieSession.insert(zanrBrojac9);
        kieSession.insert(zanrBrojac10);
        kieSession.insert(zanrBrojac11);
        kieSession.insert(zanrBrojac12);
        kieSession.insert(zanrBrojac13);
        kieSession.insert(zanrBrojac14);
        kieSession.insert(zanrBrojac15);
        kieSession.insert(zanrBrojac16);
        kieSession.insert(zanrBrojac17);
        kieSession.insert(zanrBrojac18);
        kieSession.insert(zanrBrojac19);
        kieSession.insert(zanrBrojac20);
        kieSession.insert(zanrBrojac21);
        kieSession.insert(zanrBrojac22);
        kieSession.insert(collectedManga);
        // Fire the rules
        kieSession.fireAllRules();

        // Retrieve recommended manga from the session
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
        System.out.println(finalCollectedManga);

        kieSession.dispose();
    }

}
