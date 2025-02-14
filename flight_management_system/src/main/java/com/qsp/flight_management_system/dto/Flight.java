package com.qsp.flight_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	private String flightName;
	private String flightNumber;
	private String flightDeparture;
	private String flightArrival;
	private String flightDestination;
	private String flightType;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Pilot> pilots;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Pasanger> pasangers;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Airhostess> airhostesses;

	public List<Airhostess> getAirhostesses() {
		return airhostesses;
	}

	public void setAirhostesses(List<Airhostess> airhostesses) {
		this.airhostesses = airhostesses;
	}

	public List<Pasanger> getPasangers() {
		return pasangers;
	}

	public void setPasangers(List<Pasanger> pasangers) {
		this.pasangers = pasangers;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDeparture() {
		return flightDeparture;
	}

	public void setFlightDeparture(String flightDeparture) {
		this.flightDeparture = flightDeparture;
	}

	public String getFlightArrival() {
		return flightArrival;
	}

	public void setFlightArrival(String flightArrival) {
		this.flightArrival = flightArrival;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

}
