package com.projectdb.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class Storage {

	private static Storage instance;

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
		"bowlinglane"
	);
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	private Storage() {}

	public static synchronized Storage getInstance() {
		if (instance == null) {
			instance = new Storage();
		}
		return instance;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
