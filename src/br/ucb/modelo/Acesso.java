package br.ucb.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acesso database table.
 * 
 */
@Entity
@Table(name="acesso")
@NamedQuery(name="Acesso.findAll", query="SELECT a FROM Acesso a")
public class Acesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=100)
	private String email;

	@Column(nullable=false, length=8)
	private String senha;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="fk_id_pessoa", nullable=false)
	private Pessoa pessoa;

	public Acesso() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}