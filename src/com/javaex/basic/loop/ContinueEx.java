package com.javaex.basic.loop;

public class ContinueEx {
	// 1~20까지의 루프
	// 2의 배수와 3의 배수는 출력 안함
	// 나머지는 출력 
	public static void main(String[] args) {	
		for (int i = 0; i <20; i++ ) {
			if( i % 2 == 0 || i % 3 == 0) {
				continue;
			}
			System.out.println(i);
			
		}

	}

}
