package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Aluno;

@Repository

public interface AlunoRepositorio extends JpaRepository<Aluno, Integer> {

	
	
	
}
