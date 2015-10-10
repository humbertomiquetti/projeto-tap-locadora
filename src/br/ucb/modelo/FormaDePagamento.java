package br.ucb.modelo;

public enum FormaDePagamento {
	DINHEIRO("Dinheiro"), 
	CARTAODEBITO("Cart�o de D�bito"),
	CARTAOCREDITO("Cart�o de Cr�dito"),
	CHEQUE("Cheque");

	private final String formaDePagamento;

	private FormaDePagamento(String formaDePagamento) {

		this.formaDePagamento = formaDePagamento;

	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

}