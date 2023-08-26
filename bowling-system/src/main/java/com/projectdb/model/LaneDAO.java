package com.projectdb.model;

import com.projectdb.db.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class LaneDAO {

	private EntityManager entityManager;

	public LaneDAO() {
		this.entityManager = Storage.getInstance().getEntityManager();
	}

	public Lane getLane(Lane lane) {
		return entityManager.find(Lane.class, lane.getNumber());
	}

	public void addLane(Lane newLane) {
		entityManager.persist(newLane);
	}

	public void updateLane(Lane lane) {
		entityManager.merge(lane);
	}

	public List<Lane> getLanesAvailable() {
		TypedQuery<Lane> query = entityManager.createQuery(
			"SELECT l FROM Lane l WHERE available = true",
			Lane.class
		);
		return query.getResultList();
	}

	public List<Lane> getAllLanes() {
		TypedQuery<Lane> query = entityManager.createQuery("SELECT l FROM Lane l", Lane.class);
		return query.getResultList();
	}
}
