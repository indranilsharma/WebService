package com.patients.passengerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.patients.passengerService.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	List<Passenger> passengers = new ArrayList<>();

	int currentId = 1;

	@Override
	public List<Passenger> getPassenger(int start, int size) {
		System.out.println("start :" + start + "size :" + size);
		return passengers;
	}

	/*
	 * @Override public Passenger addPassenger(Passenger passenger) {
	 * 
	 * passenger.setId(currentId++); passengers.add(passenger); return passenger; }
	 */

	@Override
	public void addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) {
		System.out.println("firstName :" + firstName + " ---- " + "lastName :" + lastName);
		System.out.println("agent Name :" + agent);

		// all http header coming like that way
		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		Set<String> keySet = requestHeaders.keySet();
		for (String key : keySet) {
			System.out.println(key);
			System.out.println(headers.getHeaderString(key));
		}

		//cookie value 
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookiekey = cookies.keySet();
		for (String key : cookiekey) {
			System.out.println(".........Mycookie coming----------");
			System.out.println(key);
			System.out.println(cookies.get(key).getValue());
		}
	}

}
