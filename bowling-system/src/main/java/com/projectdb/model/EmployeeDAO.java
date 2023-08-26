package com.projectdb.model;

import com.projectdb.db.Storage;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAO {

	private Storage storage;

	public EmployeeDAO() {
		this.storage = Storage.getInstance();
	}

	public void addEmployee(Employee newEmployee) {
		storage.saveOrUpdate(() ->
			storage.getEntityManager().persist(newEmployee)
		);
	}

	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> query = storage
			.getEntityManager()
			.createQuery("SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}
}
