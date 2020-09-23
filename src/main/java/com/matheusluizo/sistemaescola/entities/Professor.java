package com.matheusluizo.sistemaescola.entities;

public class Professor {
	private Integer cpf;
	private Integer telefone;
	private Integer data;
	private String nome;
	private String endereço;
	private String formacao;
	private String especializacao;
	
	public Professor(){		
	}

	public Professor(Integer cpf, Integer telefone, Integer data, String nome, String endereço, String formacao,
			String especializacao) {
		super();
		this.cpf = cpf;
		this.telefone = telefone;
		this.data = data;
		this.nome = nome;
		this.endereço = endereço;
		this.formacao = formacao;
		this.especializacao = especializacao;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	
}
