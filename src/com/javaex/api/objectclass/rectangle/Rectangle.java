package com.javaex.api.objectclass.rectangle;

public class Rectangle {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle other = (Rectangle) obj;
			return width * height == other.width * other.height;
		}
		return super.equals(obj);
	}
}

// 면적 구하는 메서드
//	public int area () {
//		return width * height;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Rectangle) {
//			Rectangle other = (Rectangle)obj;
//			return area() == other.area();
//		}
//		return super.equals(obj);
//	}
