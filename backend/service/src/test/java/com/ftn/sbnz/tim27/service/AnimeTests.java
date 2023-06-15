package com.ftn.sbnz.tim27.service;

import com.ftn.sbnz.tim27.model.models.*;
import org.junit.jupiter.api.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimeTests {

    @Test
    public void testPravilaZaNajgledanijeFaktore() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("animePreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();

        Anime anime1 = new Anime();
        anime1.setId(1L);
        anime1.setNaziv("Attack on Titan");
        anime1.setStudiji(Arrays.asList(new Studio(1L, "Wit Studio")));
        anime1.setZanrovi(Arrays.asList(new Zanr(1L, "Action")));
        anime1.setSezona("Spring");
        anime1.setGodina("2013");
        anime1.setIzvor("Manga");

        Anime anime2 = new Anime();
        anime2.setId(2L);
        anime2.setNaziv("Death Note");
        anime2.setStudiji(Arrays.asList(new Studio(2L, "Madhouse")));
        anime2.setZanrovi(Arrays.asList(new Zanr(2L, "Psychological"), new Zanr(3L, "Thriller")));
        anime2.setSezona("Fall");
        anime2.setGodina("2006");
        anime2.setIzvor("Manga");

        Anime anime3 = new Anime();
        anime3.setId(3L);
        anime3.setNaziv("One Piece");
        anime3.setStudiji(Arrays.asList(new Studio(3L, "Toei Animation")));
        anime3.setZanrovi(Arrays.asList(new Zanr(4L, "Adventure")));
        anime3.setSezona("Fall");
        anime3.setGodina("1999");
        anime3.setIzvor("Manga");

        Anime anime4 = new Anime();
        anime4.setId(4L);
        anime4.setNaziv("Naruto");
        anime4.setStudiji(Arrays.asList(new Studio(4L, "Studio Pierrot")));
        anime4.setZanrovi(Arrays.asList(new Zanr(1L, "Action")));
        anime4.setSezona("Fall");
        anime4.setGodina("2002");
        anime4.setIzvor("Manga");

        Anime anime5 = new Anime();
        anime5.setId(5L);
        anime5.setNaziv("Demon Slayer: Kimetsu no Yaiba");
        anime5.setStudiji(Arrays.asList(new Studio(5L, "ufotable")));
        anime5.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(6L, "Supernatural")));
        anime5.setSezona("Spring");
        anime5.setGodina("2019");
        anime5.setIzvor("Manga");

        Anime anime6 = new Anime();
        anime6.setId(6L);
        anime6.setNaziv("Fullmetal Alchemist: Brotherhood");
        anime6.setStudiji(Arrays.asList(new Studio(6L, "Bones")));
        anime6.setZanrovi(Arrays.asList(new Zanr(4L, "Adventure"), new Zanr(5L, "Fantasy")));
        anime6.setSezona("Spring");
        anime6.setGodina("2009");
        anime6.setIzvor("Manga");

        Anime anime7 = new Anime();
        anime7.setId(7L);
        anime7.setNaziv("My Hero Academia");
        anime7.setStudiji(Arrays.asList(new Studio(6L, "Bones")));
        anime7.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(13L, "Super Power")));
        anime7.setSezona("Spring");
        anime7.setGodina("2016");
        anime7.setIzvor("Manga");

        Anime anime8 = new Anime();
        anime8.setId(8L);
        anime8.setNaziv("Steins;Gate");
        anime8.setStudiji(Arrays.asList(new Studio(7L, "White Fox")));
        anime8.setZanrovi(Arrays.asList(new Zanr(10L, "Sci-Fi"), new Zanr(3L, "Thriller")));
        anime8.setSezona("Spring");
        anime8.setGodina("2011");
        anime8.setIzvor("Visual Novel");

        Anime anime9 = new Anime();
        anime9.setId(9L);
        anime9.setNaziv("Code Geass: Lelouch of the Rebellion");
        anime9.setStudiji(Arrays.asList(new Studio(8L, "Sunrise")));
        anime9.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(5L, "Fantasy"), new Zanr(14L, "Mecha")));
        anime9.setSezona("Fall");
        anime9.setGodina("2006");
        anime9.setIzvor("Original");

        Anime anime10 = new Anime();
        anime10.setId(10L);
        anime10.setNaziv("Hunter x Hunter (2011)");
        anime10.setStudiji(Arrays.asList(new Studio(2L, "Madhouse")));
        anime10.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(4L, "Adventure")));
        anime10.setSezona("Fall");
        anime10.setGodina("2011");
        anime10.setIzvor("Manga");

        Anime anime11 = new Anime();
        anime11.setId(11L);
        anime11.setNaziv("Your Lie in April");
        anime11.setStudiji(Arrays.asList(new Studio(9L, "A-1 Pictures")));
        anime11.setZanrovi(Arrays.asList(new Zanr(8L, "Drama"), new Zanr(15L, "Music"), new Zanr(9L, "Romance")));
        anime11.setSezona("Fall");
        anime11.setGodina("2014");
        anime11.setIzvor("Manga");

        Anime anime12 = new Anime();
        anime12.setId(12L);
        anime12.setNaziv("One Punch Man");
        anime12.setStudiji(Arrays.asList(new Studio(2L, "Madhouse")));
        anime12.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(13L, "Super Power"), new Zanr(11L, "Comedy")));
        anime12.setSezona("Fall");
        anime12.setGodina("2015");
        anime12.setIzvor("Webcomic");

        Anime anime13 = new Anime();
        anime13.setId(13L);
        anime13.setNaziv("Attack on Titan");
        anime13.setStudiji(Arrays.asList(new Studio(1L, "Wit Studio")));
        anime13.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(5L, "Fantasy")));
        anime13.setSezona("Spring");
        anime13.setGodina("2013");
        anime13.setIzvor("Manga");

        Anime anime14 = new Anime();
        anime14.setId(14L);
        anime14.setNaziv("Death Note");
        anime14.setStudiji(Arrays.asList(new Studio(2L, "Madhouse")));
        anime14.setZanrovi(Arrays.asList(new Zanr(2L, "Psychological"), new Zanr(7L, "Mystery"), new Zanr(6L, "Supernatural")));
        anime14.setSezona("Fall");
        anime14.setGodina("2006");
        anime14.setIzvor("Manga");

        Anime anime15 = new Anime();
        anime15.setId(15L);
        anime15.setNaziv("Naruto");
        anime15.setStudiji(Arrays.asList(new Studio(4L, "Studio Pierrot")));
        anime15.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(4L, "Adventure"), new Zanr(12L, "Shounen")));
        anime15.setSezona("Fall");
        anime15.setGodina("2002");
        anime15.setIzvor("Manga");


        Korisnik korisnik = new Korisnik();
        korisnik.setId(1L);
        korisnik.setEmail("example@example.com");
        korisnik.setKorisniko_ime("example_user");
        korisnik.setLozinka("password");
        korisnik.setTrenutno_gledanje(new ArrayList<>());
        korisnik.setIstorija(new ArrayList<>());
        korisnik.setPlanira_gledanje(new ArrayList<>());
        korisnik.setOdustao_gledanje(new ArrayList<>());
        korisnik.setCrna_lista(new ArrayList<>());

        korisnik.getTrenutno_gledanje().add(anime1);
        korisnik.getTrenutno_gledanje().add(anime2);

        korisnik.getIstorija().add(anime3);
        korisnik.getIstorija().add(anime4);

        korisnik.getPlanira_gledanje().add(anime5);

        korisnik.getOdustao_gledanje().add(anime6);

        korisnik.getCrna_lista().add(anime7);

        Studio studio1 = new Studio(1L, "Wit Studio");
        Studio studio2 = new Studio(2L, "Madhouse");
        Studio studio3 = new Studio(3L, "Toei Animation");
        Studio studio4 = new Studio(4L, "Studio Pierrot");
        Studio studio5 = new Studio(5L, "ufotable");
        Studio studio6 = new Studio(6L, "Bones");
        Studio studio7 = new Studio(7L, "White Fox");
        Studio studio8 = new Studio(8L, "Sunrise");
        Studio studio9 = new Studio(9L, "A-1 Pictures");

        Zanr zanr1 = new Zanr(1L, "Action");
        Zanr zanr2 = new Zanr(2L, "Psychological");
        Zanr zanr3 = new Zanr(3L, "Thriller");
        Zanr zanr4 = new Zanr(4L, "Adventure");
        Zanr zanr5 = new Zanr(5L, "Fantasy");
        Zanr zanr6 = new Zanr(6L, "Supernatural");
        Zanr zanr7 = new Zanr(7L, "Mystery");
        Zanr zanr8 = new Zanr(8L, "Drama");
        Zanr zanr9 = new Zanr(9L, "Romance");
        Zanr zanr10 = new Zanr(10L, "Sci-Fi");
        Zanr zanr11 = new Zanr(11L, "Comedy");
        Zanr zanr12 = new Zanr(12L, "Shounen");
        Zanr zanr13 = new Zanr(13L, "Super Power");
        Zanr zanr14 = new Zanr(14L, "Mecha");
        Zanr zanr15 = new Zanr(15L, "Music");


        ZanrBrojac zanrBrojac1 = new ZanrBrojac(zanr1);
        ZanrBrojac zanrBrojac2 = new ZanrBrojac(zanr2);
        ZanrBrojac zanrBrojac3 = new ZanrBrojac(zanr3);
        ZanrBrojac zanrBrojac4 = new ZanrBrojac(zanr4);
        ZanrBrojac zanrBrojac5 = new ZanrBrojac(zanr5);
        ZanrBrojac zanrBrojac6 = new ZanrBrojac(zanr6);
        ZanrBrojac zanrBrojac7 = new ZanrBrojac(zanr7);
        ZanrBrojac zanrBrojac8 = new ZanrBrojac(zanr8);
        ZanrBrojac zanrBrojac9 = new ZanrBrojac(zanr9);
        ZanrBrojac zanrBrojac10 = new ZanrBrojac(zanr10);
        ZanrBrojac zanrBrojac11 = new ZanrBrojac(zanr11);
        ZanrBrojac zanrBrojac12 = new ZanrBrojac(zanr12);
        ZanrBrojac zanrBrojac13 = new ZanrBrojac(zanr13);
        ZanrBrojac zanrBrojac14 = new ZanrBrojac(zanr14);
        ZanrBrojac zanrBrojac15 = new ZanrBrojac(zanr15);

        StudioBrojac studioBrojac1 = new StudioBrojac(studio1);
        StudioBrojac studioBrojac2 = new StudioBrojac(studio2);
        StudioBrojac studioBrojac3 = new StudioBrojac(studio3);
        StudioBrojac studioBrojac4 = new StudioBrojac(studio4);
        StudioBrojac studioBrojac5 = new StudioBrojac(studio5);
        StudioBrojac studioBrojac6 = new StudioBrojac(studio6);
        StudioBrojac studioBrojac7 = new StudioBrojac(studio7);
        StudioBrojac studioBrojac8 = new StudioBrojac(studio8);
        StudioBrojac studioBrojac9 = new StudioBrojac(studio9);

        kieSession.insert(anime1);
        kieSession.insert(anime2);
        kieSession.insert(anime3);
        kieSession.insert(anime4);
        kieSession.insert(anime5);
        kieSession.insert(anime6);
        kieSession.insert(anime7);
        kieSession.insert(anime8);
        kieSession.insert(anime9);
        kieSession.insert(anime10);
        kieSession.insert(anime11);
        kieSession.insert(anime12);
        kieSession.insert(anime13);
        kieSession.insert(anime14);
        kieSession.insert(anime15);

        kieSession.insert(korisnik);

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

        kieSession.insert(studioBrojac1);
        kieSession.insert(studioBrojac2);
        kieSession.insert(studioBrojac3);
        kieSession.insert(studioBrojac4);
        kieSession.insert(studioBrojac5);
        kieSession.insert(studioBrojac6);
        kieSession.insert(studioBrojac7);
        kieSession.insert(studioBrojac8);
        kieSession.insert(studioBrojac9);


        kieSession.fireAllRules();

        List<Zanr> najgledanijiZanrovi = new ArrayList<>();
        List<Studio> najgledanijiStudiji = new ArrayList<>();


        for (Object obj : kieSession.getObjects(new ClassObjectFilter(Zanr.class))) {
            if (obj instanceof Zanr) {
                najgledanijiZanrovi.add((Zanr) obj);
            }
        }
        for (Object obj : kieSession.getObjects(new ClassObjectFilter(Studio.class))) {
            if (obj instanceof Studio) {
                najgledanijiStudiji.add((Studio) obj);
            }
        }

        System.out.println("Najgledaniji zanrovi: " + najgledanijiZanrovi);
        System.out.println("Najgledaniji studiji: " + najgledanijiStudiji);
//        assert najgledanijiZanrovi.size() == 1;
//        assert najgledanijiStudiji.size() == 1;

        kieSession.dispose();
    }

    @Test
    public void testNegativniFeedbackZaJedanAnime() {
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
    public void testNegativniFeedbackZaCeoAnimeZanr() {
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

    @Test
    public void testForwardChaining() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieBase kieBase = kieContainer.getKieBase("animePreporukaKieBase");

        KieSession kieSession = kieBase.newKieSession();
//        DebugRuleRuntimeEventListener debugListener = new DebugRuleRuntimeEventListener();
//        kieSession.addEventListener(debugListener);

        Anime anime1 = new Anime();
        anime1.setId(1L);
        anime1.setNaziv("Attack on Titan");
        anime1.setStudiji(Arrays.asList(new Studio(1L, "Wit Studio")));
        anime1.setZanrovi(Arrays.asList(new Zanr(1L, "Action")));
        anime1.setSezona("Spring");
        anime1.setGodina("2013");
        anime1.setIzvor("Manga");

        Anime anime2 = new Anime();
        anime2.setId(2L);
        anime2.setNaziv("Death Note");
        anime2.setStudiji(Arrays.asList(new Studio(2L, "Madhouse")));
        anime2.setZanrovi(Arrays.asList(new Zanr(2L, "Psychological"), new Zanr(3L, "Thriller")));
        anime2.setSezona("Fall");
        anime2.setGodina("2006");
        anime2.setIzvor("Manga");

        Anime anime3 = new Anime();
        anime3.setId(3L);
        anime3.setNaziv("One Piece");
        anime3.setStudiji(Arrays.asList(new Studio(3L, "Toei Animation")));
        anime3.setZanrovi(Arrays.asList(new Zanr(4L, "Adventure")));
        anime3.setSezona("Fall");
        anime3.setGodina("1999");
        anime3.setIzvor("Manga");

        Anime anime4 = new Anime();
        anime4.setId(4L);
        anime4.setNaziv("Naruto");
        anime4.setStudiji(Arrays.asList(new Studio(4L, "Studio Pierrot")));
        anime4.setZanrovi(Arrays.asList(new Zanr(1L, "Action")));
        anime4.setSezona("Fall");
        anime4.setGodina("2002");
        anime4.setIzvor("Manga");

        Anime anime5 = new Anime();
        anime5.setId(5L);
        anime5.setNaziv("Demon Slayer: Kimetsu no Yaiba");
        anime5.setStudiji(Arrays.asList(new Studio(5L, "ufotable")));
        anime5.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(6L, "Supernatural")));
        anime5.setSezona("Spring");
        anime5.setGodina("2019");
        anime5.setIzvor("Manga");

        Anime anime6 = new Anime();
        anime6.setId(6L);
        anime6.setNaziv("Fullmetal Alchemist: Brotherhood");
        anime6.setStudiji(Arrays.asList(new Studio(6L, "Bones")));
        anime6.setZanrovi(Arrays.asList(new Zanr(4L, "Adventure"), new Zanr(5L, "Fantasy")));
        anime6.setSezona("Spring");
        anime6.setGodina("2009");
        anime6.setIzvor("Manga");

        Anime anime7 = new Anime();
        anime7.setId(7L);
        anime7.setNaziv("My Hero Academia");
        anime7.setStudiji(Arrays.asList(new Studio(6L, "Bones")));
        anime7.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(13L, "Super Power")));
        anime7.setSezona("Spring");
        anime7.setGodina("2016");
        anime7.setIzvor("Manga");

        Anime anime8 = new Anime();
        anime8.setId(8L);
        anime8.setNaziv("Steins;Gate");
        anime8.setStudiji(Arrays.asList(new Studio(7L, "White Fox")));
        anime8.setZanrovi(Arrays.asList(new Zanr(10L, "Sci-Fi"), new Zanr(3L, "Thriller")));
        anime8.setSezona("Spring");
        anime8.setGodina("2011");
        anime8.setIzvor("Visual Novel");

        Anime anime9 = new Anime();
        anime9.setId(9L);
        anime9.setNaziv("Code Geass: Lelouch of the Rebellion");
        anime9.setStudiji(Arrays.asList(new Studio(8L, "Sunrise")));
        anime9.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(5L, "Fantasy"), new Zanr(14L, "Mecha")));
        anime9.setSezona("Fall");
        anime9.setGodina("2006");
        anime9.setIzvor("Original");

        Anime anime10 = new Anime();
        anime10.setId(10L);
        anime10.setNaziv("Hunter x Hunter (2011)");
        anime10.setStudiji(Arrays.asList(new Studio(2L, "Madhouse")));
        anime10.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(4L, "Adventure")));
        anime10.setSezona("Fall");
        anime10.setGodina("2011");
        anime10.setIzvor("Manga");

        Anime anime11 = new Anime();
        anime11.setId(11L);
        anime11.setNaziv("Your Lie in April");
        anime11.setStudiji(Arrays.asList(new Studio(9L, "A-1 Pictures")));
        anime11.setZanrovi(Arrays.asList(new Zanr(8L, "Drama"), new Zanr(15L, "Music"), new Zanr(9L, "Romance")));
        anime11.setSezona("Fall");
        anime11.setGodina("2014");
        anime11.setIzvor("Manga");

        Anime anime12 = new Anime();
        anime12.setId(12L);
        anime12.setNaziv("One Punch Man");
        anime12.setStudiji(Arrays.asList(new Studio(2L, "Madhouse")));
        anime12.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(13L, "Super Power"), new Zanr(11L, "Comedy")));
        anime12.setSezona("Fall");
        anime12.setGodina("2015");
        anime12.setIzvor("Webcomic");

        Anime anime13 = new Anime();
        anime13.setId(13L);
        anime13.setNaziv("Attack on Titan");
        anime13.setStudiji(Arrays.asList(new Studio(1L, "Wit Studio")));
        anime13.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(5L, "Fantasy")));
        anime13.setSezona("Spring");
        anime13.setGodina("2013");
        anime13.setIzvor("Manga");

        Anime anime14 = new Anime();
        anime14.setId(14L);
        anime14.setNaziv("Death Note");
        anime14.setStudiji(Arrays.asList(new Studio(2L, "Madhouse")));
        anime14.setZanrovi(Arrays.asList(new Zanr(2L, "Psychological"), new Zanr(7L, "Mystery"), new Zanr(6L, "Supernatural")));
        anime14.setSezona("Fall");
        anime14.setGodina("2006");
        anime14.setIzvor("Manga");

        Anime anime15 = new Anime();
        anime15.setId(15L);
        anime15.setNaziv("Naruto");
        anime15.setStudiji(Arrays.asList(new Studio(4L, "Studio Pierrot")));
        anime15.setZanrovi(Arrays.asList(new Zanr(1L, "Action"), new Zanr(4L, "Adventure"), new Zanr(12L, "Shounen")));
        anime15.setSezona("Fall");
        anime15.setGodina("2002");
        anime15.setIzvor("Manga");


        Korisnik korisnik = new Korisnik();
        korisnik.setId(1L);
        korisnik.setEmail("example@example.com");
        korisnik.setKorisniko_ime("example_user");
        korisnik.setLozinka("password");
        korisnik.setTrenutno_gledanje(new ArrayList<>());
        korisnik.setIstorija(new ArrayList<>());
        korisnik.setPlanira_gledanje(new ArrayList<>());
        korisnik.setOdustao_gledanje(new ArrayList<>());
        korisnik.setCrna_lista(new ArrayList<>());

        korisnik.getTrenutno_gledanje().add(anime1);
        korisnik.getTrenutno_gledanje().add(anime14);

        korisnik.getIstorija().add(anime2);
        korisnik.getIstorija().add(anime12);

        korisnik.getPlanira_gledanje().add(anime3);

        korisnik.getOdustao_gledanje().add(anime4);

        korisnik.getCrna_lista().add(anime5);

        Studio studio1 = new Studio(1L, "Wit Studio");
        Studio studio2 = new Studio(2L, "Madhouse");
        Studio studio3 = new Studio(3L, "Toei Animation");
        Studio studio4 = new Studio(4L, "Studio Pierrot");
        Studio studio5 = new Studio(5L, "ufotable");
        Studio studio6 = new Studio(6L, "Bones");
        Studio studio7 = new Studio(7L, "White Fox");
        Studio studio8 = new Studio(8L, "Sunrise");
        Studio studio9 = new Studio(9L, "A-1 Pictures");

        Zanr zanr1 = new Zanr(1L, "Action");
        Zanr zanr2 = new Zanr(2L, "Psychological");
        Zanr zanr3 = new Zanr(3L, "Thriller");
        Zanr zanr4 = new Zanr(4L, "Adventure");
        Zanr zanr5 = new Zanr(5L, "Fantasy");
        Zanr zanr6 = new Zanr(6L, "Supernatural");
        Zanr zanr7 = new Zanr(7L, "Mystery");
        Zanr zanr8 = new Zanr(8L, "Drama");
        Zanr zanr9 = new Zanr(9L, "Romance");
        Zanr zanr10 = new Zanr(10L, "Sci-Fi");
        Zanr zanr11 = new Zanr(11L, "Comedy");
        Zanr zanr12 = new Zanr(12L, "Shounen");
        Zanr zanr13 = new Zanr(13L, "Super Power");
        Zanr zanr14 = new Zanr(14L, "Mecha");
        Zanr zanr15 = new Zanr(15L, "Music");


        ZanrBrojac zanrBrojac1 = new ZanrBrojac(zanr1);
        ZanrBrojac zanrBrojac2 = new ZanrBrojac(zanr2);
        ZanrBrojac zanrBrojac3 = new ZanrBrojac(zanr3);
        ZanrBrojac zanrBrojac4 = new ZanrBrojac(zanr4);
        ZanrBrojac zanrBrojac5 = new ZanrBrojac(zanr5);
        ZanrBrojac zanrBrojac6 = new ZanrBrojac(zanr6);
        ZanrBrojac zanrBrojac7 = new ZanrBrojac(zanr7);
        ZanrBrojac zanrBrojac8 = new ZanrBrojac(zanr8);
        ZanrBrojac zanrBrojac9 = new ZanrBrojac(zanr9);
        ZanrBrojac zanrBrojac10 = new ZanrBrojac(zanr10);
        ZanrBrojac zanrBrojac11 = new ZanrBrojac(zanr11);
        ZanrBrojac zanrBrojac12 = new ZanrBrojac(zanr12);
        ZanrBrojac zanrBrojac13 = new ZanrBrojac(zanr13);
        ZanrBrojac zanrBrojac14 = new ZanrBrojac(zanr14);
        ZanrBrojac zanrBrojac15 = new ZanrBrojac(zanr15);

        StudioBrojac studioBrojac1 = new StudioBrojac(studio1);
        StudioBrojac studioBrojac2 = new StudioBrojac(studio2);
        StudioBrojac studioBrojac3 = new StudioBrojac(studio3);
        StudioBrojac studioBrojac4 = new StudioBrojac(studio4);
        StudioBrojac studioBrojac5 = new StudioBrojac(studio5);
        StudioBrojac studioBrojac6 = new StudioBrojac(studio6);
        StudioBrojac studioBrojac7 = new StudioBrojac(studio7);
        StudioBrojac studioBrojac8 = new StudioBrojac(studio8);
        StudioBrojac studioBrojac9 = new StudioBrojac(studio9);

        List<Anime> collectedAnime = new ArrayList<>();
        kieSession.insert(korisnik);
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

        kieSession.insert(studioBrojac1);
        kieSession.insert(studioBrojac2);
        kieSession.insert(studioBrojac3);
        kieSession.insert(studioBrojac4);
        kieSession.insert(studioBrojac5);
        kieSession.insert(studioBrojac6);
        kieSession.insert(studioBrojac7);
        kieSession.insert(studioBrojac8);
        kieSession.insert(studioBrojac9);

        kieSession.insert(anime1);
        kieSession.insert(anime2);
        kieSession.insert(anime3);
        kieSession.insert(anime4);
        kieSession.insert(anime5);
        kieSession.insert(anime6);
        kieSession.insert(anime7);
        kieSession.insert(anime8);
        kieSession.insert(anime9);
        kieSession.insert(anime10);
        kieSession.insert(anime11);
        kieSession.insert(anime12);
        kieSession.insert(anime13);
        kieSession.insert(anime14);
        kieSession.insert(anime15);

        kieSession.insert(collectedAnime);

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
        System.out.println(finalCollectedAnime);

        kieSession.dispose();
    }
}


