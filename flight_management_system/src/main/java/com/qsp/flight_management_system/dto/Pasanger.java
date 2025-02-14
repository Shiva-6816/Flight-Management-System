package com.qsp.flight_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pasanger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pasangerId;
	private String pasangerName;
	private String pasangerEmail;
	private String pasangerGender;
	private int pasangerAge;
	private long pasangerPhone;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;

	@OneToOne(cascade = CascadeType.ALL)
	private Seat seat;

	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Food> foods;

	
	
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPasangerId() {
		return pasangerId;
	}

	public void setPasangerId(int pasangerId) {
		this.pasangerId = pasangerId;
	}

	public String getPasangerName() {
		return pasangerName;
	}

	public void setPasangerName(String pasangerName) {
		this.pasangerName = pasangerName;
	}

	public String getPasangerEmail() {
		return pasangerEmail;
	}

	public void setPasangerEmail(String pasangerEmail) {
		this.pasangerEmail = pasangerEmail;
	}

	public String getPasangerGender() {
		return pasangerGender;
	}

	public void setPasangerGender(String pasangerGender) {
		this.pasangerGender = pasangerGender;
	}

	public int getPasangerAge() {
		return pasangerAge;
	}

	public void setPasangerAge(int pasangerAge) {
		this.pasangerAge = pasangerAge;
	}

	public long getPasangerPhone() {
		return pasangerPhone;
	}

	public void setPasangerPhone(long pasangerPhone) {
		this.pasangerPhone = pasangerPhone;
	}

}
