package com.luisgomezcaballero.flightsbs.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.luisgomezcaballero.model.SearchParams;
import com.luisgomezcaballero.model.SearchResults;

public class FlightsSearchServiceTest {

	private static final Date TODAY = new Date();
	private static final String CDG = "CDG";
	private static final String MAD = "MAD";
	private static final String BCN = "BCN";
	private static final String IST = "IST";
	private static final String LHR = "LHR";
	private static final String FRA = "FRA";
	private static final String AMS = "AMS";

	@Test
	public void searchFlightsTest() {

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

		assertNotNull(searchResults);
		assertEquals(3, searchResults.getResultRows().size());

		searchParams = new SearchParams();
		searchParams.setOriginAirport(LHR);
		searchParams.setDestinationAirport(IST);
		searchParams.setBookingDate(TODAY);
		searchParams.setFlightDate(calculateFlightDateInXdays(15));
		searchParams.setNumberOfPassengers((short) 3);

		searchResults = searchService.searchFlights(searchParams);
		printService.printFlights(searchParams, searchResults);

		assertNotNull(searchResults);
		assertEquals(2, searchResults.getResultRows().size());

		searchParams = new SearchParams();
		searchParams.setOriginAirport(BCN);
		searchParams.setDestinationAirport(MAD);
		searchParams.setBookingDate(TODAY);
		searchParams.setFlightDate(calculateFlightDateInXdays(2));
		searchParams.setNumberOfPassengers((short) 2);

		searchResults = searchService.searchFlights(searchParams);
		printService.printFlights(searchParams, searchResults);

		assertNotNull(searchResults);
		assertEquals(2, searchResults.getResultRows().size());

		searchParams = new SearchParams();
		searchParams.setOriginAirport(CDG);
		searchParams.setDestinationAirport(FRA);
		searchParams.setBookingDate(TODAY);
		searchParams.setFlightDate(calculateFlightDateInXdays(30));
		searchParams.setNumberOfPassengers((short) 1);

		searchResults = searchService.searchFlights(searchParams);
		printService.printFlights(searchParams, searchResults);

		assertNotNull(searchResults);
		assertEquals(0, searchResults.getResultRows().size());
	}

	private Date calculateFlightDateInXdays(int amoutOfDaysToSum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(TODAY);
		calendar.add(Calendar.DATE, ++amoutOfDaysToSum);
		return calendar.getTime();
	}

}
