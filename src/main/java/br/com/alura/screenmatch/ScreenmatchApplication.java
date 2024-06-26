package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=c525653d"); //Obtenção dos dados da série e atribuição para a variável json
//		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json); //Impressão de verificação para confirmar que o dados vieram corretamente
		ConverteDados conversor = new ConverteDados(); //Instanciamento do método conversor
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class); //Aqui é feito a tranformação dos dados para Dados Série
		System.out.println(dados); //Impressão dos Dados da Série desejados
	}
}
