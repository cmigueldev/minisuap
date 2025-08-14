package br.edu.ifpb.academico.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_ALUNO")
public class Aluno implements Serializable {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	@NotBlank(message = "O nome do aluno é obrigatório")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "A matrícula do aluno é obrigatória")
	@Column(unique = true, nullable = false)
	private String matricula;
	
	//@NotBlank(message = "A data de nascimento do aluno é obrigatória")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nascimento", nullable = false)
	private Date dataNascimento;
	
	private Double CRE;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Double getCRE() {
		return CRE;
	}
	public void setCRE(Double cRE) {
		CRE = cRE;
	}
	
	

}