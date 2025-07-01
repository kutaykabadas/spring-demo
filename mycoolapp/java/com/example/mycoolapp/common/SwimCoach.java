package com.example.mycoolapp.common;

public class SwimCoach implements Coach {
	public SwimCoach() {

	}
	
	/**
	 * Can create beans of a third-party class.
	 * Such as AWS classes where you cannot access source code.
	 */
	@Override
	public String getDailyWorkout() {
		return "SwimCoach.getDailyWorkout()";
	}
}
