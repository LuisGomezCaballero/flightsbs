package com.luisgomezcaballero.flightsbs.service;

import com.luisgomezcaballero.model.Flight;
import com.luisgomezcaballero.model.SearchParams;
import com.luisgomezcaballero.model.SearchResults;

public class FlightsPrintService implements PrintService {

	/* (non-Javadoc)
	 * @see com.luisgomezcaballero.flightsbs.service.PrintService#printFlights(com.luisgomezcaballero.model.SearchParams, com.luisgomezcaballero.model.SearchResults)
	 */
	@Override
	public void printFlights(SearchParams searchParams, SearchResults searchResults) {
		
		System.out.println("* " + searchParams.getNumberOfPassengers() + " passengers, " + searchResults.getDateDiff()
				+ " days to the departure date, flying " + searchParams.getOriginAirport() + " -> "
				+ searchParams.getDestinationAirport());
		if (searchResults.getResultRows().size() > 0) {
			System.out.println("  flights:");
			for (Flight row : searchResults.getResultRows()) {
				System.out.println("    * " + row.getFlightCode() + ", " + row.getFinalFlightPrice() + " € ("
						+ searchParams.getNumberOfPassengers() + " * (" + searchResults.getPercentage() * 100 + "% of "
						+ row.getOriginalFlightPrice() + "))");
			}
		} else {
			System.out.println("    no flights available");
		}
		System.out.println();
	}
}
