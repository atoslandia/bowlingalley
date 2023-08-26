package com.projectdb.model;

import com.projectdb.db.Storage;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class RentalDAO {

	private Storage storage;

	public RentalDAO() {
		this.storage = Storage.getInstance();
	}

	public void addRental(Rental newRental) {
		storage.saveOrUpdate(() ->
			storage.getEntityManager().persist(newRental)
		);
	}

	public List<Rental> getAllRental() {
		TypedQuery<Rental> query = storage
			.getEntityManager()
			.createQuery("SELECT r FROM Rental r", Rental.class);
		return query.getResultList();
	}
}
