package com.mycompany.weatherservice;

import javax.ejb.EJB;

import com.mycompany.concurrency1.services.NewYorkWeatherService;
import com.mycompany.concurrency2.services.LosAngelesWeatherService;

public class WeatherService {
	@EJB(name="ejb:/concurrency2/LosAngelesWeatherService!com.mycompany.concurrency2.services.LosAngelesWeatherService")
	LosAngelesWeatherService losAngelesWeatherService;
	
	@EJB(name="ejb:/concurrency1/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeatherService")
	NewYorkWeatherService newYorkWeatherService;

	public String getLosAngelesWeather() {
//		return "Sunny";
		return losAngelesWeatherService.getWeather();
	}
	
	public String getNewYorkWeather() {
		return newYorkWeatherService.getWeather();
		
//		return "Snowing";
		
	}
}
