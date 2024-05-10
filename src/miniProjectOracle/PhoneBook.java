package miniProjectOracle;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class PhoneBook {

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
				listPhoneBook();
				break;
			case "2":
				insertPhoneBook(scanner);
				break;
			case "3":
				deletePhoneBook(scanner);
				break;
			case "4":
				getPhoneBook(scanner);
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

	private static void listPhoneBook() {
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		List<PhoneBookVO> list = dao.getList();
		if (list.size() > 0) {
			// Iterator 순회
			Iterator<PhoneBookVO> it = list.iterator();
			
			while (it.hasNext()) {
				PhoneBookVO vo = it.next();
				System.out.printf("%d\t%s\t%s\t%s%n", vo.getId(), vo.getName(), vo.getHp(), vo.getTel());

			}
		} else {
			System.out.println("데이터가 없습니다.");
		}
		
	}
	
	private static void insertPhoneBook(Scanner scanner) {
		
		System.out.print("이름:");
		String name = scanner.nextLine();
		
		System.out.print("hp:");
		String hp = scanner.nextLine();

		System.out.print("tel:");
		String tel = scanner.nextLine();

		
		PhoneBookVO vo = new PhoneBookVO(name, hp, tel);
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean success = dao.insert(vo);
		System.out.println("INSERT " + (success ? "성공": "실패"));
		
	}
	
	private static void deletePhoneBook(Scanner scanner) {

		System.out.print("삭제할 레코드 ID:");
		Long id = Long.parseLong(scanner.nextLine());
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean success = dao.delete(id);
		
		System.out.println("DELETE " + (success ? "성공":"실패"));
	}
	
	private static void getPhoneBook(Scanner scanner) {

		System.out.print("레코드 ID:");
		Long id = Long.parseLong(scanner.nextLine());
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		PhoneBookVO vo = dao.get(id);
		
		if (vo != null) {
			System.out.printf("%d\t%s\t%s\t%s%n", vo.getId(), vo.getName(), vo.getHp(), vo.getTel());
		} else {
			System.out.println("레코드를 찾지 못했습니다.");
		}
		
	}
}
