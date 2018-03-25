package com.luisgomezcaballero.model;

public class Flight {

	private String flightCode;
	private Double originalFlightPrice;
	private Double finalFlightPrice;

	public Flight() {
		super();
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Double getOriginalFlightPrice() {
		return originalFlightPrice;
	}

	public void setOriginalFlightPrice(Double originalFlightPrice) {
		this.originalFlightPrice = originalFlightPrice;
	}

	public Double getFinalFlightPrice() {
		return finalFlightPrice;
	}

	public void setFinalFlightPrice(Double finalFlightPrice) {
		this.finalFlightPrice = finalFlightPrice;
	}

}
