package com.javaex.oop.point.v2;

public class Point {
	private int X;	
	private int Y;		
	
	public Point(int X, int Y) {
		//	객체 초기화를 담당
		this.X = X;
		this.Y = Y;
	}

	public int getX() {

		return X;
	}
//	public void setX(int X) {
//		this.X = X;
//	}
	
	public int getY() {
		return Y;
	}
//	public void setY(int Y) {
//		this.Y = Y;
//		
//	
//	}
	
	
	public void draw() {
		System.out.println("점[" + "x=" + X +"," + " y=" + Y + "]을 그렸습니다.");
		
	}
	
	
}
