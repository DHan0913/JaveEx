package com.javaex.api.generic;

//	Generic
//	설계시 내부 데이터 타입을 미정 상태로 남겨두고
//	실제 객체화시 - 외부에서 내부 데이터 타입을 결정해주는 방식
public class GenericBox<T> {
	//	자주 사용하는 템플릿 문자
	//	T: Type
	//	K: Key
	//	V: Value
	//	R: Return Type
	T content;
	
	public T getContent() {
		return content;
	}
	
	public void setContent(T content) {
		this.content = content;
	}

}

