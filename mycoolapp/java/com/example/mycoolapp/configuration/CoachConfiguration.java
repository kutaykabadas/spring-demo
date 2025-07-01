package com.example.mycoolapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.mycoolapp.common.Coach;
import com.example.mycoolapp.common.SwimCoach;

@Configuration
public class CoachConfiguration {

	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
