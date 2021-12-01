package com.mycompany.weatherman.api;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.GET;


@RequestScoped
@Path("/newyork")
@Produces("application/json")
@Consumes("application/json")
public class WeatherInNewYork {
	
	@EJB(name="ejb:/concurrency1/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeatherService")
	NewYorkWeatherService newYorkWeatherService;
	
	@GET
	public String getWeather() {
		return newYorkWeatherService.getWeather();
		
	}

}
