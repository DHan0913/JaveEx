package com.javaex.api.arrays;

import java.util.Arrays;

public class SearchEx {

	public static void main(String[] args) {
		//	1. 기본 타입 검색
		basicSearch();
		
		//	2. 사용자 정의 객체의 검색

	}
	
	private static void basicSearch() {
		//	Java Arrays의 검색 기능은 binarySearch 방식으로 구현
		int[] nums = {6, 4, 3, 5, 7, 9, 8, 2, 1, 10};
		
		//	이진 검색 방식의 배열은 정렬이 되어 있어야 한다.
		Arrays.sort(nums);
		System.out.println("정렬된 배열:" + Arrays.toString(nums));
		int index = Arrays.binarySearch(nums,	//	검색 대상 배열
				8);
		System.out.println("8의 인덱스:" + index);
		
		//	참조 타입의 검색
		String[] data = {"Java", "C", "C++", "Python", "Linux"};
		
		//	검색을 위한 정렬
		Arrays.sort(data);
		System.out.println("정렬된 배열:" + Arrays.toString(data));
		
		index = Arrays.binarySearch(data, //	검색 대상 배열
									"Java");
		System.out.println("Java의 인덱스:" + index);
	}

}
