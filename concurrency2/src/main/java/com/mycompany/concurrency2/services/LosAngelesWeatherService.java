package com.mycompany.concurrency2.services;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

@Stateless
@Remote(LosAngelesWeatherService.class)
public class LosAngelesWeatherService {
	@Resource
	private SessionContext context;
	
	@Resource
	private ManagedExecutorService service;
	
	public String getWeather() {
		Future<String> future = service.submit(()->{
			Thread.sleep(5000);
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

}

