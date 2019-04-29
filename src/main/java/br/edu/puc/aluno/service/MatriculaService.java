package br.edu.puc.aluno.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.puc.aluno.model.Matricula;
import br.edu.puc.aluno.repository.MatriculaRepository;

@Service
public class MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;

	public Boolean trancarMatricula(Long id){
		Optional<Matricula> matriculaOptional = matriculaRepository.findById(id);
		
		if(!matriculaOptional.isPresent()) {
			return false;
		};
		
		Matricula matricula = matriculaOptional.get();
		matricula.setIsAtivo(Boolean.FALSE);
		matriculaRepository.save(matricula);
		
		return true;
	}
}
