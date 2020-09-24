package com.matheusluizo.sistemaescola.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_turma")
public class Turma  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tAno;
	private String quantidade;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "turmas")
	private Set<Professor> professores = new HashSet<>();
	
	public Turma () {
	}

	public Turma(Long id, String tAno, String quantidade) {
		super();
		this.id = id;
		this.tAno = tAno;
		this.quantidade = quantidade;
	}

	public String gettAno() {
		return tAno;
	}

	public void settAno(String tAno) {
		this.tAno = tAno;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}
	
	public Set<Professor> getProfessores() {
		return professores;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
