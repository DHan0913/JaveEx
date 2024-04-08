package com.javaex.collection.list;

import java.util.Stack;

public class StatckEx {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(); // 스택 선언

		for (int i = 0; i < 10; i++) { // 데이터 입력
			stack.push(i);
			System.out.println("STACK:" + stack);
		}

		System.out.println("PEEK:" + stack.peek());	// 가장 마지막에 있는 데이터 확인
		System.out.println("STACK:" + stack);
		
		System.out.println("POP:" + stack.pop());	//	인출
		System.out.println("STACK:" + stack);
		
		while (true) {
			System.out.println("POP:" + stack.pop());
			System.out.println("Stack" + stack);
		}
		//	Stack 비어있는지 확인 해야 한다
		
//		while(!stack.empty()) {	//비어 있지 않으면
//			System.out.println("POP:" + stack.pop());
//			System.out.println("STACK:" + stack);
//		}
	}

}
