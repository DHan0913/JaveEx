package com.javaex.exception;

import java.util.InputMismatchException;

public class ArrayExceptionEx {

	public static void main(String[] args) {
		int[] intArray = new int[] {3,6,9};
		try { //	예외 발생 가능영역을 try 블록으로 감싼다
			System.out.println(intArray[3]);
			
		} catch (IndexOutOfBoundsException e) {
			// 입력 형식 에러
			System.err.println("배열을 벗어났어요");
		} finally {
			// 예외 유무 관계 없이 가장 마지막에 1회 실행 
			// try 블록에서 설정된 시스템 자원 등을 해제
			// 필수가 아님
			System.out.println("예외처리 종료.");
		
			
		}
		
	}
}
