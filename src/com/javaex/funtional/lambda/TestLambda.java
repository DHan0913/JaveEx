package com.javaex.funtional.lambda;

import java.util.function.BiFunction;

public class TestLambda  {
/*
 	함수형 프로그래밍 
    : 데이터를 변경시키지 않고(불변), 작업 수행 규칙(함수)를 중심으로 프로그램을 작성하는 방식	
    - 불변성, 함수의 일급 객체화, 부수 효과 최소화를 목표로 선언적 코드 작성 
    - 자바의 경우, 람다식 + 스트림을 활용, 함수형 프로그래밍을 작성할 수 있음.
    
    람다식
    - 이름이 없는 즉석 함수 
    - 메서드를 간결하게 표현할 수 있으며, 코드를 읽기 쉽고 간단하게 작성 가능
    
    스트림
    - 데이터를 물결의 흐름으로 파악, 여러 함수의 로직의 조합을 거치면서 변경되고 변환되는 절차
 */
	public static void main(String[] args) {
		// 람다 호출법
//		testCallLambda();
		// 람다에 파라미터를 전달하는 방법
//		testLambdaParams(10, 20, (x, y) -> x + y);
		// 고계함수
		// 특정 함수를 거쳐서 함수 내부에서 로직이 생성되어서 반환되는 함수
		// 함수를 반환하는 함수
		MyFunction hof = testHOF();	// 메서드를 실행 해야, 반환되는 함수를 얻을 수 있다.
		System.out.println("HOF:" + hof.getResult(10, 20));
		System.out.println("HOF:" + testHOF().getResult(10, 20));
		
	}

	private static void testCallLambda() {
		//	익명 함수를 사용한 호출
		MyFunction add = new MyFunction() {
		
			@Override
			public int getResult(int x, int y) {
				return x + y;
			}
			
		};
		System.out.println(add.getResult(10, 20));
		
		// 람다식 구현
		MyFunction max = ( x, y ) -> x > y ? x : y;
		System.out.println(max.getResult(10,20));
		
		//	자바는 몇가지 함수의 패턴을 미리 구현한 인터페이스를 가지고 있음
		//	예) 두 개의 입력값 -> 한 개의 출력 함수
		//	BiFunction
		
		BiFunction<Integer,	//첫 번째 입력 파라미터의 타입
					Integer, // 두 번째 입력 파라미터의 타입
					Integer> // 리턴 타입
					findMax = (x, y) -> x > y ? x : y;
					
		//	자바에서 미리 제공된 인터페이스를 사용할 때 .apply 메서드로 호출할 수 있음
	    System.out.println(findMax.apply(10, 20));
	    
	}
	
	private static void testLambdaParams(int x, int y, MyFunction f) {
		//	함수도 1급 시민이다. -> 다른 데이터들과 동등한 지위를  가진다
		//	메서드의 매개 변수로 활용될 수 있고, 메서드의 리턴 데이터로 활용될 수 있다.
		System.out.println(f.getResult(x, y));
		
	}
	
	//	고계 함수
	private static MyFunction testHOF () {
		//	Higher Order Function : 고계 함수
		//	람다 함수를 이용, 메서드의 함수를 반환 
		return (x, y) -> x + y;
	}
	
}
