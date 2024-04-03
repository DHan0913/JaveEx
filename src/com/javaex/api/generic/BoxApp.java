package com.javaex.api.generic;

public class BoxApp {

	public static void main(String[] args) {
		//	내부에 오직 String만 저장 가능
		StringBox strBox = new StringBox();
		strBox.setContent("Generic");
		
		String retStr = strBox.getContent();
		System.out.println(retStr);
		
		//	내부에 오직 Integer만 저장 가능한 클래스
		IntBox intBox = new IntBox();
		intBox.setContent(2024);
		
		Integer retInt = intBox.getContent();
		System.out.println(retInt);
		
		//	타입별로 처리할 수 있는 모든 객체를 만들어야 한다?
		//	-> Object를 처리할 수 있는 개체를 만들면 모든 객체를 처리할 수 있는 만능 클래스가 된다
		
		//	모든 것을 다 담을 수 있는 객체
		ObjectBox objBox = new ObjectBox();
		objBox.setContent("Object Box");
		String obj = (String)objBox.getContent();
		System.out.println(obj);
		
		objBox.setContent(2024);
		Integer objInt = (Integer)objBox.getContent();
		
		System.out.println(objInt);
		//	문제점
		//	1. setter에서 전달되는 매개변수의 타입을 제한 할 수 없다
		//	2. 데이터를 받아올 때, 캐스팅이 필요 Object -> 실제 클래스로의 변환
//		String obj2 = (String)objBox.getContent();	//	캐스팅을 잘못하면 오류
		
		//	GenericBox
		//	내부 데이터 타입을 외부에서 객체화 시점에서 결정해준다
		GenericBox<String> genericStrBox = new GenericBox<>();
		//	-> 내부 데이터를 String 타입으로 결정
		genericStrBox.setContent("Generic Box");
//		genericStrBox.setContent(2024);	//	컴파일 시점에서 내부 입력 데이터 체크 
		
		String objStr = genericStrBox.getContent();
		//	내부 저장 데이터가 지정 되어 있기 때문에 캐스팅이 불필요
		System.out.println(objStr);
	}

}
