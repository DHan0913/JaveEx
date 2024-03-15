package com.javaex.basic.conditional;

import java.util.Scanner;

public class ifElsePractice02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("과목을 선택하세요");
		System.out.println("1. 자바 2. C 3. c++ 4.파이썬" );
		Scanner scanner = new Scanner(System.in); 
		System.out.print("과목번호:");
		int num = scanner.nextInt();
		if (num == 1) {
			System.out.println("R101");
		} else if (num == 2) {
			System.out.println("R102");
		} else if (num == 3) {
			System.out.println("R103");
		} else if (num == 4) {
			System.out.println("R104");
		} else { 
			System.out.println("상담원에게 문의하세요");
		}
		
		scanner.close();
			
			}
		}
	


