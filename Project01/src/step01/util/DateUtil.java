package step01.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//스터디그룹 등록일(foundationDay) 생성 클래스
public class DateUtil {
	//날짜 정보를 파싱하여 원하는 포멧으로  날짜 출력
	public static String toDay(String format) {
		//simpleDateFormat 객체 생성
		//파싱할 날짜 문자열 포멧을 생성자 인자로 전달
		SimpleDateFormat dateFormate = new SimpleDateFormat(format);
		//Calendar 클래스의 getInstance를 통해 현재 날짜와 시간을 가져와서 포멧
		return dateFormate.format(Calendar.getInstance().getTime());
	}
	//날짜 포멧 문자열을 전달하는 메서드
	public static String toDay() {
		return toDay("yyyy.MM.dd a HH:mm:ss"); // 첫번째 toDay 반환
	}

}
