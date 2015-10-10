package br.ucb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pessoafisica database table.
 * 
 */
@Entity
@Table(name="pessoafisica")
@NamedQuery(name="Pessoafisica.findAll", query="SELECT p FROM Pessoafisica p")
public class PessoaFisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pessoa", unique=true, nullable=false)
	private int idPessoa;

	@Column(length=20)
	private String cnh;

	@Column(nullable=false, length=11)
	private String cpf;

	@Column(length=15)
	private String rg;

	//bi-directional one-to-one association to Pessoa
	@OneToOne
	@JoinColumn(name="id_pessoa", nullable=false, insertable=false, updatable=false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to Pessoajuridica
	@OneToMany(mappedBy="pessoafisica", fetch=FetchType.EAGER)
	private List<PessoaJuridica> pessoajuridicas;

	public PessoaFisica() {
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCnh() {
		return this.cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<PessoaJuridica> getPessoajuridicas() {
		return this.pessoajuridicas;
	}

	public void setPessoajuridicas(List<PessoaJuridica> pessoajuridicas) {
		this.pessoajuridicas = pessoajuridicas;
	}

	public PessoaJuridica addPessoajuridica(PessoaJuridica pessoajuridica) {
		getPessoajuridicas().add(pessoajuridica);
		pessoajuridica.setPessoafisica(this);

		return pessoajuridica;
	}

	public PessoaJuridica removePessoajuridica(PessoaJuridica pessoajuridica) {
		getPessoajuridicas().remove(pessoajuridica);
		pessoajuridica.setPessoafisica(null);

		return pessoajuridica;
	}

}