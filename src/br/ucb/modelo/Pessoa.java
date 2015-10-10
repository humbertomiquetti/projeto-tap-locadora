package br.ucb.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@Table(name="pessoa")
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pessoa", unique=true, nullable=false)
	private Integer idPessoa;

	@Column(length=100)
	private String email;

	@Column(nullable=false, length=150)
	private String endereco;

	@Column(nullable=false, length=150)
	private String nome;

	@Column(nullable=false, length=15)
	private String telefone;

	//bi-directional many-to-one association to Acesso
//	@OneToMany(mappedBy="pessoa", fetch=FetchType.EAGER)
//	private List<Acesso> acessos;

	//bi-directional many-to-one association to Locacao
//	@OneToMany(mappedBy="pessoa", fetch=FetchType.EAGER)
//	private List<Locacao> locacaos;

	//bi-directional one-to-one association to Pessoafisica
//	@OneToOne(mappedBy="pessoa")
//	private PessoaFisica pessoafisica;

	//bi-directional one-to-one association to Pessoajuridica
//	@OneToOne(mappedBy="pessoa")
//	private PessoaJuridica pessoajuridica;

	public Pessoa() {
	}

	public Integer getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", email=" + email + ", endereco=" + endereco + ", nome=" + nome
				+ ", telefone=" + telefone + "]";
	}

//	public List<Acesso> getAcessos() {
//		return this.acessos;
//	}
//
//	public void setAcessos(List<Acesso> acessos) {
//		this.acessos = acessos;
//	}
//
//	public Acesso addAcesso(Acesso acesso) {
//		getAcessos().add(acesso);
//		acesso.setPessoa(this);
//
//		return acesso;
//	}
//
//	public Acesso removeAcesso(Acesso acesso) {
//		getAcessos().remove(acesso);
//		acesso.setPessoa(null);
//
//		return acesso;
//	}
//
//	public List<Locacao> getLocacaos() {
//		return this.locacaos;
//	}
//
//	public void setLocacaos(List<Locacao> locacaos) {
//		this.locacaos = locacaos;
//	}
//
//	public Locacao addLocacao(Locacao locacao) {
//		getLocacaos().add(locacao);
//		locacao.setPessoa(this);
//
//		return locacao;
//	}
//
//	public Locacao removeLocacao(Locacao locacao) {
//		getLocacaos().remove(locacao);
//		locacao.setPessoa(null);
//
//		return locacao;
//	}
//
//	public PessoaFisica getPessoafisica() {
//		return this.pessoafisica;
//	}
//
//	public void setPessoafisica(PessoaFisica pessoafisica) {
//		this.pessoafisica = pessoafisica;
//	}
//
//	public PessoaJuridica getPessoajuridica() {
//		return this.pessoajuridica;
//	}
//
//	public void setPessoajuridica(PessoaJuridica pessoajuridica) {
//		this.pessoajuridica = pessoajuridica;
//	}
	
	

}