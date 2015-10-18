package br.ucb.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;

import br.ucb.hibernate.GenericWorker;
import br.ucb.modelo.Pessoa;

@SuppressWarnings("serial")
@ManagedBean(name = "listaTudoPessoaBean")
@RequestScoped
public class PessoaListaTudoBean implements Serializable {
	private List<Pessoa> listagem;
	private AcessoBean acessoBean;

	@SuppressWarnings("deprecation")
	public PessoaListaTudoBean() {
		listagem = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		listarTudo();
	}

	public String listarTudo() {
		try {
				GenericWorker<Pessoa, Integer> regHBR = new GenericWorker<Pessoa, Integer>(Pessoa.class);
				listagem = regHBR.listar(new Criterion[0]);
				regHBR.finalize();
			} catch (HibernateException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "ERRO!",
						"Falha na consulta aos dados."));
				e.printStackTrace();
			}
			return "sucesso";
	}

	public List<Pessoa> getListagem() {
		return listagem;
	}

	public void setListagem(List<Pessoa> listagem) {
		this.listagem = listagem;
	}
}