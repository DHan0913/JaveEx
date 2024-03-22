package com.javaex.oop.goods.v2;

// v2, private
public class Goods {
	// 필드 선언
	// instance 영역 
	private String name;	// 상품명
	private int price;		// 가격

	// Getter Setter
	public String getName() {
		// 메서드 영역
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if (price < 0) {
			this.price = 0;
		} else {
			this.price = price;
		}
	}
	
	
	
	// 일반 메서드
	public void showInfo() {
		System.out.printf("상품 이름: %s%n가격:%,d원%n", name, price);
	}
	
	
}

