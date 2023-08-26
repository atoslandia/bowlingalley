package com.projectdb.controller;

import com.projectdb.db.Storage;
import com.projectdb.error.CustomerNotFoundException;
import com.projectdb.error.LaneNotFoundException;
import com.projectdb.model.Customer;
import com.projectdb.model.Lane;
import jakarta.persistence.EntityManager;

public class BowlingController {

	private EntityManager entityManager;

	public BowlingController() {
		this.entityManager = Storage.getInstance().getEntityManager();
	}

	public void rentLane(Customer customer, Lane lane)
		throws CustomerNotFoundException, LaneNotFoundException {
		customer = entityManager.find(Customer.class, customer.getCpf());
		lane = entityManager.find(Lane.class, lane.getNumber());

		if (lane == null) {
			throw new LaneNotFoundException();
		}

		if (customer == null) {
			throw new CustomerNotFoundException();
		}

		if (lane.isAvailable()) {
			lane.setAvailable(false);

			lane.setLaneRenter(customer);

			modifyLane(lane);
		}
	}

	public void turnLaneAvailable(Lane lane) throws LaneNotFoundException {
		lane = entityManager.find(Lane.class, lane.getNumber());
		if (lane == null) {
			throw new LaneNotFoundException();
		}
		lane.setAvailable(true);

		modifyLane(lane);
	}

	private void modifyLane(Lane lane) {
		entityManager.getTransaction().begin();
		entityManager.merge(lane);
		entityManager.getTransaction().commit();
	}
}
