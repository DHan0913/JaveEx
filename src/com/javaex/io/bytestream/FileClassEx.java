package com.javaex.io.bytestream;

import java.io.File;
import java.io.IOException;

public class FileClassEx {
	// files의 경로 (실제)위치
	private static String rootPath = System.getProperty("user.dir") + "\\files";

	public static void main(String[] args) {
		System.out.println("루트 경로:" + rootPath);

		File f = new File(rootPath); // 파일명으로 정보 객체 생성
		System.out.println(rootPath + ":" + (f.exists() ? "존재" : "없음"));

		printFileInfo(f);

		// 디렉터리 만들기
		// files 디렉터리 아래 files\\subdir2 -> 디렉터리 생성
		File newDir = new File(rootPath + "\\subdir\\subdir2"); // 파일(디렉터리) 정보
		if (!newDir.exists()) { // 존재 여부 확인
			if (newDir.mkdirs()) { // 실제 생성
				System.out.println(newDir + "을 생성했습니다.");
			}
		}
		printFileInfo(f);

		// 새로 생성한 file\\subdir 디렉터리에 새파일 myfile.txt를 만들어 봅시다.
		File newFile = new File(rootPath + "\\subdir\\myfile.txt");
		// 파일 객체 생성 -> 정보객체 생성하는 것, 파일을 만드는 것은 아니다
		if (!newFile.exists()) { // 존재 여부를 확인 후, 없으면 생성
			try {
				newFile.createNewFile(); // 실제 파일 생성
			} catch (IOException e) {
				System.err.println("파일을 만들지 못했어요.");
			}

		}
		printFileInfo(f);
		
		//	파일 삭제
		newFile.delete();
		
		

	}

	private static void printFileInfo(File f) {
		System.out.println("---------");

		// 전달 받은 파일 객체가 디렉터리인가?
		if (f.isDirectory()) {
			System.out.println("디렉터리:" + f.getName());

			// 파일 목록 가져오기
			File[] files = f.listFiles(); // 파일 정보의 배열

			for (File file : files) {
				System.out.print(file.isDirectory() ? "d" : "f ");
				System.out.print(file.canRead() ? "r" : ".");
				System.out.print(file.canWrite() ? "w" : ".");
				System.out.print(file.canExecute() ? "x" : ".");

				System.out.print(" " + file.getName()); // 파일명 표시
				System.out.println("\t" + file.length()); // 파일 사이즈

			}

		} else { // 파일 -> 간략 정보
			System.out.print("File:");
			// 간략한 파일 정보
			System.out.print(f.getName() + "\t"); // 파일명
			System.out.print(f.canRead() ? "r" : "."); // 읽을 수 있냐?
			System.out.print(f.canWrite() ? "w" : "."); // 기록할 수 있냐?
			System.out.print(f.canExecute() ? "x" : "."); // 실행할 수 있냐?
			System.out.println();
		}
	}

}
