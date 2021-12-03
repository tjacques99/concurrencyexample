package com.mycompany.concurrency2.services;

import javax.ejb.Remote;

@Remote
public interface LosAngelesWeather {
	String getWeather();
}
