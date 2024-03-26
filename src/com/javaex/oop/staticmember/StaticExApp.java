package com.javaex.oop.staticmember;

public class StaticExApp {

	public static void main(String[] args) {
		StaticEx s1 = new StaticEx();
		System.out.println("refcount:" + s1.refCount);
		
		StaticEx s2 = new StaticEx();
		System.out.println("refcount:" + StaticEx.refCount);

		StaticEx s3 = new StaticEx();
		System.out.println("refcount:" + StaticEx.refCount);
		
		//	Note.
		//	이 부분은 스태틱 영역에서 메모리 공유를 테스트하기 위한
		//	테스트일 뿐, 직접 가비지 컬렉터를 호출하는 것은
		//	권장하지 않습니다.
		s3 = null; // 참조 해제
		System.out.println("s3 해제");
		System.out.println("refCount:" + StaticEx.refCount);
		
		System.gc(); // 가비지 컬렉터 호출
		try {
			Thread.sleep(3000);	// 3초 대기
			System.out.println("refCount:" + StaticEx.refCount);
		} catch (Exception e) {
			
		}
		
	}
}
