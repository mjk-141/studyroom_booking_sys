 package step01.util;

import java.util.Scanner;

//사용자로부터 입력받은 작업을 수행하는 클래스
public class InputUtil {
	private Scanner scanner;
	public InputUtil() {
		this.scanner = new Scanner(System.in);
	}
	
	//입력값을 반환하는 메소드
	public String getValue(String string) {
		
		System.out.print(string + ": "); //>그룹 Name(0.홈으로): 
		
		//키보드로 입력한 문자열 전체를 가져오기
		String inputStr = scanner.nextLine();
		inputStr = inputStr.trim(); //CR, 공백 제거
		
		//입력값 반환
		return inputStr;
	}

}
