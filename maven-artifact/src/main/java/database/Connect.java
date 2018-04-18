package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import klienci.Klient;

public class Connect {
	EntityManagerFactory emf;
	EntityManager em;

	public void createEMF() {
		emf = Persistence.createEntityManagerFactory("myDatabase");

	}

	public void createEM() {
		em = emf.createEntityManager();

	}

	public void close() {
		em.close();

	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
