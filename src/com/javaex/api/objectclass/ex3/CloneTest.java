package com.javaex.api.objectclass.ex3;

public class CloneTest {

	public static void main(String[] args) {
		//	객체 생성
		Point p = new Point(10,20);
		System.out.println("p=" + p);
		
		//	객체 복제
		Point p2 = p;	// 참조 복제 (주소만 복제)
		
		//	얕은 복제
		Point p3 = p.getClone();
		
		System.out.println("p2=" + p2);
		System.out.println("p3=" + p3);
		
		System.out.println();
		//	p의 내부 필드 변경
		p.setX(30); p.setY(100);
		
		System.out.println("p=" + p);
		System.out.println("p2=" + p2);
		System.out.println("p3=" + p3);
		
		//	참조 복제는 실제로는 같은 객체
		//	데이터 보호를 위해서는 참조 복제는 피하는 것이 좋다
	

	}

}
