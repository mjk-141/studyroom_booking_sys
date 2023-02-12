package step01.view;

import java.util.Scanner;

import step01.controller.StudyGroupManagement;
import step01.entity.StudyGroup;

//���͵� �׷� ����(���, ��ȸ, ����, ����)�� ���� �޴� Ŭ����
public class StudyGroupMenu {
	//��ĳ�� ��ü �������� ����
	Scanner scanner;
	
	/* ���͵� �׷��� ����(���, ��ȸ, ����, ����)�ϴ� StudyGroupMAnagement ��ü ���� ���� ����
	 * */
	private StudyGroupManagement manage;
	
	//������
	public StudyGroupMenu() {
		this.scanner = new Scanner(System.in);
		
		//���͵� �׷��� ����(���,��ȸ,���� ,����)�ϴ� StudyGroupManageMent ��ü ����
		this.manage = new StudyGroupManagement();
	}
	
	/* �޴����� �۾��� �����ϰ� �ش� ������ �����ϴ� �޼ҵ带 ȣ��
	 * 1. �۾� Menu ���, �۾� ����
	 * 2. �ش� �۾��� �����ϴ� �޼ҵ� ȣ��
	 * */
	public void showMenu() {
		//������ �۾� �޴� ��ȣ
		int selectNum = 0;
		while(true) {
			//�޴��� ȭ�鿡 ���
			displayMenu();
			//������ �۾��޴��� ��������
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
				System.out.println("�۾��� �����մϴ�.");
				break;
			default:
				System.out.println(">��ȣ�� �ٽ� �Է��ϼ���");
			}
		}
	}
	
	//Menu��� �޼ҵ�
	private void displayMenu() {
		System.out.println("..............................");
		System.out.println("[���͵�׷� HOME] �޴��� �����ϼ���");
		System.out.println("..............................");
		System.out.println("[1] ���");
		System.out.println("[2] �˻�(ALL)");
		System.out.println("[3] �˻�(ID)");
		System.out.println("[4] �˻�(NAME)");
		System.out.println("[5] ����(ID)");
		System.out.println("[6] ����(ID)");
		System.out.println("..............................");
		System.out.println("[0] ����");
		System.out.println("..............................");
	}
	
	//�۾� ���� �޼ҵ�
	private int selectMenu() {
		System.out.print("Select : ");
		int menuNum = scanner.nextInt();
		
		if (menuNum >=0 && menuNum<=6) {
			scanner.nextLine(); //���� Clear(Scanner�� ���� �� �ʿ� �ϴ�.)
			return menuNum;
		} else {
			System.out.println("�Է� ��ȣ�� Ȯ�ιٶ��ϴ�: " + menuNum);
			return -1;
		}
	}
}
