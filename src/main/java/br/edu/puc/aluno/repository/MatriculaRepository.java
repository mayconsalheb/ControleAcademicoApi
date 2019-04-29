package br.edu.puc.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.puc.aluno.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>{

}
