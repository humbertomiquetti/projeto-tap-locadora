package br.ucb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veiculo database table.
 * 
 */
@Entity
@Table(name="veiculo")
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_veiculo", unique=true, nullable=false)
	private int idVeiculo;

	@Column(name="ano_fab", nullable=false, length=5)
	private String anoFab;

	@Column(name="ano_mod", nullable=false, length=5)
	private String anoMod;

	@Column(nullable=false, length=15)
	private String cor;

	@Column(nullable=false, length=200)
	private String descricao;

	@Column(nullable=false, length=45)
	private String marca;

	@Column(name="qtd_lugares", nullable=false)
	private int qtdLugares;

	//bi-directional many-to-one association to Locacao
	@OneToMany(mappedBy="veiculo", fetch=FetchType.EAGER)
	private List<Locacao> locacaos;

	public Veiculo() {
	}

	public int getIdVeiculo() {
		return this.idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getAnoFab() {
		return this.anoFab;
	}

	public void setAnoFab(String anoFab) {
		this.anoFab = anoFab;
	}

	public String getAnoMod() {
		return this.anoMod;
	}

	public void setAnoMod(String anoMod) {
		this.anoMod = anoMod;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQtdLugares() {
		return this.qtdLugares;
	}

	public void setQtdLugares(int qtdLugares) {
		this.qtdLugares = qtdLugares;
	}

	public List<Locacao> getLocacaos() {
		return this.locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	public Locacao addLocacao(Locacao locacao) {
		getLocacaos().add(locacao);
		locacao.setVeiculo(this);

		return locacao;
	}

	public Locacao removeLocacao(Locacao locacao) {
		getLocacaos().remove(locacao);
		locacao.setVeiculo(null);

		return locacao;
	}

}