package com.mycompany.weatherman.api;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//import com.mycompany.concurrency2.services.LosAngelesWeather;
//import com.mycompany.concurrency2.services.LosAngelesWeatherService;

import javax.ws.rs.GET;


@RequestScoped
@Path("/losangeles")
@Produces("application/json")
@Consumes("application/json")
public class WeatherInLosAngeles {
	
//	//@EJB(name="java:global:/concurrency2/LosAngelesWeatherService!com.mycompany.concurrency2.services.LosAngelesWeatherService")
//	@EJB("java:global/LosAngelesWeatherService")
//	LosAngelesWeather losAngelesWeather;
	
	@GET
	public String getWeather() {
//		try {
//			LosAngelesWeather exampleBean = (LosAngelesWeather) InitialContext.lookup("java:module/LosAngelesWeatherService");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return losAngelesWeather.getWeather();
		
		return "Sunny";
		
	}

}
