package com.luisgomezcaballero.flightsbs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.luisgomezcaballero.flightsbs.dao.CsvFiles;
import com.luisgomezcaballero.model.Flight;
import com.luisgomezcaballero.model.SearchParams;
import com.luisgomezcaballero.model.SearchResults;

public class FlightsSearchService implements SearchService {

	private static final String PROJECT_PATH = "C:\\Users\\GL553V\\eclipse-workspace\\flightsbs\\src\\main\\resources\\";
	private static final String FLIGHT_PRICES_CSV = "flight-prices.csv";
	private static final String FLIGHT_ROUTES_CSV = "flight-routes.csv";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.luisgomezcaballero.flightsbs.service.SearchService#searchFlights(com.
	 * luisgomezcaballero.model.SearchParams)
	 */
	@Override
	public SearchResults searchFlights(SearchParams searchParams) {

		SearchResults searchResults = new SearchResults();
		
		List<Flight> resultRows = new ArrayList<>();
		Long dateDiff = null;
		Double finalPrice = null;
		Flight resultRow = null;
		Double percentage = null;
		Double temporalflightPrice = null;

		// Load flights' data
		List<List<String>> flightRoutes = CsvFiles.readAllRecords(PROJECT_PATH + FLIGHT_ROUTES_CSV);
		List<List<String>> flightPrices = CsvFiles.readAllRecords(PROJECT_PATH + FLIGHT_PRICES_CSV);

		// Search for flights identifiers
		List<String> flightCodeList = getFlightCodeList(searchParams, flightRoutes);

		dateDiff = getDateDiff(searchParams.getBookingDate(), searchParams.getFlightDate(), TimeUnit.DAYS);
		
		// Search for prices of those flights
		for (List<String> flightPriceRow : flightPrices) {
			for (String flightCode : flightCodeList) {
				if (flightPriceRow.contains(flightCode)) {
					temporalflightPrice = Double.parseDouble(flightPriceRow.get(1));
					if (dateDiff > 30) {
						percentage = 0.8;
					} else if (dateDiff > 15) {
						percentage = 1.0;
					} else if (dateDiff > 2) {
						percentage = 1.2;
					} else {
						percentage = 1.5;
					}
					finalPrice = temporalflightPrice * percentage * searchParams.getNumberOfPassengers();

					// Add to the Result list of flight code + price
					resultRow = new Flight();
					resultRow.setFlightCode(flightCode);
					resultRow.setOriginalFlightPrice(Double.parseDouble(flightPriceRow.get(1)));
					resultRow.setFinalFlightPrice(finalPrice);
					resultRows.add(resultRow);
				}
			}
		}

		searchResults.setResultRows(resultRows);
		searchResults.setDateDiff(dateDiff);
		searchResults.setPercentage(percentage);

		return searchResults;
	}

	private List<String> getFlightCodeList(SearchParams searchParams, List<List<String>> flightRoutes) {
		
		List<String> flightCodeList = new ArrayList<>();
		
		for (List<String> flightRouteRow : flightRoutes) {
			if (flightRouteRow != null && flightRouteRow.get(0) != null && flightRouteRow.get(1) != null
					&& searchParams != null)
				if (flightRouteRow.get(0).equals(searchParams.getOriginAirport())
						&& flightRouteRow.get(1).equals(searchParams.getDestinationAirport())) {
					// Add to the String list of flight codes
					flightCodeList.add(flightRouteRow.get(2));
				}
		}
		return flightCodeList;
	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}
}
