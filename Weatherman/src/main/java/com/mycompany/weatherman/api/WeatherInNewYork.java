package com.mycompany.weatherman.api;

import java.util.Hashtable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mycompany.concurrency1.services.NewYorkWeather;
import com.mycompany.concurrency2.services.LosAngelesWeather;

import javax.ws.rs.GET;


@RequestScoped
@Path("/newyork")
@Produces("application/json")
@Consumes("application/json")
public class WeatherInNewYork {
	
	//@EJB(name=" ejb:weatherserviceear/com.mycompany-weatherman-0.0.1-SNAPSHOT/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeather")
	NewYorkWeather newYorkWeather;
	
	@GET
	public String getWeather() {
	try {
		newYorkWeather = lookupNewYorkWeather();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return newYorkWeather.getWeather();
//		return "Snowing";
		
	}
	
	private static NewYorkWeather lookupNewYorkWeather() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		
		return (NewYorkWeather) context.lookup("java:global/concurrency1/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeather");
		//return (NewYorkWeather) context.lookup("java:global/weatherserviceear/com.mycompany-weatherman-0.0.1-SNAPSHOT/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeather");
	}

}
