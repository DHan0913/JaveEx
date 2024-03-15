package com.javaex.basic.loop;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		int dan, i ;
		Scanner scanner = new Scanner(System.in);
		System.out.print("단 입력:");
		dan = scanner.nextInt();
		
		// for (초기화; 반복여부체크; 증감식)
		for (i = 1; i < 10; i++) {
			System.out.println(dan + "*" + i + "=" +(dan * i));
			
		}
		scanner.close();
			
		}

	}


