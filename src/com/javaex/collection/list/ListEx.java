package com.javaex.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		//	List  
		//	객체가 아니라 인터페이스
		//	순서가 있다
		//	중복 허용
//		List<String> lst = new LinkedList<>(); 
		List<String> lst = new ArrayList<>();
		
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
		//	Set, List 순회시에는 Iterator 객체 사용
		System.out.println("=============== Iterator");
		Iterator<String> it = lst.iterator();	//	반복자 추출
		
		while(it.hasNext()) {	//	뒤에 더 있나?
			String item = it.next();	//	요소 추출 후 다음으로 리턴
			System.out.print(item + " ");
		}
		System.out.println();
		
		lst.clear(); //	비우기
		System.out.println("lst=" + lst);
		
		
	}

}
