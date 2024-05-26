package com.cammac.primeiraAulaSemWeb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cammac.primeiraAulaSemWeb.model.DadosEpisodio;
import com.cammac.primeiraAulaSemWeb.model.DadosSerie;
import com.cammac.primeiraAulaSemWeb.service.ConsumoApi;
import com.cammac.primeiraAulaSemWeb.service.ConverteDados;

@SpringBootApplication
public class PrimeiraAulaSemWebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiraAulaSemWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Vamos la Tatanka rumo ao topo!!!");
		
		var consumoApi = new ConsumoApi();
		
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");

		System.out.println(json);
//		
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		
//		System.out.println(json);
		
		ConverteDados converteDados = new ConverteDados();
		DadosSerie serie = converteDados.obterDados(json, DadosSerie.class);
		
		System.out.println(serie);
		
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		
		DadosEpisodio dadosEpisodio = converteDados.obterDados(json, DadosEpisodio.class);
		
		System.out.println(dadosEpisodio);
		
		
		
		
		
	}

}
