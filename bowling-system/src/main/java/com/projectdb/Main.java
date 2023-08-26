package com.projectdb;

import com.projectdb.db.Storage;
import com.projectdb.error.CustomerNotFoundException;
import com.projectdb.error.LaneNotFoundException;
import com.projectdb.model.Customer;
import com.projectdb.model.CustomerDAO;
import com.projectdb.model.Employee;
import com.projectdb.model.EmployeeDAO;
import com.projectdb.model.Lane;
import com.projectdb.model.LaneDAO;
import com.projectdb.model.Rental;
import com.projectdb.model.RentalDAO;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws CustomerNotFoundException, LaneNotFoundException {
		// for database transactions
		Storage.getInstance().getEntityManager().getTransaction().begin();

		// employees
		Employee marllon = new Employee(11111111112L, "marllon", Employee.Role.TECHNICIAN);
		Employee oliver = new Employee(11111111113L, "oliver", Employee.Role.CLEANING_CREW);
		Employee joaoVito = new Employee(11111111114L, "joaoVito", Employee.Role.SERVER);

		EmployeeDAO employeeDAO = new EmployeeDAO();

		employeeDAO.addEmployee(marllon);
		employeeDAO.addEmployee(oliver);
		employeeDAO.addEmployee(joaoVito);

		// lanes
		Lane pista1 = new Lane();
		Lane pista2 = new Lane();
		Lane pista3 = new Lane();

		LaneDAO laneDAO = new LaneDAO();

		laneDAO.addLane(pista1);
		laneDAO.addLane(pista2);
		laneDAO.addLane(pista3);

		// customers
		Customer atos = new Customer(11111111111L, "atos");
		Customer ivan = new Customer(22222222222L, "ivan");
		Customer robson = new Customer(33333333333L, "robson");

		CustomerDAO customerDAO = new CustomerDAO();

		customerDAO.addCustomer(atos);
		customerDAO.addCustomer(ivan);
		customerDAO.addCustomer(robson);

		// rentals
		Rental rental1 = new Rental(robson, pista3);
		Rental rental2 = new Rental(robson, pista3);

		RentalDAO rentalDAO = new RentalDAO();

		rentalDAO.addRental(rental1);
		rentalDAO.addRental(rental2);

		rentalDAO.finishRental(rental1);

		// completed transactions
		Storage.getInstance().getEntityManager().getTransaction().commit();

		ArrayList<Customer> customers = (ArrayList<Customer>) customerDAO.getAllCustomers();
		customers.forEach(usuario -> System.out.println("Usuários: " + usuario));

		ArrayList<Lane> lanes = (ArrayList<Lane>) laneDAO.getAllLanes();
		lanes.forEach(lane -> System.out.println("Pistas: " + lane));

		System.out.println("Pistas disponíveis: ");
		ArrayList<Lane> lanesAvailable = (ArrayList<Lane>) laneDAO.getLanesAvailable();
		lanesAvailable.forEach(lane -> System.out.println(lane));

		System.out.println("Alugueis: ");
		ArrayList<Rental> rentals = (ArrayList<Rental>) rentalDAO.getAllRental();
		rentals.forEach(rental -> System.out.println(rental));
	}
}
