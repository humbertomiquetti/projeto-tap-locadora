package br.ucb.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pessoajuridica database table.
 * 
 */
@Entity
@Table(name="pessoajuridica")
@NamedQuery(name="Pessoajuridica.findAll", query="SELECT p FROM Pessoajuridica p")
public class PessoaJuridica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pessoa", unique=true, nullable=false)
	private int idPessoa;

	@Column(nullable=false, length=14)
	private String cnpj;

	@Column(length=45)
	private String ie;

	//bi-directional one-to-one association to Pessoa
	@OneToOne
	@JoinColumn(name="id_pessoa", nullable=false, insertable=false, updatable=false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to Pessoafisica
	@ManyToOne
	@JoinColumn(name="motorista_id_pessoa", nullable=false)
	private PessoaFisica pessoafisica;

	public PessoaJuridica() {
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return this.ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaFisica getPessoafisica() {
		return this.pessoafisica;
	}

	public void setPessoafisica(PessoaFisica pessoafisica) {
		this.pessoafisica = pessoafisica;
	}

}