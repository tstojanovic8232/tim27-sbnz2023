package com.ftn.sbnz.tim27.service;

import com.ftn.sbnz.tim27.service.servis.JikanAPIService;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@EntityScan(basePackages = {"com.ftn.sbnz.tim27.model.*","com.ftn.sbnz.tim27.service.*"})
@ComponentScan(basePackages = {"com.ftn.sbnz.tim27.model.models","com.ftn.sbnz.tim27.service.servis","com.ftn.sbnz.tim27.model.repos","com.ftn.sbnz.tim27.service.controller"})
@EnableJpaRepositories("com.ftn.sbnz.tim27.model.repos")
public class ServiceApplication {
	private final JikanAPIService jikanAPIService;

	@Autowired
	public ServiceApplication(JikanAPIService jikanAPIService) {
		this.jikanAPIService = jikanAPIService;
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@PostConstruct
	public void printMangaData() {
        jikanAPIService.insertUsers();
		jikanAPIService.printGenreData();
		jikanAPIService.printAnimeGenreData();
		jikanAPIService.printMangaData();
		jikanAPIService.printAnimeData();

        jikanAPIService.addMediaToKorisnikLists();



	}


	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks
				.newKieContainer(ks.newReleaseId("com.ftn.sbnz.tim27", "kjar", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(1000);
		return kContainer;
	}
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
