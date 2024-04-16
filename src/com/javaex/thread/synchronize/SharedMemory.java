package com.javaex.thread.synchronize;

//	여러 쓰레드가 공유할 공유 메모리 (임계영역)
public class SharedMemory {
	// 필드
	private int memory;

	// getter/setter
	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		//	임계 영역: 멀티 쓰레드 프로그램에서 단 하나의 쓰레드만 실행할 수 있는 코드 영역
		//	synchronized 키워드 이용, 임계영역을 선언할 수 있다
		this.memory = memory;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
	}

}
