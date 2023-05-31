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

        ArrayList<Manga> crnaLista = korisnik.getCrna_lista2();
        System.out.println(crnaLista);
        assert crnaLista.size() == 2;
        assert crnaLista.contains(manga);
        assert crnaLista.contains(relatedmanga2);

        kieSession.dispose();
    }

}
