package com.javaex.basic.conditional;

import java.util.Scanner;

public class SwitchEx {

	public static void main(String[] args) {
		// 스캐너 열기
		Scanner scanner = new Scanner(System.in);
		
		// 과목번호 입력
		System.out.println("과목 번호를 입력하세요.");
		int subj = scanner.nextInt();
	
		// 조건분기 (switch)
		switch(subj) {
		case 1: // subj == 1
			System.out.println("R101입니다.");
			break;
		case 2: // subj == 2
			System.out.println("R202입니다.");
			break;
		case 3: // subj == 3
			System.out.println("R303입니다");
			break;
		case 4: // subj == 4
			System.out.println("R404입니다");
			break;
		default:// else
			System.out.println("관리자에게 문의하세요");
			break;
		}
		// 스캐너 닫기
		
		scanner.close();
	}

}
