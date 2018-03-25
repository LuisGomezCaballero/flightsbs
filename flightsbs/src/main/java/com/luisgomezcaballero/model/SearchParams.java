package com.luisgomezcaballero.model;

import java.util.Date;

public class SearchParams {

	private String originAirport;
	private String destinationAirport;
	private Date flightDate;
	private Date bookingDate;
	private Short numberOfPassengers;

	public SearchParams() {
		super();
	}

	public String getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Short getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(Short numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

}
