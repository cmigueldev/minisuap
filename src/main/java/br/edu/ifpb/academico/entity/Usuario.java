package br.edu.ifpb.academico.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O nome do usuario é obrigatória")
	@Column(nullable = false)
    private String nome;

    @NotBlank(message = "A matrícula do usuario é obrigatória")
	@Column(unique = true, nullable = false)
    private String matricula;

    @NotBlank(message = "O login do usuario é obrigatório")
	@Column(unique = true, nullable = false)
    private String login;

    @NotBlank(message = "A senha do usuario é obrigatória")
	@Column(nullable = false)
    private String senha;

    @NotNull(message = "A data de nascimento do usuario é obrigatória")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nascimento", nullable = false)
    private Date dataNascimento;

    @NotBlank(message = "O e-mail do usuario é obrigatório")
	@Column(unique = true, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "tb_user_role",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private List<Role> Role;

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRole() {
        return Role;
    }

    public void setRole(List<Role> role) {
        Role = role;
    }

    

}
