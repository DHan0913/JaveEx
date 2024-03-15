package com.javaex.basic.conditional;

import java.util.Scanner;

public class IfelseEx2 {
	// 숫자 입력, > 0: 양수, < 0: 음수, 0
	public static void main(String[] args) {
		// 스캐너 열기
		Scanner scanner = new Scanner(System.in);
		// 숫자 입력 
		System.out.print("숫자입력:");
		int num = scanner.nextInt();
		
		// 숫자 조건 분기
		/*
		if (num > 0) {
			System.out.println("양수입니다");
		} else if (num < 0) {
			System.out.println("음수입니다");
		} else {
			System.out.println("0입니다");
		}
		// 스캐너 닫기
		scanner.close();
	}
	*/
	// 중첩 if
	if (num == 0) {
		System.out.println("입니다");
	} else {
		if (num > 0) {
			System.out.println("양수입니다.");
		} else {
			System.out.println("음수입니다.");
		}
	}
	
	// 스캐너 닫기
	scanner.close();
}
		
	}

