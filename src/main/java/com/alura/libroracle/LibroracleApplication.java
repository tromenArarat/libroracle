package com.alura.libroracle;

import com.alura.libroracle.principal.Principal;
import com.alura.libroracle.repository.AutorRepository;
import com.alura.libroracle.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibroracleApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository repository;

	@Autowired
	private AutorRepository repository2;

	public static void main(String[] args) {
		SpringApplication.run(LibroracleApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository, repository2);
		principal.muestraElMenu();

	}


}
