package com.ftn.sbnz.tim27.service.servis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftn.sbnz.tim27.model.models.Manga;
import com.ftn.sbnz.tim27.model.models.Zanr;
import com.ftn.sbnz.tim27.model.repos.MangaRepo;
import com.ftn.sbnz.tim27.model.repos.ZanrRepo;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class JikanAPIService {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    @Autowired
    private MangaRepo mangaRepo;
    @Autowired
    private ZanrRepo zanrRepo;

    public JikanAPIService() {
        this.httpClient = HttpClientBuilder.create().build();
        this.objectMapper = new ObjectMapper();
    }

    public void printMangaData() {
        String apiUrl = "https://api.jikan.moe/v4/manga";

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
                    String title = manga.get("title").asText();
                    String synopsis = manga.get("synopsis").asText();
                    List<Zanr> genres = new ArrayList<>();
                    Long id=manga.get("mal_id").asLong();
                    JsonNode genresNode = manga.get("genres");

                    for (JsonNode genre : genresNode) {

                        Long zanrid=genre.get("mal_id").asLong();
                        genres.add(zanrRepo.findZanrById(zanrid));
                    }
                    List<String> authors = new ArrayList<>();
                    JsonNode authorsNode = manga.get("authors");
                    for (JsonNode genre : authorsNode) {
                        String genreName = genre.get("name").asText();
                        authors.add(genreName);
                    }
                    Manga m=new Manga();
                    m.setId(id);
                    m.setNaziv(title);
                    m.setLista_zanrova(genres);
                    m.setAutor(authors.get(0));
                    mangaRepo.save(m);
                    System.out.println("Title: " + title);
                    System.out.println("Synopsis: " + synopsis);
                    System.out.println("Genres: " + genres);
                    System.out.println("Authors: " + authors);
                    System.out.println("----------------------------------");
                }
            }
        } catch (IOException e) {
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
                    String title = manga.get("name").asText();
                    Long id=manga.get("mal_id").asLong();

                    Zanr zanr=new Zanr(id,title);
                    zanrRepo.save(zanr);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}