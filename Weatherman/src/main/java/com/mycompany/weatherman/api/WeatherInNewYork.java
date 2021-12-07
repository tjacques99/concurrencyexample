package com.mycompany.weatherman.api;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mycompany.weatherservice.WeatherService;

import javax.ws.rs.GET;


@RequestScoped
@Path("/newyork")
@Produces("application/json")
@Consumes("application/json")
public class WeatherInNewYork {
	
WeatherService weatherService = new WeatherService();
	
	
	@GET
	public String getWeather() {
//		return "Sunny";
		return weatherService.getNewYorkWeather();
		
	}

}
