package miniProjectList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Contact {
	private String name;
	private String mobile;
	private String company;

	public Contact(String name, String mobile, String company) {
		this.name = name;
		this.mobile = mobile;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getCompany() {
		return company;
	}
}

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
				addContact(scanner);
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

	private static List<Contact> readContacts() {
		List<Contact> contacts = new ArrayList<>();
		try (FileReader fr = new FileReader(filename); BufferedReader br = new BufferedReader(fr);) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				contacts.add(new Contact(parts[0], parts[1], parts[2]));
			}
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	private static void showContact() {
		List<Contact> contacts = readContacts();

		Iterator<Contact> iterator = contacts.iterator();
		int lineNumber = 1;
		while (iterator.hasNext()) {
			Contact contact = iterator.next();
			System.out.println(
					lineNumber + ". " + contact.getName() + " " + contact.getMobile() + " " + contact.getCompany());

			lineNumber++;
		}
	}

	private static void addContact(Scanner scanner) {
		try (
				// 파일에 연락처를 추가하기 위해 FileWriter와 BufferedWriter를 사용합니다.
				FileWriter fw = new FileWriter(filename, true);
				BufferedWriter bw = new BufferedWriter(fw);) {
			// 사용자로부터 이름, 휴대전화번호, 회사번호를 입력받습니다.
			System.out.print("이름: ");
			String name = scanner.nextLine();
			System.out.print("휴대전화: ");
			String mobile = scanner.nextLine();
			System.out.print("회사번호: ");
			String company = scanner.nextLine();

			// 파일에 연락처를 추가합니다.
			bw.write(name + "," + mobile + "," + company);
			bw.newLine();
			System.out.println("연락처가 추가되었습니다.");

	
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteContact(Scanner scanner) {
		List<Contact> contacts = readContacts();

		try (FileWriter fw = new FileWriter(filename); BufferedWriter bw = new BufferedWriter(fw);) {
			System.out.println("<3.삭제>");
			System.out.print("번호: ");
			int deleteLine = Integer.parseInt(scanner.nextLine());

			// 삭제할 연락처를 제외하고 나머지 연락처를 파일에 씁니다.
			Iterator<Contact> iterator = contacts.iterator();
			int lineNumber = 1;
			while (iterator.hasNext()) {
				Contact contact = iterator.next();
//			for (Contact contact : contacts) {
				if (lineNumber != deleteLine) {
					bw.write(contact.getName() + "," + contact.getMobile() + "," + contact.getCompany());
					bw.newLine();
				}
				lineNumber++;
			}

			System.out.println("연락처가 삭제되었습니다.");
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void searchContact(Scanner scanner) {
		List<Contact> contacts = readContacts();


		System.out.print("검색할 이름: ");
		String name = scanner.nextLine();

		Iterator<Contact> iterator = contacts.iterator();
		int lineNumber = 1;
		while (iterator.hasNext()) {
			Contact contact = iterator.next();
			if (contact.getName().contains(name)) {
				System.out.println(
						lineNumber + ". " + contact.getName() + " " + contact.getMobile() + " " + contact.getCompany());
			}
			lineNumber++;
		}
	}
	
}
