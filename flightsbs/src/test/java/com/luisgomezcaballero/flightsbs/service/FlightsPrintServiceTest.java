package com.luisgomezcaballero.flightsbs.service;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.luisgomezcaballero.model.SearchParams;
import com.luisgomezcaballero.model.SearchResults;

public class FlightsPrintServiceTest {

	private static final Date TODAY = new Date();
	private static final String FRA = "FRA";
	private static final String AMS = "AMS";
	@Test
	public void printFlightsTest() {

		SearchParams searchParams = null;
		SearchResults searchResults = new SearchResults();
		SearchService searchService = new FlightsSearchService();
		PrintService printService = new FlightsPrintService();

		searchParams = new SearchParams();
		searchParams.setOriginAirport(AMS);
		searchParams.setDestinationAirport(FRA);
		searchParams.setBookingDate(TODAY);
		searchParams.setFlightDate(calculateFlightDateInXdays(31));
		searchParams.setNumberOfPassengers((short) 1);

		searchResults = searchService.searchFlights(searchParams);
		printService.printFlights(searchParams, searchResults);
	}

	private Date calculateFlightDateInXdays(int amoutOfDaysToSum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(TODAY);
		calendar.add(Calendar.DATE, ++amoutOfDaysToSum);
		return calendar.getTime();
	}
}
