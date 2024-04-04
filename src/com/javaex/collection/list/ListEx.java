package com.javaex.collection.list;

import java.util.LinkedList;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		//	List  
		//	객체가 아니라 인터페이스
		//	순서가 있다
		//	중복 허용
		List<String> lst = new LinkedList<>(); 
		
		//	객체 추가 : .add
		lst.add("Java");
		lst.add("C");
		lst.add("C++");
		lst.add("Python");
		
		System.out.println("lst=" + lst);
		
		
		lst.add(2, "C#"); // 객체 삽입
		System.out.println("lst=" + lst);
		
		lst.add("Java"); //	리스트는 중복 삽입을 허용 
		System.out.println("lst=" + lst);
		
		System.out.println("size:" + lst.size());
//		System.out.println("capacity:" + lst.capacity()); 벡터와 달리 확인 할 수 없음
		
		lst.remove(2); // 삭제 : 인덱스 삭제
		lst.remove("Python"); // 객체 삭제
		
		System.out.println("lst=" + lst);
		
		//	TODO: List 순회
		
		lst.clear(); //	비우기
		System.out.println("lst=" + lst);
		
		
	}

}
