package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String template = "Greetings, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		// initial newCounter
		long newCounter = 0;
		// add a counter the gets the value and adds 1 to it
		newCounter = counter.getAndIncrement();

		// if statement to see if value is odd or even and displays only odd numbers
		if (newCounter % 2 == 0 && newCounter != 1) {
			newCounter++;
			System.out.println("newCounter was 0: " + newCounter);
			String templateWithName = String.format(template, name);
			Greeting greetingObject = new Greeting(newCounter, templateWithName);
			return greetingObject;
		} else if (newCounter == 1 || newCounter % 2 != 0) {
			newCounter = counter.getAndIncrement() + 1;
			System.out.println("newCounter is odd: " + newCounter);
			String templateWithName = String.format(template, name);
			Greeting greetingObject1 = new Greeting(newCounter, templateWithName);
			return greetingObject1;

		}
		return null;
	}
//the bug was the way atomicLong works and the bug was * instead of an if or while statement  
//then the two get() and incermentAndGet() caused it to add 2 every time starting at 0 
//I could have left it because it just worked but i didn't understand it so i wrote the if statement
//ill be honest not sure why that happens i thought get() just got a value
}
