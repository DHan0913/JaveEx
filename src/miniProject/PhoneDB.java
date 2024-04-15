package miniProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
		boolean a = true;
		while (a == true) {

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
				deleteContact(scanner);
				break;
			case "4":
				searchContact(scanner);
				break;
			case "5":
				System.out.println("감사합니다.");
				a = false;
				break;
			default:
				System.out.println("올바른 선택이 아닙니다. 다시 선택하세요.");
			}
			
		}
		scanner.close();
	}

	private static void showContact() {
		try (FileReader fr = new FileReader(filename); BufferedReader br = new BufferedReader(fr);) {
			String line;
			int lineNumber = 1;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				String mobile = parts[1];
				String company = parts[2];

				System.out.println(lineNumber + ". " + name + " " + mobile + " " + company);

				lineNumber++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addContact() {
		try (
				// 파일에 연락처를 추가하기 위해 FileWriter와 BufferedWriter를 사용합니다.
				FileWriter fw = new FileWriter(filename, true);
				BufferedWriter bw = new BufferedWriter(fw);) {
			// 사용자로부터 이름, 휴대전화번호, 회사번호를 입력받습니다.
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.print("이름: ");
			String name = br.readLine();
			System.out.print("휴대전화: ");
			String mobile = br.readLine();
			System.out.print("회사번호: ");
			String company = br.readLine();

			// 파일에 연락처를 추가합니다.
			bw.write(name + "," + mobile + "," + company);
			bw.newLine();
			System.out.println("연락처가 추가되었습니다.");

			// 파일을 닫습니다.
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteContact(Scanner scanner) {
		try (FileWriter fw = new FileWriter(filename + ".tmp");
				FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw);) {

			System.out.println("<3.삭제>");
			System.out.print("번호: ");
			int deleteLine = Integer.parseInt(scanner.nextLine());

			String line;
			int lineNumber = 1;
			while ((line = br.readLine()) != null) {
				// 삭제할 줄이 아닌 경우에만 파일에 쓰기
				if (lineNumber != deleteLine) {
					bw.write(line);
					bw.newLine();
				}
				lineNumber++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 임시 파일로부터 데이터를 다시 원본 파일로 복사
		try {
			Files.copy(Paths.get(filename + ".tmp"), Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
			// 임시 파일 삭제
			Files.delete(Paths.get(filename + ".tmp"));
			System.out.println("연락처가 삭제되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void searchContact(Scanner scanner) {
		try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {

			System.out.print("검색할 이름: ");
			String name = scanner.nextLine();

			String line;
			int lineNumber = 0;
			while ((line = bfr.readLine()) != null) {
				String[] parts = line.split(",");
				lineNumber++;
				if (parts[0].contains(name)) {
					System.out.println(lineNumber + "." + "이름:" + parts[0] + " 휴대전화:" + parts[1] + " 회사번호:" + parts[2]);
					continue;
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
