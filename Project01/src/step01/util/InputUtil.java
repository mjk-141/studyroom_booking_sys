 package step01.util;

import java.util.Scanner;

//����ڷκ��� �Է¹��� �۾��� �����ϴ� Ŭ����
public class InputUtil {
	private Scanner scanner;
	public InputUtil() {
		this.scanner = new Scanner(System.in);
	}
	
	//�Է°��� ��ȯ�ϴ� �޼ҵ�
	public String getValue(String string) {
		
		System.out.print(string + ": "); //>�׷� Name(0.Ȩ����): 
		
		//Ű����� �Է��� ���ڿ� ��ü�� ��������
		String inputStr = scanner.nextLine();
		inputStr = inputStr.trim(); //CR, ���� ����
		
		//�Է°� ��ȯ
		return inputStr;
	}

}
