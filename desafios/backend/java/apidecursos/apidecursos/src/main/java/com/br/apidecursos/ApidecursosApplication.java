package com.br.apidecursos;

import com.br.apidecursos.entity.Curso;
import com.br.apidecursos.enums.Categorias;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ApidecursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApidecursosApplication.class, args);

		//Curso cursoTeste = new Curso(1, "Curso teste", Categorias.BACKEND, true, LocalDateTime.now(), LocalDateTime.now());
		//System.out.println(cursoTeste.toString());
	}

}
