package com.javaex.io.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileStreamEx {
	private static String rootPath = System.getProperty("user.dir") + "\\files\\";
	private static String source = rootPath + "img.jpg";	
	private static String target = rootPath + "img_copy.jpg";
	
	public static void main(String[] args) {
		System.out.println("rootPath:" + rootPath);
		System.out.println("원본파일:" + source);
		System.out.println("타겟파일:" + target);
		
		try ( // 스트림 열기
			FileInputStream fis = new FileInputStream(source);	//	인풋스트림
			OutputStream fos = new FileOutputStream(target);	// 출력스트림
			)
		{
//			입력 데이터 변수 
			int data = 0;
			
			while((data = fis.read()) != -1) {
				//	데이터 읽기
				//	아웃풋 스트림으로 출력
				fos.write(data);
				System.out.println("data:" + data);
		}
			
		System.out.println("파일은 복사했어요.");	
		} catch (FileNotFoundException e) {	//	파일이 없을때의 예외
			System.err.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
