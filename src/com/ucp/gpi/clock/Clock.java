package com.ucp.gpi.clock;

import com.ucp.gpi.utils.CyclicCounter;

/**
 * This class represent a clock
 * @author quentin - matthieu
 * @version 22012017
 */
public class Clock extends Thread{
	private int total;
	private CyclicCounter min;
	private CyclicCounter hours;
	private CyclicCounter days;
	private CyclicCounter months;
	private CyclicCounter years;
	
	public final static long speed = 50;
	private boolean pause;
	
	public Clock(int hours, int min, int days, int mounths, int years){
		this.total = 0;
		this.min = new CyclicCounter(min, 0, 59);
		this.hours = new CyclicCounter(hours, 0, 23);
		this.days = new CyclicCounter(days, 1, 30);
		this.months = new CyclicCounter(mounths, 1, 12);
		this.years = new CyclicCounter(years, 2017, 2117);
		
		this.pause = false;
	}
	
	/**
	 * This method increment the clock
	 */
	public void increment(){
		this.total ++;
		min.increment(1);
		if(min.getCounter() == min.getMin()){
			hours.increment();
			if(hours.getCounter() == hours.getMin()){
				days.increment();
				if(days.getCounter() == days.getMin()){
					months.increment();
					if(months.getCounter() == months.getMin()){
						years.increment();
					}
				}
			}
		}
	}

	/**
	 * This method run the clock
	 */
	public void run(){
		while(!pause){
			try {
				Clock.sleep(speed);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			this.increment();
			System.out.println(this.toString());
		}
	}
	
	public int getTotal(){
		return total;
	}
	
	public void setTotal(int total){
		this.total = total;
	}

	public CyclicCounter getMin() {
		return min;
	}

	public void setMin(CyclicCounter min) {
		this.min = min;
	}

	public CyclicCounter getHours() {
		return hours;
	}

	public void setHours(CyclicCounter hours) {
		this.hours = hours;
	}
	
	public CyclicCounter getDays() {
		return days;
	}

	public void setDays(CyclicCounter days) {
		this.days = days;
	}

	public CyclicCounter getMonths() {
		return months;
	}

	public void setMonths(CyclicCounter months) {
		this.months = months;
	}

	public CyclicCounter getYears() {
		return years;
	}

	public void setYears(CyclicCounter years) {
		this.years = years;
	}

	public long getSpeed() {
		return speed;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	public static String transform(int value){
		String str;
		if (value < 10)
			str = "0" + value;
		else
			str = String.valueOf(value);
		
		return str;
	}

	public String toString(){
		return "(" + days.toString() + "/" + months.toString() + "/" + years.toString() + ") - " + hours.toString() + ":" + min.toString();
	}
	
}
