package com.ucp.gpi.utils;

/**
 * This class represent a Cyclic Counter
 * @author quentin
 * @version 19012017
 */
public class CyclicCounter extends BoundedCounter{

	public CyclicCounter(int value, int min, int max) {
		super(value, min, max);
	}
	
	/**
	 * This method increment the Cyclic Counter
	 */
	public void increment(){
		if(counter == max)
			this.counter = min;
		else
			this.counter++;
	}
	
	/**
	 * this methode make a multiple incrementation in the Cyclic Counter
	 */
	public void increment(int nb){
		for (int i = 0; i < nb; i++) {
			if(counter == max)
				this.counter = min;
			else
				this.counter++;
		}
	}
	
	
	/**
	 * This method decrement the Cyclic Counter
	 */
	public void decrement(){
		if(counter == min)
			this.counter = max;
		else
			this.counter--;
	}
	
	/**
	 * this methode make a multiple decrementation in the Cyclic Counter
	 */
	public void decrement(int nb){
		for (int i = 0; i < nb; i++) {
			if(counter == min)
				this.counter = max;
			else
				this.counter--;
		}
	}
	
}
