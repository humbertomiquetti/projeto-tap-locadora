package br.ucb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the locacao database table.
 * 
 */
@Entity
@Table(name="locacao")
@NamedQuery(name="Locacao.findAll", query="SELECT l FROM Locacao l")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_locacao", unique=true, nullable=false)
	private int idLocacao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_final", nullable=false)
	private Date dataFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicial", nullable=false)
	private Date dataInicial;

	@Column(nullable=false, length=145)
	private String descricao;

	@Column(name="forma_pagamento", nullable=false, length=30)
	private String formaPagamento;

	@Column(nullable=false, precision=10)
	private BigDecimal valor;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="fk_id_pessoa", nullable=false)
	private Pessoa pessoa;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="fk_id_veiculo", nullable=false)
	private Veiculo veiculo;

	public Locacao() {
	}

	public int getIdLocacao() {
		return this.idLocacao;
	}

	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Date getDataFinal() {
		return this.dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicial() {
		return this.dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}