package com.javaex.basic.loop;

public class BreakEx {

	public static void main(String[] args) {
		int a = 14;
		
		while(true) {
			if (a % 6 == 0 && a % 14 == 0) {
				break;		
			}
			a = a + 14;
		}
		System.out.println(a);
		
	}

}
