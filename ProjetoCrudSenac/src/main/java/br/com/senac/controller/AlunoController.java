package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Aluno;
import br.com.senac.service.AlunoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping ("aluno")
public class AlunoController {

	
	@Autowired
	private AlunoService alunoService;
	
	// rota para o metodo
	@GetMapping("/listarAlunos")
	public ModelAndView listaTodosAlunos() {
		
		// vai para uma pagina HTML
		ModelAndView mv = new ModelAndView("aluno/listarAlunos");
		
		//manda para o mv o resultado do metodo para listar os alunos
		mv.addObject("alunos", alunoService.buscarTodosAlunos());

		
		return mv;
		
	}
	
	//criar uma rota para chamar a tela de cadastro
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAlunos(){
		
		
		ModelAndView mv = new ModelAndView("aluno/cadastrarAlunos");
		
		mv.addObject("alunos", new Aluno());
		return mv;
		
		
		
	}
	//criar uma rota para incluir aluno
	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		alunoService.salvar(aluno);
		
		return listaTodosAlunos();
		
	}
	
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAluno(@PathVariable("id") Integer idAluno) throws ObjectNotFoundException{
			
			ModelAndView mv = new ModelAndView("aluno/alterarAluno");
		
			mv.addObject("alunos", alunoService.buscarPorId(idAluno));
			return mv;
	}
	
	
	@PostMapping("/alterar")
	public ModelAndView salvarAlunoAlteracao(Aluno aluno) throws ObjectNotFoundException {
		alunoService.salvarAlunoAlteracao(aluno);
		
		return listaTodosAlunos();
		
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirAluno(@PathVariable("id") Integer idAluno) throws ObjectNotFoundException{
			
			alunoService.excluir(idAluno);
			return listaTodosAlunos();
	}
	
	
	
}
