package com.javaex.basic.loop;

import java.util.Scanner;

public class WhileGugu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("단을 입력해주세요");
		int dan; 
		dan = scanner.nextInt();
		int i = 1;
		
		while (i < 10) {
			System.out.println(dan + "*" + i + "=" + (dan * i) );
			i = i + 1;
			
		}

		scanner.close();
	}

}
