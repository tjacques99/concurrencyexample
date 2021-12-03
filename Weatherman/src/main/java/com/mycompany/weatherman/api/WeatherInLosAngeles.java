package com.mycompany.weatherman.api;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mycompany.concurrency2.services.LosAngelesWeatherService;

import javax.ws.rs.GET;


@RequestScoped
@Path("/losangeles")
@Produces("application/json")
@Consumes("application/json")
public class WeatherInLosAngeles {
	
	@EJB(name="ejb:/concurrency2/LosAngelesWeatherService!com.mycompany.concurrency2.services.LosAngelesWeatherService")
	LosAngelesWeatherService losAngelesWeatherService;
	
	@GET
	public String getWeather() {
		return losAngelesWeatherService.getWeather();
		
	}

}
