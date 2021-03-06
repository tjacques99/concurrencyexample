package com.mycompany.concurrency2.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;


@Stateless
@Remote(LosAngelesWeather.class)
public class LosAngelesWeatherService implements LosAngelesWeather {
	@Resource
	private SessionContext context;
	
	@Resource
	private ManagedExecutorService service;
	
	@Override
	public String getWeather() {
		Future<String> future = service.submit(()->{
			String weatherReport = executeHttpRequestOnWeatherAPI();
			return weatherReport;
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
	
	private String executeHttpRequestOnWeatherAPI() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		
		 HttpRequest request = HttpRequest.newBuilder(
				 URI.create("http://api.weatherapi.com/v1/current.json?key=89b9857f4bab4782b47190955211312&q=90001&aqi=no"))
		   .header("accept", "application/json")
		   .build();
		 
		 HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		 ObjectMapper objectMapper = new ObjectMapper();
		 JsonNode jsonNode = objectMapper.readTree(response.body());
//		 String weatherSummary = jsonNode.get("current").get("condition").get("text").asText();

		 return jsonNode.toPrettyString();
	}
}

