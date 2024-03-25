package com.javaex.oop.point.v2;

// v2, 기본 생성자, 모든 필드 생성자
public class PointApp {

	public static void main(String[] args) {
//		Point a = new Point();
		Point p1 = new Point(5,6);
		
//		a.setX(5);
//		a.setY(6); 
		
//		Point b = new Point();
		Point p2 = new Point(7,8);
		
//		b.setX(7);
//		b.setY(8); 
		
		p1.draw();
		p2.draw();

	}

}
