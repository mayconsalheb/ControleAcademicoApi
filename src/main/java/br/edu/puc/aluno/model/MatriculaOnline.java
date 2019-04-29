package br.edu.puc.aluno.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_MATRICULA_ONLINE")
public class MatriculaOnline extends MatriculaAbstract{

	private static final long serialVersionUID = -100453641899042682L;
	
	public MatriculaOnline() {}
	
	public MatriculaOnline(String cpf, String nome, Integer idade, Integer codigoCurso, String email) {
		super(cpf, nome, idade, codigoCurso, email);
	}
}
