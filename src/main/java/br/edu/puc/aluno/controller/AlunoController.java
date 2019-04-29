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

	@PostMapping("/matricula")
	public String inserirMatriculaOnline() {
		return "matricula realizada";
	}
	
	@PostMapping("/trancarMatricula")
	public Boolean trancarMatricula(@RequestParam Long id) {
		return matriculaService.trancarMatricula(id);
	}
}
