package com.ucp.gpi.utils;

/**
 * This class represent a counter
 * @author quentin
 * @version 19012017
 *
 */
public class Counter {
	
	protected int counter;
	
	public Counter (int value){
		this.counter = value;
	}

	/**
	 * This method increment the counter
	 */
	public void increment(){
		this.counter++;
	}
	
	/**
	 * This method decrement the counter
	 */
	public void decrement(){
		this.counter--;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public String toString(){
		return String.valueOf(counter);
	}
	
}
