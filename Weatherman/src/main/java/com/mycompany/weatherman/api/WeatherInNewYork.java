package com.mycompany.weatherman.api;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//import com.mycompany.concurrency1.services.NewYorkWeather;
//import com.mycompany.concurrency1.services.NewYorkWeatherService;

import javax.ws.rs.GET;


@RequestScoped
@Path("/newyork")
@Produces("application/json")
@Consumes("application/json")
public class WeatherInNewYork {
	
//	@EJB(name="ejb:/concurrency1/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeatherService")
//	NewYorkWeatherService newYorkWeatherService;
	
	@GET
	public String getWeather() {
//		//		try {
//		NewYorkWeather exampleBean = (NewYorkWeather) InitialContext.lookup("java:module/NewYorkWeatherService");
//	} catch (NamingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return newYorkWeather.getWeather();
		return "Snowing";
		
	}

}
