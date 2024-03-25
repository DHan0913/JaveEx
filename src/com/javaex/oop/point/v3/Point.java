package com.javaex.oop.point.v3;

// v3, 메서드 오버로딩
// 메서드 시그니쳐 : 반환 타입, 이름은 같고
//				매개변수의 타입, 순서, 개수만 다른 메서드
public class Point {
	private int x;	
	private int y;		
	
	public Point(int x, int y) {
		//	객체 초기화를 담당
		this.x = x;
		this.y = y;
	}

	public int getX() {

		return x;
	}
//	public void setX(int X) {
//		this.x = x;
//	}
	
	public int gety() {
		return y;
	}
//	public void setY(int y) {
//		this.y = y;
//		
//	
//	}
	
	
	public void draw() {
		System.out.printf("점[x=%d, y=%d]을 그렸습니다.%n", x,y); 
		
	}
	
	
	
	//	메서드 오버리밍
	//		boolean bDraw -> true면 그렸습니다. - > false면 지웠습니다.
	public void draw(boolean bDraw) {
		String message = String.format("점[x=%d, y=%d]을", x,y);
		message += bDraw ? " 그렸습니다." : " 지웠습니다.";
		System.out.println(message);
	}
	
	
}
