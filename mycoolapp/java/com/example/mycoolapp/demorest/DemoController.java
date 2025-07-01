package com.example.mycoolapp.demorest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycoolapp.common.Coach;

@RestController
public class DemoController {
	private Coach iCoach;

	/**
	 * Constructor Injection
	 * Auto Wired is optional
	 */
	// public DemoController(@Qualifier("cricketCoach") ICoach iCoach) {
	// this.iCoach = iCoach;
	// }

	@Autowired
	public DemoController(@Qualifier("swimCoach") Coach iCoach) {
		this.iCoach = iCoach;
	}

	/**
	 * Setter Injection
	 */
//	@Autowired
//	public void setICoach(@Qualifier("swimCoach") ICoach iCoach) {
//		this.iCoach = iCoach;
//	}

	@GetMapping("/dailyworkout")
	public String greetPerson() {
		return iCoach.getDailyWorkout();
	}
}
