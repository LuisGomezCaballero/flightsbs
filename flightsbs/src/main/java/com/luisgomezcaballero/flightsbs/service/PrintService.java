package com.luisgomezcaballero.flightsbs.service;

import com.luisgomezcaballero.model.SearchParams;
import com.luisgomezcaballero.model.SearchResults;

public interface PrintService {
	
	/**
	 * Prints a detailed message with the found flights
	 * @param searchParams Parameters of the search
	 * @param searchResults Found flights
	 */
	void printFlights(SearchParams searchParams, SearchResults searchResults);

}