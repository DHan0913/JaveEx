package com.javaex.collection.hash;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

class ClassRoom {
	// 필드
	private String subject;
	private String roomName;

	// 생성자
	public ClassRoom(String subject) {
		this.subject = subject;
	}

	public ClassRoom(String subject, String roomName) {
		super();
		this.subject = subject;
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "ClassRoom [subject=" + subject + ", roomName=" + roomName + "]";
	}

	// Map 형 자료형
	// KeySet과 List의 복합 자료형
	// Key(KeySet)은 순서 없고, 중복 허용하지 않음
	// Value는 Key를 통한 접근만 가능, 중복 허용
	@Override
	public int hashCode() {
		return subject.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ClassRoom) {
			ClassRoom other = (ClassRoom) obj;
			return subject.equals(other.subject);
		}
		return super.equals(obj);
	}

}

public class HashTableEx {

	public static void main(String[] args) {
		// Hashtable 선언
		Map<String, ClassRoom> map = new Hashtable<>();

		// 맵에 데이터 넣기 : put
		map.put("101", new ClassRoom("Java", "R101"));
		map.put("202", new ClassRoom("C", "R202"));
		map.put("303", new ClassRoom("Python", "R303"));
		map.put("404", new ClassRoom("Linux", "R404"));
		
		//	동등성 체크 로직
		//	1. subject의 hashCode를 전체 객체의 hashCode
		//	2. subject의 값이 동일하면 전체 객체의 값도 같다
		
		

		// 출력 : 순서가 없다
		System.out.println(map);

		// 데이터 참조 : get
		System.out.println(map.get("303"));	// 키를 통한 접근 
		
		//	데이터 변경 : put
		map.put("202", new ClassRoom("C#", "R202"));
		System.out.println(map.get("202"));
		
		//	특정 키를 포함하고 있는지 확인
		System.out.println(map.containsKey("202"));
		//	키에 연결된 값을 참조
		System.out.println(map.containsKey("505"));
		
		//	특정 값을 포함하고 있는지 확인
		//	Java가 포함된 값이 있는지 확인
		System.out.println(map.containsValue("Java"));
		System.out.println(map.containsValue(new ClassRoom("Java")));
		
		//	Iterator
		System.out.println("============ Iterator");
		Iterator<String> it = map.keySet().iterator();
		//	키셋으로부터 이터레이터 추출
		
		while(it.hasNext()) {	// 뒤에 요소가 더 있는지 확인 
			ClassRoom room = map.get(it.next());
			System.out.println(room);
		}
		map.clear();
		System.out.println(map);
	}

}
