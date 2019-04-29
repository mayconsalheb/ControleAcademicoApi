package br.edu.puc.aluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.puc.aluno.service.MatriculaService;

@RestController
@RequestMapping(value="aluno")
public class AlunoController {
	
	@Autowired
	private MatriculaService matriculaService;

	@PostMapping("/inserirMatriculaOnline")
	public Boolean inserirMatriculaOnline(@RequestParam String cpf, @RequestParam  String nome, 
			@RequestParam  Integer idade, @RequestParam String email, @RequestParam  Integer codigoCurso) {
		
		return matriculaService.inserirMatriculaOnline(cpf, idade, nome, email, codigoCurso);
	}
	
	@PostMapping("/trancarMatricula")
	public Boolean trancarMatricula(@RequestParam Long id) {
		return matriculaService.trancarMatricula(id);
	}
}
