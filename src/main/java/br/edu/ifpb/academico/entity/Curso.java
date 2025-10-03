package br.edu.ifpb.academico.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "TB_CURSO")
public class Curso implements Serializable{

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "O nome do curso é obrigatório")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "O código do curso é obrigatória")
	@Column(unique = true, nullable = false)
	private String codigo;
	
	private String descricao;
	
	//@NotBlank(message = "A data de nascimento do aluno é obrigatória")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Criacao", nullable = false)
	private Date dataCriacao;

	// muitos cursos para um campus
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			optional = false)
	private Campus campus;

	//um curso tem muitas disciplinas
	@OneToMany(
			fetch = FetchType.LAZY,
			mappedBy = "curso")
	private List<Disciplina> disciplinas;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
}
