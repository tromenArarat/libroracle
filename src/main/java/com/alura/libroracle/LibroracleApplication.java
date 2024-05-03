package com.alura.libroracle;

import com.alura.libroracle.service.ConsumoAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibroracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibroracleApplication.class, args);

		ConsumoAPI consumoAPI = new ConsumoAPI();
		String json = consumoAPI.obtenerDatos("https://gutendex.com/books/");
		System.out.println(json);
	}


}
