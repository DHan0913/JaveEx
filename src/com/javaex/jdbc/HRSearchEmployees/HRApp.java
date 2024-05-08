package com.javaex.jdbc.HRSearchEmployees;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.javaex.jdbc.dao.AuthorDAO;
import com.javaex.jdbc.dao.AuthorDAOImplOracle;
import com.javaex.jdbc.dao.AuthorVO;


public class HRApp {

	public static void main(String[] args) {
		listHR();
		getHR();

	}
	private static void listHR() {
		HRDAO dao = new HRDAOImplOracle();
		System.out.println("======== employees =========");
		
		List<HRVO> list = dao.getList();
		if (list.size() > 0) {
			// Iterator 순회
			Iterator<HRVO> it = list.iterator();
			
			while (it.hasNext()) {
				HRVO vo = it.next();
				System.out.printf("%s: %s, %s, %s%n", vo.getName(), vo.getEmail(), vo.getPhoneNumber(), vo.getHireDate());
			}
		} else {
			System.out.println("데이터가 없습니다.");
		}
	}
	
	private static void getHR() {
		Scanner scanner = new Scanner(System.in); 
		
		System.out.print("직원 이름:");
		String name = scanner.nextLine();
		
		HRDAO dao = new HRDAOImplOracle();
		HRVO vo = dao.get(name);
		
		if (vo != null) {
			System.out.printf("%s: %s, %s, %s%n", vo.getName(), vo.getEmail(), vo.getPhoneNumber(), vo.getHireDate());
		} else {
			System.out.println("레코드를 찾지 못했습니다.");
		}
		
		scanner.close();
	}

}
