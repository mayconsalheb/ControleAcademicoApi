package br.edu.puc.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.puc.aluno.model.MatriculaOnline;

public interface MatriculaOnlineRepository extends JpaRepository<MatriculaOnline, Long>{

	MatriculaOnline findByCpf(String cpf);

}
