package com.javaex.thread.synchronize;

public class MainThread {

	public static void main(String[] args) {
		// 공유 객체
		SharedMemory memory = new SharedMemory();
		
		User user1 = new User("철수", memory, 100);
		User user2 = new User("영희", memory, 50);
		
		//	쓰레드 실행
		user1.start();
		user2.start();
	}

}
