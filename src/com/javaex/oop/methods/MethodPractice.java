package com.javaex.oop.methods;

public class MethodPractice {

	public static void main(String[] args) {
		// 매개변수 x, 리턴 x
		printMessage(); 
		printNumbers();
		// 매개변수 x, 리턴 o
		int random = getRandomNumber(); 
		System.out.println(random);
		int sum = getSumNumber(); 
		System.out.println(sum);
		// 변수 o, 리턴 x
		printOddOrEven(4);
		printStringLengh("Hello Method");
		//
		System.out.println(getLargeNumber(4, 3));
		//
		System.out.println(concatenateStrings("Java ", "Programming "));
		//
		System.out.println(sumAll(1, 2, 3, 4, 5, 6, 7, 8, 9));
		//
		System.out.println(concatenateStrings("Java ", "Programming ", "is ", "fun!"));
	}

	private static void printMessage() {
		// 매개변수 x
		// 리턴 x -> void
		System.out.println("Hello Method!");
		
	}
	
	private static void printNumbers() {
		for (int i=1; i<=10; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
	}
	
	private static int getRandomNumber() {
		return (int)(Math.random()*100)+0;
		
	}
	private static int getSumNumber() {
		return 1+2+3+4+5+6+7+8+9+10;
		
	}
	private static void printOddOrEven(int num1) {
		if (num1 == 0 ) {
			System.out.println("0입니다");
		} else if (num1%2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		// 3항 연산 : 조건식 ? 참일 때의 값 : 거짓일 때의 값
		// System.out.println(num % 2 == 0 ? "짝수": "홀수");
		
	}
	private static void printStringLengh(String x) {
		System.out.println(x.length());
	}
	private static int getLargeNumber(int num1, int num2) {
		int large = 0;
		if (num1 > num2) {
			large = num1;
		} else {
			large = num2;
		}
		return large;
	}
	
	private static String concatenateStrings(String b, String c) {
		return b+c;
		
	}
	private static int sumAll(int ...values) {
		int total = 0;
		for (int val: values) {
			total += val;
		}
		return total;
	}
	private static String concatenateStrings(String ...values) {
		String result = "";
		for (String val: values) {
			result += val;
		}
		return result;
	}
}

