package br.ucb.modelo;

public enum FormaDePagamento {
	DINHEIRO("Dinheiro"), 
	CARTAODEBITO("Cartão de Débito"),
	CARTAOCREDITO("Cartão de Crédito"),
	CHEQUE("Cheque");

	private final String formaDePagamento;

	private FormaDePagamento(String formaDePagamento) {

		this.formaDePagamento = formaDePagamento;

	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

}