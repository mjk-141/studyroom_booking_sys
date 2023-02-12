package step01.view;

import java.util.Scanner;

import step01.controller.StudyGroupManagement;
import step01.entity.StudyGroup;

//스터디 그룹 관리(등록, 조회, 수정, 삭제)를 위한 메뉴 클래스
public class StudyGroupMenu {
	//스캐너 객체 참조변수 선언
	Scanner scanner;
	
	/* 스터디 그룹을 관리(등록, 조회, 수정, 삭제)하는 StudyGroupMAnagement 객체 참조 변수 선언
	 * */
	private StudyGroupManagement manage;
	
	//생성자
	public StudyGroupMenu() {
		this.scanner = new Scanner(System.in);
		
		//스터디 그룹을 관리(등록,조회,수정 ,삭제)하는 StudyGroupManageMent 객체 생성
		this.manage = new StudyGroupManagement();
	}
	
	/* 메뉴에서 작업을 선택하고 해당 작읍을 수행하는 메소드를 호출
	 * 1. 작업 Menu 출력, 작업 선택
	 * 2. 해당 작업을 수행하는 메소드 호출
	 * */
	public void showMenu() {
		//선택한 작업 메뉴 번호
		int selectNum = 0;
		while(true) {
			//메뉴를 화면에 출력
			displayMenu();
			//선택한 작업메뉴를 가져오기
			selectNum = selectMenu();
			
			switch (selectNum) {
			case 1:
				manage.register();
				break;
			case 2:
				manage.findALL();
				break;
			case 3:
				manage.findById();
				break;
			case 4:
				manage.findByName();
				break;
			case 5:
				manage.modify();
				break;
			case 6:
				manage.remove();
				break;
			case 0:
				System.out.println("작업을 종료합니다.");
				break;
			default:
				System.out.println(">번호를 다시 입력하세요");
			}
		}
	}
	
	//Menu출력 메소드
	private void displayMenu() {
		System.out.println("..............................");
		System.out.println("[스터디그룹 HOME] 메뉴를 선택하세요");
		System.out.println("..............................");
		System.out.println("[1] 등록");
		System.out.println("[2] 검색(ALL)");
		System.out.println("[3] 검색(ID)");
		System.out.println("[4] 검색(NAME)");
		System.out.println("[5] 수정(ID)");
		System.out.println("[6] 삭제(ID)");
		System.out.println("..............................");
		System.out.println("[0] 종료");
		System.out.println("..............................");
	}
	
	//작업 선택 메소드
	private int selectMenu() {
		System.out.print("Select : ");
		int menuNum = scanner.nextInt();
		
		if (menuNum >=0 && menuNum<=6) {
			scanner.nextLine(); //버퍼 Clear(Scanner을 쓸때 꼭 필요 하다.)
			return menuNum;
		} else {
			System.out.println("입력 번호를 확인바랍니다: " + menuNum);
			return -1;
		}
	}
}
