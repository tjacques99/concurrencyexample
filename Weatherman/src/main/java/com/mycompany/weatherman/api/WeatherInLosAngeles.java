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

import com.mycompany.concurrency2.services.LosAngelesWeather;

import javax.ws.rs.GET;


@RequestScoped
@Path("/losangeles")
@Produces("application/json")
@Consumes("application/json")
public class WeatherInLosAngeles {
	
	private static final String jndiGlobalString = "java:global/concurrency2/LosAngelesWeatherService!com.mycompany.concurrency2.services.LosAngelesWeather";
	private static final String jndiEjbString = "ejb:/weatherman/LosAngelesWeatherService!com.mycompany.concurrency2.services.LosAngelesWeather";
	
	@EJB(name=jndiEjbString)
	LosAngelesWeather losAngelesWeather;
	
	@GET
	public String getWeather() {
		
		//losAngelesWeather = lookupLosAngelesWeather();
		return losAngelesWeather.getWeather();
	}
	
	private static LosAngelesWeather lookupLosAngelesWeather() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		
		return (LosAngelesWeather) context.lookup(jndiGlobalString);
		//return (LosAngelesWeather) context.lookup("java:global/weatherserviceear/com.mycompany-weatherman-0.0.1-SNAPSHOT/LosAngelesWeatherService!com.mycompany.concurrency2.services.LosAngelesWeather");
	}

}
