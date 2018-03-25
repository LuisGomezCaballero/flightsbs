package com.luisgomezcaballero.model;

import java.util.List;

public class SearchResults {
	private List<Flight> resultRows;
	private Long dateDiff;
	private Double percentage;

	public SearchResults() {
		super();
	}

	public List<Flight> getResultRows() {
		return resultRows;
	}

	public void setResultRows(List<Flight> resultRows) {
		this.resultRows = resultRows;
	}

	public Long getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(Long dateDiff) {
		this.dateDiff = dateDiff;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

}
