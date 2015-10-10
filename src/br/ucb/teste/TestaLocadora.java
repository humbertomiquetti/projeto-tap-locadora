package br.ucb.teste;

import javax.swing.JOptionPane;

import br.ucb.hibernate.GenericWorker;
import br.ucb.modelo.Pessoa;

public class TestaLocadora {

	public static void main(String[] args) {
		// primeiro voce cria uma marca, e depois insere ela no carro
		Pessoa pessoaPOJO = new Pessoa();
		pessoaPOJO.setIdPessoa(1);
		pessoaPOJO.setNome("Valter");
		pessoaPOJO.setEndereco("Rua 1");
		pessoaPOJO.setEmail("valtercec@gmail.com");
		pessoaPOJO.setTelefone("06181513419");

		GenericWorker<Pessoa, Integer> DAO_i_pessoa = new GenericWorker<Pessoa, Integer>(Pessoa.class);
		if (DAO_i_pessoa.inclui(pessoaPOJO))
			JOptionPane.showMessageDialog(null, "Pessoa inserida com sucesso: \n" + pessoaPOJO);
		DAO_i_pessoa.finalize();

	}

}
