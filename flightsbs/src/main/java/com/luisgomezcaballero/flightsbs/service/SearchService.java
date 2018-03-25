package com.luisgomezcaballero.flightsbs.service;

import com.luisgomezcaballero.model.SearchParams;
import com.luisgomezcaballero.model.SearchResults;

public interface SearchService {

	/**
	 * Search for the flight using the given parameters
	 * @param searchParams Parameters of the search
	 * @return Found flights
	 */
	SearchResults searchFlights(SearchParams searchParams);

}