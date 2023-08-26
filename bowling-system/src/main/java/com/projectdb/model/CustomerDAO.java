package com.projectdb.model;

import com.projectdb.db.Storage;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CustomerDAO {

	private Storage storage;

	public CustomerDAO() {
		this.storage = Storage.getInstance();
	}

	public Customer getCustomer(Customer customer) {
		return storage
			.getEntityManager()
			.find(Customer.class, customer.getCpf());
	}

	public void addCustomer(Customer newCustomer) {
		storage.saveOrUpdate(() ->
			storage.getEntityManager().persist(newCustomer)
		);
	}

	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query = storage
			.getEntityManager()
			.createQuery("SELECT c FROM Customer c", Customer.class);
		return query.getResultList();
	}
}
