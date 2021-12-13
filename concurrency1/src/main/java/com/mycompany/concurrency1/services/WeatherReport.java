package com.mycompany.concurrency1.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherReport {
	
	public final String currentConditionText;

	public WeatherReport() {
		this.currentConditionText = "No weather report";
	}
	
	public WeatherReport(@JsonProperty("current.condition.text") String currentConditionText) {
		this.currentConditionText = currentConditionText;
	}

	@Override
	public String toString() {
		return "WeatherReport [currentConditionText=" + currentConditionText + "]";
	}
	
	
}
