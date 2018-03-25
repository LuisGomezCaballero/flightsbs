package com.luisgomezcaballero.flightsbs.dao;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.io.UncheckedIOException;
import java.util.List;

import org.junit.Test;

public class ReadFlightsTest {
	private static final String PROJECT_PATH = "C:\\Users\\GL553V\\eclipse-workspace\\flightsbs\\src\\main\\resources\\";
	private static final String FLIGHT_PRICES_CSV = "flight-prices.csv";
	private static final String FLIGHT_ROUTES_CSV = "flight-routes.csv";
	private static final String UNEXISTING_PATH = "a1b2c3d4";
	private final int flightCount = 89;

	@Test
	public void readFlightPrices() {
		List<List<String>> prices = CsvFiles.readAllRecords(PROJECT_PATH + FLIGHT_PRICES_CSV);

		allFlightsRead(prices);
		startsWith(prices, asList("IB2818", "186"));
		endsWith(prices, asList("LH7260", "191"));
	}
	@Test(expected = UncheckedIOException.class)
	public void readFlightPricesFileException() {
		CsvFiles.readAllRecords(UNEXISTING_PATH + FLIGHT_PRICES_CSV);
	}

	@Test
	public void readFlightRoutes() {
		List<List<String>> routes = CsvFiles.readAllRecords(PROJECT_PATH + FLIGHT_ROUTES_CSV);

		allFlightsRead(routes);
		startsWith(routes, asList("CPH", "FRA", "IB2818"));
		endsWith(routes, asList("MAD", "AMS", "LH7260"));
	}

	private void allFlightsRead(List<List<String>> flights) {
		assertEquals(flightCount, flights.size());
	}

	private void startsWith(List<List<String>> actual, List<String> expected) {
		assertEquals(expected, actual.get(0));
	}

	private void endsWith(List<List<String>> actual, List<String> expected) {
		assertEquals(expected, actual.get(actual.size() - 1));
	}
}
