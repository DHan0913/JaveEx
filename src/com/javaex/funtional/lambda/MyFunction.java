package com.javaex.funtional.lambda;

@FunctionalInterface		//	인터페이스가 함수형인지를 컴파일러에게 문의
public interface MyFunction {
	//	함수형 인터페이스 - 내부에 반드시 1개의 메서드만 허용
	int getResult(int x, int y);	// 추상 메서드
	//	내부 로직을 설계시에 미정 상태로 둔다 
}
