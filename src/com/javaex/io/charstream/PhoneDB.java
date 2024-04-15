package com.javaex.io.charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class PhoneDB {
	private static String rootPath = System.getProperty("user.dir") + "\\files\\";
	private static String filename = rootPath + "PhoneDB.txt";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("-------------------------");
			System.out.print(">메뉴번호:");

			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				showContact();
				break;
			case "2":
				addContact();
				break;
			case "3":
				showContact();
				deleteContact();
				break;
			case "4":
				searchContact();
				break;
			case "5":
				System.out.println("감사합니다.");
				return;
			default:
				System.out.println("올바른 선택이 아닙니다. 다시 선택하세요.");
			}
		}
	}

	private static void showContact() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			int lineNumber = 1;
			while ((line = br.readLine()) != null) {
				// 각 라인에서 이름과 전화번호 추출
				String[] parts = line.split(",");
				String name = parts[0];
				String mobile = parts[1];
				String company = parts[2];

				// 결과 출력
				System.out.println(lineNumber + ". " + name + " " + mobile + " " + company);

				lineNumber++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void addContact() {
	    try (FileWriter fw = new FileWriter(filename, true);
	         BufferedWriter bw = new BufferedWriter(fw);
	         InputStreamReader isr = new InputStreamReader(System.in);
	         BufferedReader br = new BufferedReader(isr)) {

	        System.out.print("이름: ");
	        String name = br.readLine();
	        System.out.print("휴대전화: ");
	        String mobile = br.readLine();
	        System.out.print("회사번호: ");
	        String company = br.readLine();

	        bw.write(name + "," + mobile + "," + company);
	        bw.newLine();
	        System.out.println("연락처가 추가되었습니다.");

	    } catch (IOException e) {
	        System.err.println("파일을 찾을 수 없습니다.");
	        e.printStackTrace();
	    }
	}

	private static void deleteContact() {
		try (BufferedReader bfr = new BufferedReader(new FileReader(filename));
				BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".tmp"))) {

			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("<3.삭제>");
			System.out.print("번호: ");
			int lineNumberToDelete = Integer.parseInt(consoleReader.readLine());

			String line;
			int currentLineNumber = 1;
			boolean deleted = false;
			while ((line = bfr.readLine()) != null) {
				if (currentLineNumber != lineNumberToDelete) {
					bw.write(line);
					bw.newLine();
				} else {
					deleted = true;
				}
				currentLineNumber++;
			}

			if (!deleted) {
				System.out.println("해당 번호의 연락처를 찾을 수 없습니다.");
				return;
			}

		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		try {
			Files.move(Paths.get(filename + ".tmp"), Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void searchContact() {
		try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("검색할 이름: ");
			String name = scanner.nextLine();

			String line;
			int lineNumber = 0;
			boolean found = false;
			while ((line = bfr.readLine()) != null) {
				String[] parts = line.split(",");
				lineNumber++;
				if (parts[0].contains(name)) {
					System.out.println(lineNumber + "." + "이름:" + parts[0] + " 휴대전화:" + parts[1] + " 회사번호:" + parts[2]);

					found = true;
					continue;
				}
			}

			if (!found) {
				System.out.println("연락처를 찾을 수 없습니다.");
			}

		} catch (IOException e) {
			System.err.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}
	}
}
