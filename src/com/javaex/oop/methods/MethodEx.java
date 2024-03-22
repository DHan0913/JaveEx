package com.javaex.oop.methods;

public class MethodEx {

	public static void main(String[] args) {
		
//		printMessage(); // 매개변수 x, 리턴 x
			
//		String message = getMessage(); // 매개변수 x, 리턴 o
//		System.out.println(message);
		
		printDevide(4, 0); // 매개변수 o, 리턴 x

//		int num1 = 4, num2 = 5; //매개변수 
//		double sum = getSum(num1, num2); // 매개변수 o, 리턴 o
//		double sum = getSum(num1, num2, 6); //이름이 같아도 변수 수가 다르면 생성 가능 
//		System.out.println(sum);
		
	}
	
	private static double getSum(double num1, double num2) {
		System.out.println("매개변수 있고, 리턴도 있는 메서드");
		return num1 + num2;
	}
	
	private static double getSum(double num1, double num2, double num3) {
		System.out.println("매개변수 있고, 리턴도 있는 메서드");
		return num1 + num2 + num3;
		
	}
	
	private static void printDevide(int num1, int num2) {
		// 리턴 타입이 없어도 return 할 수 있음
		System.out.println("매개변수 있고, 리턴 없는 메서드");
		if (num2 == 0 ) {
			System.out.println("0으로는 나눌수 없습니다.");
			return;
		}
		System.out.printf("%d / %d = %d%n", 
				num1, num2, num1/num2);
	}
	private static String getMessage() {
		return "매개변수 없지만 리턴은 있는 메서드";
	}
	
	private static void printMessage() {
		// 매개변수 x
		// 리턴 x -> void
		System.out.println("매개변수 없고, 리턴도 없는 매서드");
		
	}

}
