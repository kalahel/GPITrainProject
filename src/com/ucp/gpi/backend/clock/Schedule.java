package com.ucp.gpi.backend.clock;

/**
 * 
 * @author matthieu
 *
 */
public class Schedule {

	private int hour;
	private int minute;
	
	public Schedule(int hour, int minute){
		if(hour>=0 && hour<24)
			this.hour = hour;
		else
			this.hour = 0;
		//ajouter une exception ?
		
		if(minute>=0 && minute<60)
			this.minute = minute;
		else
			this.minute = 0;
	}
	
	public Schedule(String str){
		String[] tab = new String[2];
		tab = str.split("h");
		if(tab.length == 2){
			hour = Integer.parseInt(tab[0].trim());
			minute = Integer.parseInt(tab[1].trim());
		}
		else if(tab.length == 1){
			hour = Integer.parseInt(tab[0].trim());
		}
	}
	
	public void convertString(String str){
		String[] tab = new String[2];
		tab = str.split("h");
		if(tab.length == 2){
			hour = Integer.parseInt(tab[0].trim());
			minute = Integer.parseInt(tab[1].trim());
		}
		else if(tab.length == 1){
			hour = Integer.parseInt(tab[0].trim());
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return hour + "h" + minute;
	}
}
