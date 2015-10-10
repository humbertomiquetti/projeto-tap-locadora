package br.ucb.managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

import br.ucb.hibernate.GenericWorker;
import br.ucb.modelo.Pessoa;

@SuppressWarnings("serial")
@ManagedBean(name="pessoaBean")
@RequestScoped
public class PessoaBean implements Serializable {

	private Pessoa registro;
	
	
	@SuppressWarnings("deprecation")
	public PessoaBean() {
		registro = new Pessoa();
		FacesContext fc = FacesContext.getCurrentInstance();
	}
	
	public String incluir(){
		try{
			GenericWorker<Pessoa, Integer> regHBR = new GenericWorker<Pessoa, Integer>(Pessoa.class);
			if (regHBR.inclui(registro)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "Registro incluido com sucesso."));
			}
			regHBR.finalize();
			
		}catch(ConstraintViolationException e){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO!",	"Chave primária já existe. Registro duplicado."));
			e.printStackTrace();
		} catch (HibernateException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO!", "Falha na inclusão dos dados."));
			e.printStackTrace();
		}
		return "sucesso";
	}

	public Pessoa getRegistro() {
		return registro;
	}

	public void setRegistro(Pessoa registro) {
		this.registro = registro;
	} 
	
	
}
