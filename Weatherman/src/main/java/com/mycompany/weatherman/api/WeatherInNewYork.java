package com.mycompany.weatherman.api;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mycompany.concurrency1.services.NewYorkWeather;

import javax.ws.rs.GET;


@RequestScoped
@Path("/newyork")
@Produces("application/json")
@Consumes("application/json")
public class WeatherInNewYork {
	
	private static final String jndiGlobalString = "java:global/concurrency1/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeather";
	private static final String jndiEjbString = "ejb:/weatherman/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeather";
	
	@EJB(name=jndiEjbString)
	NewYorkWeather newYorkWeather;
	
	@GET
	public String getWeather() throws InterruptedException, ExecutionException, IOException, NamingException {

		//newYorkWeather = lookupNewYorkWeather();
		return newYorkWeather.getWeather();

	}
	
	private static NewYorkWeather lookupNewYorkWeather() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		
		return (NewYorkWeather) context.lookup(jndiGlobalString);
		//return (NewYorkWeather) context.lookup("java:global/weatherserviceear/com.mycompany-weatherman-0.0.1-SNAPSHOT/NewYorkWeatherService!com.mycompany.concurrency1.services.NewYorkWeather");
	}

}
