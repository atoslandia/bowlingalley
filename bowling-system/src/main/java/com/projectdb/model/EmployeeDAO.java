package com.projectdb.model;

import com.projectdb.db.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAO() {
		this.entityManager = Storage.getInstance().getEntityManager();
	}

	public void addEmployee(Employee newEmployee) {
		entityManager.getTransaction().begin();
		entityManager.persist(newEmployee);
		entityManager.getTransaction().commit();
	}

	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> query = entityManager.createQuery(
			"SELECT e FROM Employee e",
			Employee.class
		);
		return query.getResultList();
	}
}
