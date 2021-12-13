package com.mycompany.concurrency1.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

@Stateless
@Remote(NewYorkWeather.class)
public class NewYorkWeatherService implements NewYorkWeather {
	
	@Resource
	private SessionContext context;
	
	@Resource
	private ManagedExecutorService service;
	
	@Override
	public String getWeather() {
		Future<String> future = service.submit(()->{
			//Thread.sleep(5000);
			return "Snowing";
		});
		
		String weather = "";
		try {
			weather = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return weather;
	}
	
	private void executeHttpRequestOnWeatherAPI() {
	HttpClient client = HttpClient.newHttpClient();
	
	 HttpRequest request = HttpRequest.newBuilder(
			 URI.create("http://api.weatherapi.com/v1/current.json?key=89b9857f4bab4782b47190955211312&q=10001&aqi=no"))
	   .header("accept", "application/json")
	   .build();
}
 

}

