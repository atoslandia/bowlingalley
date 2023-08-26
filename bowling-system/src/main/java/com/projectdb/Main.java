package com.projectdb;

import com.projectdb.model.Customer;
import com.projectdb.model.CustomerDAO;
import com.projectdb.model.Employee;
import com.projectdb.model.EmployeeDAO;
import com.projectdb.model.Lane;
import com.projectdb.model.LaneDAO;
import com.projectdb.model.Rental;
import com.projectdb.model.RentalDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// DAO instancies
		EmployeeDAO employeeDAO = new EmployeeDAO();
		LaneDAO laneDAO = new LaneDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		RentalDAO rentalDAO = new RentalDAO();

		// employees
		Employee marllon = new Employee(
			11111111112L,
			"marllon",
			Employee.Role.TECHNICIAN
		);
		Employee oliver = new Employee(
			11111111113L,
			"oliver",
			Employee.Role.CLEANING_CREW
		);
		Employee joaoVito = new Employee(
			11111111114L,
			"joaoVito",
			Employee.Role.SERVER
		);

		employeeDAO.addEmployee(marllon);
		employeeDAO.addEmployee(oliver);
		employeeDAO.addEmployee(joaoVito);

		// lanes
		Lane pista1 = new Lane();
		Lane pista2 = new Lane();
		Lane pista3 = new Lane();

		laneDAO.addLane(pista1);
		laneDAO.addLane(pista2);
		laneDAO.addLane(pista3);

		// customers
		Customer atos = new Customer(11111111111L, "atos");
		Customer ivan = new Customer(22222222222L, "ivan");
		Customer robson = new Customer(33333333333L, "robson");

		customerDAO.addCustomer(atos);
		customerDAO.addCustomer(ivan);
		customerDAO.addCustomer(robson);

		// rentals
		Rental rental1 = new Rental(
			robson,
			pista3,
			LocalDateTime.of(2023, 7, 23, 20, 30)
		);
		Rental rental2 = new Rental(
			ivan,
			pista2,
			LocalDateTime.of(2025, 1, 1, 23, 00)
		);

		laneDAO.updateLane(pista3);
		laneDAO.updateLane(pista2);

		rentalDAO.addRental(rental1);
		rentalDAO.addRental(rental2);

		// find all and querys
		ArrayList<Customer> customers =
			(ArrayList<Customer>) customerDAO.getAllCustomers();
		customers.forEach(usuario ->
			System.out.println("Usuários: " + usuario)
		);

		ArrayList<Lane> lanes =
			(ArrayList<Lane>) laneDAO.getAllLanes();
		lanes.forEach(lane -> System.out.println("Pistas: " + lane));

		System.out.println("Pistas disponíveis: ");
		ArrayList<Lane> lanesAvailable =
			(ArrayList<Lane>) laneDAO.getLanesAvailable();
		lanesAvailable.forEach(lane -> System.out.println(lane));

		System.out.println("Alugueis: ");
		ArrayList<Rental> rentals =
			(ArrayList<Rental>) rentalDAO.getAllRental();
		rentals.forEach(rental -> System.out.println(rental));
	}
}
