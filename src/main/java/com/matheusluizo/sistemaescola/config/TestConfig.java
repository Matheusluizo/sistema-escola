package com.matheusluizo.sistemaescola.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusluizo.sistemaescola.entities.Professor;
import com.matheusluizo.sistemaescola.entities.Turma;
import com.matheusluizo.sistemaescola.repositories.ProfessorRepository;
import com.matheusluizo.sistemaescola.repositories.TurmaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private TurmaRepository turmaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Professor p1 = new Professor(null, "06447707162", "9999999", "20/04/1999", "Matheus", "TotalVille", "mestrado", "Geografia");
		Professor p2 = new Professor(null, "05455255998", "9888888", "12/07/1989", "Rodrigo", "TotalVille2", "odontorado", "Matematica");
		Professor p3 = new Professor(null, "04855511236", "9877777", "30/08/1975", "Luiz", "TotalVille3", "mestrado", "Historia");
		
		Turma t1 = new Turma(null, "8ºA", "44 Alunos");
		Turma t2 = new Turma(null, "8ºB", "52 Alunos");
		Turma t3 = new Turma(null, "8ºC", "36 Alunos");
		
		professorRepository.saveAll(Arrays.asList(p1,p2));
		turmaRepository.saveAll(Arrays.asList(t1,t2,t3)); 
		
		p1.getTurmas().add(t1);
		p2.getTurmas().add(t3);
		p1.getTurmas().add(t2);
		p2.getTurmas().add(t1);
		p3.getTurmas().add(t3);
		
		professorRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
