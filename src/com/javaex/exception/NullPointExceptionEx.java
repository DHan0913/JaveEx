package com.javaex.exception;

public class NullPointExceptionEx {

	public static void main(String[] args) {
		
		String str = new String("hello");
		str = null;
		try {
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.err.println("값이 비어 있어요");
		} finally {
			// 예외 유무 관계 없이 가장 마지막에 1회 실행 
			// try 블록에서 설정된 시스템 자원 등을 해제
			// 필수가 아님
			System.out.println("예외처리 종료.");
		
	}
		
	}
}
