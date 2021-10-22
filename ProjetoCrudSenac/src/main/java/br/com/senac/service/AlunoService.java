package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Aluno;
import br.com.senac.repositorio.AlunoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AlunoService {
	
	
	@Autowired
	AlunoRepositorio repo;
	
	public Aluno salvar (Aluno aluno) {
		
		return repo.save(aluno);
	}
	
	
	public List<Aluno> buscarTodosAlunos(){
		
		return repo.findAll();
	}

	public Aluno buscarPorId (Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = repo.findById(id);
		
		return aluno.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado: " +id ));
		
		
		
	}
	
	public Aluno salvarAlunoAlteracao(Aluno alunoAlterado)throws ObjectNotFoundException  {
		
		Aluno alunoAtual = buscarPorId(alunoAlterado.getId());
		alunoAtual.setNome(alunoAlterado.getNome());
		return salvar(alunoAtual);
	}
	
	
	public void excluir(Integer id) {
		repo.deleteById(id);
		
	}
	
	
	
	
	
	
}


