package com.javaex.functional.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student {
	private String name;

	private int kor;
	private int eng;
	private int math;

	// 생성자
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return kor + eng + math;
	}

	public double getAverate() {
		return (double) getTotal() / 3;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", getTotal()="
				+ getTotal() + ", getAverate()=" + getAverate() + "]";
	}

}

public class StreamEx {

	public static void main(String[] args) {
		// 프리미티브 타입 스트림
		int scores[] = { 80, 90, 70, 100, 60, 50 };

		// 배열에서 스트림 뽑아내는 방법
		IntStream arrStream = Arrays.stream(scores);
//		System.out.println(arrStream);

		// 사용자 정의 클래스 타입 스트림
		List<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 90, 95, 100));
		students.add(new Student("고길동", 80, 50, 90));
		students.add(new Student("전우치", 80, 90, 80));
		students.add(new Student("임꺽정", 70, 65, 70));
		students.add(new Student("장길산", 60, 60, 60));

		// 컬렉션 프레임워크 클래스에서는 .stream() 메서드로 스트림 추출 가능
		Stream<Student> objStream = students.stream();
//		System.out.println(objStream);

		// 최종 연산 : forEach
//		testForEach(scores, students);	
//		testFilter(scores, students);	//	Filter
//		testMap(scores);				//	map
//		testCountSum(scores);			//	count, sum
//		testFilterSort(students);		//	filter + sorted
		testReduce(scores);
	}

	private static void testForEach(int[] source, List<Student> lst) {
		// forEach -> 최종 연산, 스트림을 순회하면서 최종 처리
		System.out.println("============= stream forEach");

		// 배열의 순회
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i] + " ");

		}
		System.out.println();
//		forEach 사용	
		Arrays.stream(source).forEach(n -> System.out.print(n + " "));
		System.out.println();

		// 컬렉션 순회
		Iterator<Student> it = lst.iterator();
		while (it.hasNext()) {
			Student st = it.next();
			System.out.println(st);
		}

		// forEach
		lst.stream().forEach(obj -> System.out.println(obj));
	}

	private static void testFilter(int[] arr, List<Student> lst) {
		// arr에서 정수가 70점 이상인 것만 추출
		System.out.println("========= Stream filter");
		System.out.println(Arrays.toString(arr));

		Arrays.stream(arr).filter(n -> n >= 70).forEach(n -> System.out.print(n + " "));
		System.out.println();

		// lst에서 평균점수가 70점 이상인 것만 추출
		lst.stream().filter(obj -> obj.getAverate() >= 70).forEach(System.out::println);
	}

	private static void testMap(int[] arr) {
		System.out.println("========== stream map");
		// 맵은 형태는 그대로, 내부 요소의 변형
		System.out.println("원본:" + Arrays.toString(arr));
		// 각 요소를 /2 해서 새로운 배열을 생성

		Arrays.stream(arr) // 배열을 스트림으로
				.map(n -> n / 2).forEach(n -> System.out.print(n + " "));
		System.out.println();

		// 배열 arr요소 모두 *2 -> 새로운 배열로 변환
		int[] multiply = Arrays.stream(arr).map(n -> n * 2).toArray();
		System.out.println("*2:" + Arrays.toString(multiply));
	}

	private static void testCountSum(int[] arr) {
		// count : 요소의 개수를 카운트하는 함수(집계)
		int numCount = (int) Arrays.stream(arr).count();
		System.out.println(Arrays.toString(arr) + ": count =" + numCount);

		// sum : 기본형 특화 스트림에서만 사용가능
		// 기본형 특화 스트림 : primitive type을 처리하기 위해 만들어진 스트림
		// IntStream, LongStream, DoubleStram
		// 배열로부터 70점 이상인 점수를 필터링 모두 합산
		System.out.println("70점 이상 점수 합계:" + Arrays.stream(arr).filter(n -> n >= 70).sum());
	}


	private static void testFilterSort(List<Student> list) {
		//	평균점 70점 이상인 학생 목록으로부터 학생 이름의 오름차순으로 정렬하여 출력
		System.out.println("========= stream filter + sort");
		
		list.stream()
			.filter(obj -> obj.getAverate() >= 70)	//	필터 함수
//			.sorted((obj1, obj2) -> obj1.getName().compareTo(obj2.getName()))	//	정렬(오름차순)
			.sorted((obj1, obj2) -> -obj1.getName().compareTo(obj2.getName()))	// 내림차순
			.forEach(System.out::println);
		
	}

	private static void testReduce(int[] arr) {
		System.out.println("원본: " + Arrays.toString(arr));
		System.out.println("============= stream reduce");
		
		int total = Arrays.stream(arr)
				.reduce(0, // 누산기 초기값 
				(acc, curr) -> {	// acc: 누산기, curr, 현재 요소
					System.out.println("acc:" + acc);
					System.out.println("curr:" + curr);
					return acc + curr;
				});
		System.out.println("Total:" + total);
	}
}

