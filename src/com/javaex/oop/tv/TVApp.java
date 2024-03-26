package com.javaex.oop.tv;

public class TVApp {

	public static void main(String[] args) {
		TV tv = new TV (7, 20, false); //A
		
		tv.status(); 
		
		tv.power(true);
		tv.volume(120); 
		tv.status();
		
		tv.volume(false);
		tv.status();
		
		tv.channel(0);
		tv.status();
		
		tv.channel (true);
		tv.channel (true);
		tv.channel (true);
		tv.status();
		
		tv.power(false);
		tv.status();
		
		System.out.println("---------------------------------------");
		TV tv2 = new TV (4, 10, true); 
		
		tv2.status(2); 
		
		tv2.power(true);
		tv2.volume(60); 
		tv2.status(2);
		
		tv2.volume(false);
		tv2.status(2);
		
		tv2.channel(0);
		tv2.status(2);
		
		tv2.channel (true);
		tv2.channel (true);
		tv2.channel (true);
		tv2.status(2);
		
		tv2.power(false);
		tv2.status(2);
		
	}

}
