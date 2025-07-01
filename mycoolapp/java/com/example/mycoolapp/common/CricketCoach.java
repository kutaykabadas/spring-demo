package com.example.mycoolapp.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("CricketCoach.CricketCoach()");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("CricketCoach.postConstruct()");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("CricketCoach.preDestroy()");
	}
	
	@Override
	public String getDailyWorkout() {
		return "CricketCoach.getDailyWorkout()";
	}

}
