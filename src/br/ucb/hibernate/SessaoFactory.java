package br.ucb.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessaoFactory {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Forma nova de capturar uma sess�o com o BD.
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out.println("Nova forma de configura��o de sess�o com o BD!");
			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {
			try {
				// Forma depreciada para capturar uma sess�o com o BD.
				System.out.println("Antiga forma de configura��o de sess�o com o BD!");
				return new Configuration().configure().buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Falha na inicializa��o de SessionFactory." + ex);
				throw new ExceptionInInitializerError(e);
			}
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}