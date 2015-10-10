package br.ucb.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.exception.ConstraintViolationException;

public class GenericWorker<T, ID extends Serializable> implements
		InterfaceWorker<T, ID> {
	private Session session;
	public Class<T> entidade;
	private boolean isOpenSession = false;

	public GenericWorker(Class<T> entidade) {
		try{
		//Utiliza Gerenciamento de contexto de sess�o com o SGBD. 
		//Melhor que openSession. 
		//Depende de configura��o no hibernate.cfg.xml
		session = SessaoFactory.getSessionFactory().getCurrentSession();
		isOpenSession = false;
		//System.out.println("Sess�o capturada com getCurrentSession!");
		}catch(HibernateException e){
			isOpenSession = true;
			session = SessaoFactory.getSessionFactory().openSession();
			//System.out.println("Sess�o capturada com openSession!");
		}
		this.entidade = entidade;
	}

	@Override
	public void finalize()  {
		//N�o executa com getCurrentSession porque 
		// j� liberou a session ap�s o commit.
		if ((session != null)&&(isOpenSession)) {
			session.flush();
			session.clear();
			session.close();
		}
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public boolean inclui(T registro) throws HibernateException,
			ConstraintViolationException {

		Transaction tx = session.beginTransaction();
		try {
			session.save(registro);
			tx.commit();
		} catch (ConstraintViolationException e) {
			if (tx != null)
				tx.rollback();
			throw new ConstraintViolationException(
					"Falha de inclus�o: Objeto j� existe.", null,
					"Registro duplicado.");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new HibernateException("Falha de inclus�o no BD: ", e);
		} finally {
			//deixa para fechar a conex�o via m�todo finalize.
			//session.close();
		}
		return true;
	}

	public boolean exclui(T registro) throws HibernateException,
			ObjectNotFoundException {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(registro);
			tx.commit();
		} catch (ObjectNotFoundException e) {
			if (tx != null)
				tx.rollback();
			throw new ObjectNotFoundException(
					"Falha de consulta: Objeto n�o localizado.",
					"ERRO! Objeto n�o localizado");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new HibernateException("Falha de exclus�o no BD: ", e);
		} finally {
			//deixa para fechar a conex�o via m�todo finalize.
			//session.close();
		}
		return true;
	}

	public boolean altera(T registro) throws HibernateException,
			ObjectNotFoundException {
		Transaction tx = session.beginTransaction();
		try {
			session.update(registro);
			tx.commit();
		} catch (StaleStateException e) {
			if (tx != null)
				tx.rollback();
			throw new ObjectNotFoundException(
					"Falha de consulta: Objeto n�o localizado ",
					"ERRO! Objeto n�o localizado");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new HibernateException("Falha de altera��o no BD: ", e);
		} finally {
			//deixa para fechar a conex�o via m�todo finalize.
			//session.close();
		}
		return true;
	}

	public Object consulta(ID id) throws HibernateException,
			ObjectNotFoundException {
		Object registro;
		Transaction tx = session.beginTransaction();
		try {
			registro = session.get(entidade, id);
			tx.commit();
		} catch (ObjectNotFoundException e) {
			if (tx != null)
				tx.rollback();
			throw new ObjectNotFoundException(
					"Falha de consulta: Objeto n�o localizado ",
					"ERRO! Objeto n�o localizado");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new HibernateException("Falha de consulta no BD: ", e);
		} finally {
			//deixa para fechar a conex�o via m�todo finalize.
			//session.close();
		}
		return registro;
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(int inicio, int quantia) throws HibernateException {
		List<T> listagem;
		Transaction tx = session.beginTransaction();
		try {
			listagem = session.createCriteria(entidade).setMaxResults(quantia)
					.setFirstResult(inicio).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new HibernateException("Falha de consulta no BD: ", e);
		} finally {
			//deixa para fechar a conex�o via m�todo finalize.
			//session.close();
		}
		return listagem;
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(Criterion clausula[]) throws HibernateException {
		List<T> listagem;
		Transaction tx = session.beginTransaction();
		try {
			switch (clausula.length) {
			case 1:
				listagem = session.createCriteria(this.entidade)
						.add(clausula[0]).list();
				break;
			case 2:
				listagem = session.createCriteria(this.entidade)
						.add(clausula[0]).add(clausula[1]).list();
				break;
			case 3:
				listagem = session.createCriteria(this.entidade)
						.add(clausula[0]).add(clausula[1]).add(clausula[2])
						.list();
				break;
			case 4:
				listagem = session.createCriteria(this.entidade)
						.add(clausula[0]).add(clausula[1]).add(clausula[2])
						.add(clausula[3]).list();
				break;
			case 5:
				listagem = session.createCriteria(this.entidade)
						.add(clausula[0]).add(clausula[1]).add(clausula[2])
						.add(clausula[3]).add(clausula[4]).list();
				break;
			default:
				listagem = session.createCriteria(this.entidade).list();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new HibernateException("Falha de consulta no BD: ", e);
		} finally {
			//deixa para fechar a conex�o via m�todo finalize.
			//session.close();
		}
		return listagem;
	}
}
