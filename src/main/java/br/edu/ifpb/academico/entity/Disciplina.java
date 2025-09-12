package br.edu.ifpb.academico.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_DISCIPLINA")
public class Disciplina implements Serializable{
	
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "O nome da disciplina é obrigatório")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "o código da disciplina é obrigatória")
	@Column(unique = true, nullable = false)
	private String codigo;
			
	//@NotBlank(message = "A carga horária da disciplina é obrigatória")
	@Column(nullable = false)
	private int cargaHoraria;
	
	@NotBlank(message = "A ementa da disciplina é obrigatória")
	@Column(nullable = false)
	private String ementa;
	
	private String creditos;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public String getCreditos() {
		return creditos;
	}
	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}
	
	
	

}
