package com.projectdb.model;

import com.projectdb.db.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CustomerDAO {

	private EntityManager entityManager;

	public CustomerDAO() {
		this.entityManager = Storage.getInstance().getEntityManager();
	}

	public Customer getCustomer(Customer customer) {
		return entityManager.find(Customer.class, customer.getCpf());
	}

	public void addCustomer(Customer newCustomer) {
		entityManager.getTransaction().begin();
		entityManager.persist(newCustomer);
		entityManager.getTransaction().commit();
	}

	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query = entityManager.createQuery(
			"SELECT c FROM Customer c",
			Customer.class
		);
		return query.getResultList();
	}
}
