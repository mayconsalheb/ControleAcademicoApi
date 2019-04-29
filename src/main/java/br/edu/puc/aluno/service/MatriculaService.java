package br.edu.puc.aluno.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.edu.puc.aluno.model.Matricula;
import br.edu.puc.aluno.model.MatriculaOnline;
import br.edu.puc.aluno.repository.MatriculaOnlineRepository;
import br.edu.puc.aluno.repository.MatriculaRepository;

@Service
public class MatriculaService {
	
	private static final int CPF_LENGTH = 11;
	
	private Logger logger = LoggerFactory.getLogger(MatriculaService.class);

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private MatriculaOnlineRepository matriculaOnlineRepository;

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
	
	public Boolean inserirMatriculaOnline(String cpf, Integer idade, 
			String nome, String email, Integer codigoCurso) {
		
		MatriculaOnline matricula = new MatriculaOnline(cpf, nome, idade, codigoCurso, email);
		if(!isCpfValido(matricula.getCpf())) {
			return false;
		}
		
		matriculaOnlineRepository.save(matricula);
		return true;
	}
	
	private Boolean isCpfValido(String cpf) {
		if (StringUtils.isEmpty(cpf) || cpf.length() != CPF_LENGTH ) {
			logger.info("cpf inválido!");
			return false;
		}
		
		return matriculaOnlineRepository.findByCpf(cpf) == null;
	}
	
}









