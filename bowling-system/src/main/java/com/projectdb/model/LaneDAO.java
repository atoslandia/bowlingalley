package com.projectdb.model;

import com.projectdb.db.Storage;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class LaneDAO {

	private Storage storage;

	public LaneDAO() {
		this.storage = Storage.getInstance();
	}

	public Lane getLane(Lane lane) {
		return storage
			.getEntityManager()
			.find(Lane.class, lane.getNumber());
	}

	public void addLane(Lane newLane) {
		storage.saveOrUpdate(() ->
			storage.getEntityManager().persist(newLane)
		);
	}

	public void updateLane(Lane lane) {
		storage.saveOrUpdate(() ->
			storage.getEntityManager().merge(lane)
		);
	}

	public List<Lane> getLanesAvailable() {
		TypedQuery<Lane> query = storage
			.getEntityManager()
			.createQuery(
				"SELECT l FROM Lane l WHERE available = true",
				Lane.class
			);
		return query.getResultList();
	}

	public List<Lane> getAllLanes() {
		TypedQuery<Lane> query = storage
			.getEntityManager()
			.createQuery("SELECT l FROM Lane l", Lane.class);
		return query.getResultList();
	}
}
