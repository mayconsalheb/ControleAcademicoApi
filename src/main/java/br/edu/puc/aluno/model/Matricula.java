package br.edu.puc.aluno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_MATRICULA")
public class Matricula extends MatriculaAbstract{
	
	private static final long serialVersionUID = -6337556674458293308L;
	
	@Column(name="st_ativo")
	private boolean isAtivo;

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

}
