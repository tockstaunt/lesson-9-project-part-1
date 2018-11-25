package com.example.demo;

public class Greeting {

	private long newCounter;
	private String templateWithName;

	public Greeting(long newCounter, String templateWithName) {
		this.newCounter = newCounter;
		this.templateWithName = templateWithName;

	}

	public long getNewCounter() {
		return newCounter;
	}

	public void setNewCounter(long newCounter) {
		this.newCounter = newCounter;
	}

	public String getTemplateWithName() {
		return templateWithName;
	}

	public void setTemplateWithName(String templateWithName) {
		this.templateWithName = templateWithName;
	}

}
