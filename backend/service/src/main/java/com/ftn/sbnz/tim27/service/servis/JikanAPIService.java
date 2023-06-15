package com.ftn.sbnz.tim27.service.servis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftn.sbnz.tim27.model.models.*;
import com.ftn.sbnz.tim27.model.repos.AnimeRepo;
import com.ftn.sbnz.tim27.model.repos.MangaRepo;
import com.ftn.sbnz.tim27.model.repos.StudioRepo;
import com.ftn.sbnz.tim27.model.repos.ZanrRepo;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class JikanAPIService {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    @Autowired
    private MangaRepo mangaRepo;
    @Autowired
    private ZanrRepo zanrRepo;
    @Autowired
    private AnimeRepo animeRepo;
    @Autowired
    private StudioRepo studioRepo;

    @Autowired
    private KorisnikServis korisnikServis;

    public JikanAPIService() {
        this.httpClient = HttpClientBuilder.create().build();
        this.objectMapper = new ObjectMapper();
    }

    public void printMangaData() {
        String apiUrl = "https://api.jikan.moe/v4/manga";

        try {
            for (int i = 1; i < 11; i++) {
                HttpGet request = new HttpGet(apiUrl + "?page=" + i);
                HttpResponse response = httpClient.execute(request);

                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    String responseBody = EntityUtils.toString(response.getEntity());

                    // Parse the JSON response to get the data you need
                    // Adjust the parsing logic based on the API response structure
                    JsonNode jsonNode = objectMapper.readTree(responseBody);
                    JsonNode mangaNode = jsonNode.get("data");
                    for (JsonNode manga : mangaNode) {
                        String title = manga.get("title").asText();
                        String synopsis = manga.get("synopsis").asText();
                        List<Zanr> genres = new ArrayList<>();
                        Long id = manga.get("mal_id").asLong();
                        JsonNode genresNode = manga.get("genres");

                        for (JsonNode genre : genresNode) {
                            String zanrNaziv = genre.get("name").asText();
                            genres.add(zanrRepo.findZanrByNaziv(zanrNaziv));
                        }
                        List<String> authors = new ArrayList<>();
                        JsonNode authorsNode = manga.get("authors");
                        for (JsonNode genre : authorsNode) {
                            String genreName = genre.get("name").asText();
                            authors.add(genreName);
                        }
                        Manga m = new Manga();
                        m.setId(id);
                        m.setNaziv(title);
                        m.setLista_zanrova(genres);
                        m.setAutor(authors.get(0));
                        mangaRepo.save(m);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printGenreData() {
        String apiUrl = "https://api.jikan.moe/v4/genres/manga";

        try {
            HttpGet request = new HttpGet(apiUrl);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String responseBody = EntityUtils.toString(response.getEntity());

                // Parse the JSON response to get the data you need
                // Adjust the parsing logic based on the API response structure
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                JsonNode mangaNode = jsonNode.get("data");
                for (JsonNode manga : mangaNode) {
                    Long id = manga.get("mal_id").asLong();
                    String title = manga.get("name").asText();

                    Zanr zanr = new Zanr();
                    zanr.setNaziv(title);
                    zanr.setM_mal_id(id);
                    zanrRepo.save(zanr);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAnimeData() {
        String apiUrl = "https://api.jikan.moe/v4/anime?sfw";

        try {

            for (int i = 1; i < 11; i++) {


                HttpGet request = new HttpGet(apiUrl + "&page=" + i);
                HttpResponse response = httpClient.execute(request);

                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    String responseBody = EntityUtils.toString(response.getEntity());

                    // Parse the JSON response to get the data you need
                    // Adjust the parsing logic based on the API response structure
                    JsonNode jsonNode = objectMapper.readTree(responseBody);
                    JsonNode mangaNode = jsonNode.get("data");
                    for (JsonNode anime : mangaNode) {
                        String title = anime.get("title").asText();
                        List<Zanr> genres = new ArrayList<>();
                        Long id = anime.get("mal_id").asLong();

                        JsonNode genresNode = anime.get("genres");

                        for (JsonNode genre : genresNode) {
                            String zanrNaziv = genre.get("name").asText();
                            genres.add(zanrRepo.findZanrByNaziv(zanrNaziv));
                        }
                        List<Studio> studios = new ArrayList<>();
                        JsonNode studiosNode = anime.get("studios");
                        for (JsonNode studioNode : studiosNode) {
                            Long studioId = studioNode.get("mal_id").asLong();
                            String studioName = studioNode.get("name").asText();
                            Studio studio = new Studio(studioId, studioName);
                            if (!studioRepo.existsById(studioId)) studioRepo.save(studio);
                            studios.add(studio);
                        }
                        Anime animeObj = new Anime();
                        animeObj.setId(id);
                        animeObj.setNaziv(title);
                        animeObj.setStudiji(studios);
                        animeObj.setZanrovi(genres);
                        animeRepo.save(animeObj);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printAnimeGenreData() {
        String apiUrl = "https://api.jikan.moe/v4/genres/anime";

        try {
            HttpGet request = new HttpGet(apiUrl);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String responseBody = EntityUtils.toString(response.getEntity());

                // Parse the JSON response to get the data you need
                // Adjust the parsing logic based on the API response structure
                JsonNode jsonNode = objectMapper.readTree(responseBody);
                JsonNode mangaNode = jsonNode.get("data");
                for (JsonNode manga : mangaNode) {
                    Long id = manga.get("mal_id").asLong();
                    String title = manga.get("name").asText();


                    Zanr zanr = zanrRepo.findZanrByNaziv(title);
                    if (zanr.getId() == null)
                        zanr.setNaziv(title);
                    zanr.setA_mal_id(id);
                    zanrRepo.save(zanr);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMediaToKorisnikLists() {
        List<Korisnik> korisnici = korisnikServis.pronadjiSveRadnike();
        List<Anime> allAnime = animeRepo.findAll();
        List<Manga> allManga = mangaRepo.findAll();


        for (Korisnik korisnik : korisnici) {
            if (!allAnime.isEmpty()) {

                Random random = new Random();
                List<Anime> list = new ArrayList<>();
                for (int j = 0; j <5; j++) {
                    Anime randomAnime = allAnime.get(random.nextInt(allAnime.size()));
                    list.add(randomAnime);

                }
                korisnik.setTrenutno_gledanje(list);

                list = new ArrayList<>();
                for (int j = 0; j < 15; j++) {
                    Anime randomAnime = allAnime.get(random.nextInt(allAnime.size()));
                    list.add(randomAnime);

                }
                korisnik.setIstorija(list);
                list = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    Anime randomAnime = allAnime.get(random.nextInt(allAnime.size()));
                    list.add(randomAnime);

                }
                korisnik.setPlanira_gledanje(list);
                list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    Anime randomAnime = allAnime.get(random.nextInt(allAnime.size()));
                    list.add(randomAnime);

                }
                korisnik.setOdustao_gledanje(list);
                list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    Anime randomAnime = allAnime.get(random.nextInt(allAnime.size()));
                    list.add(randomAnime);

                }
                korisnik.setCrna_lista(list);

            }

            if (!allManga.isEmpty()) {
                Random random = new Random();
                List<Manga> list = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    Manga randomManga = allManga.get(random.nextInt(allManga.size()));
                    list.add(randomManga);

                }
                korisnik.setTrenutno_citanje(list);

                list = new ArrayList<>();
                for (int j = 0; j < 15; j++) {
                    Manga randomManga = allManga.get(random.nextInt(allManga.size()));
                    list.add(randomManga);

                }
                korisnik.setIstorija2(list);
                list = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    Manga randomManga = allManga.get(random.nextInt(allManga.size()));
                    list.add(randomManga);

                }
                korisnik.setPlanira_citanje(list);
                list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    Manga randomManga = allManga.get(random.nextInt(allManga.size()));
                    list.add(randomManga);

                }
                korisnik.setOdustao_citanje(list);
                list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    Manga randomManga = allManga.get(random.nextInt(allManga.size()));
                    list.add(randomManga);

                }
                korisnik.setCrna_lista2(list);
            }


                korisnikServis.izmeniRadnika(korisnik);
        }
    }

    public void insertUsers() {
        Korisnik korisnik = new Korisnik();
        korisnik.setEmail("i@gmail.com");
        korisnik.setLozinka("123");
        korisnik.setKorisniko_ime("igor");

        korisnikServis.dodajRadnika(korisnik);
        korisnik = new Korisnik();
        korisnik.setEmail("t@gmail.com");
        korisnik.setLozinka("123");
        korisnik.setKorisniko_ime("tea");
        korisnikServis.dodajRadnika(korisnik);
    }

}