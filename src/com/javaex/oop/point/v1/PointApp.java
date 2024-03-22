package com.javaex.oop.point.v1;

import com.javaex.oop.goods.v2.Goods;

public class PointApp {

	public static void main(String[] args) {
		Point a = new Point();
		
		a.setX(5);
		a.setY(6); 
		
		Point b = new Point();
		
		b.setX(7);
		b.setY(8); 
		
		a.draw();
		b.draw();

	}

}
