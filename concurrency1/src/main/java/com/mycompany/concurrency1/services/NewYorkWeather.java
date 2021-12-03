package com.mycompany.concurrency1.services;

import javax.ejb.Remote;

@Remote
public interface NewYorkWeather {
	String getWeather();
}
