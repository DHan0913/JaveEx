package com.javaex.collection.hash;

import java.util.Arrays;
import java.util.HashSet;

import javax.management.ObjectInstance;

class Student {
	int id;
	String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//	값의 동일성 판별을 위한 equals 메서드 오버라이드
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	//	객체의 동등성 비교를 위한 두 개의 관문
	//	1. hashCode()
	//	2. equals()
	@Override
	public int hashCode() {
		
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student other = (Student)obj;
			return id == other.id 
					&& name.equals(other.name);
			
			
		}
		return super.equals(obj);
	}
	
	
}

public class HashSetEx {

	public static void main(String[] args) {
		//	1. HashSet 사용법 (기본타입)
		usingHashSet();
		//	2. 집합 연산
		setOperation();
		//	3. HashSet 사용법 (객체 자료형)
		usingHashSetWithCustom();

	}
	
	private static void usingHashSet() {
		HashSet<String> hs = new HashSet<>();	//	선언
		
		//	요소(객체) 추가
		hs.add("Java");
		hs.add("C");
		hs.add("C++");
		hs.add("Python");
		hs.add("Java");
		
		System.out.println("hs:" + hs);
		System.out.println("size:" + hs.size());
		
		//	특정 객체 포함 여부
		System.out.println("C++ 포함?" + hs.contains("C++"));
		System.out.println("Linux 포함?" + hs.contains("Linux"));
		
		System.out.println("hs:" + hs);
		
		//	순서가 없음
		
		hs.remove("C++");	//	객체 삭제
		System.out.println("hs:" + hs);
		
	}
	
	private static void setOperation() {
		//	집합 연산
		HashSet<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println("전체집합:" + numbers);
		HashSet<Integer> odds = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
		System.out.println("홀수집합:" + odds);
		HashSet<Integer> evens = new HashSet<>(Arrays.asList(2, 4, 6, 8, 10));
		System.out.println("짝수집합:" + evens);
		HashSet<Integer> mThree = new HashSet<>(Arrays.asList(3, 6, 9));
		System.out.println("3의배수집합:" + mThree);
		
		//	교집함 : retainAll
		//	원본 보호를 위해 복제해서 사용
		System.out.println("=========== 교집함");
		HashSet<Integer> setA = (HashSet<Integer>)odds.clone();
		HashSet<Integer> setB = (HashSet<Integer>)mThree.clone();
		System.out.println("집합A:" + setA);
		System.out.println("집합B:" + setB);
		
		setA.retainAll(setB);	//	집합A 교집합 B = {3,9}
		System.out.println("교집합:" + setA);
		System.out.println(setA.equals(new HashSet<Integer>(Arrays.asList(3, 9))));
		
		//	합집합 : addAll
		System.out.println("=========== 합집함");
		setA = (HashSet<Integer>)odds.clone();
		setB = (HashSet<Integer>)evens.clone();
		
		System.out.println("집합A:" + setA);
		System.out.println("집합A:" + setB);
		
		setA.addAll(setB);	//	집합A 합집합 B
		System.out.println("합집합:" + setA);
		System.out.println(setA.equals(numbers));
		
		//	차집합 : removeAll
		System.out.println("=========== 차집함");
		setA = (HashSet<Integer>)numbers.clone();
		setB = (HashSet<Integer>)odds.clone();
		
		System.out.println("집합A:" + setA);
		System.out.println("집합B:" + setB);
		
		setA.removeAll(setB);	//	집합A - 집합B
		System.out.println("차집합:" + setA);
		System.out.println(setA.equals(evens));
		
		
		
	}
	private static void usingHashSetWithCustom() {
		HashSet<Student> hs = new HashSet<>();
		
		Student s1 = new Student(10, "홍길동");
		Student s2 = new Student(20, "홍길동");
		Student s3 = new Student(30, "고길동");
		Student s4 = new Student(30, "고길동");
		//	s3와 s4가 이름도 같고 학번도 같으니
		//	-> 두 객체를 동등 객체로 판정하는 로직을 만들어야
		
		hs.add(s1); hs.add(s2); hs.add(s3); hs.add(s4);
		
		System.out.println("학생부:" + hs);
	}

}
