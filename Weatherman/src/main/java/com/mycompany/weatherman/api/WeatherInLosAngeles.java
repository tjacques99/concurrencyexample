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
