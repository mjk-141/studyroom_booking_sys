package step01.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//���͵�׷� �����(foundationDay) ���� Ŭ����
public class DateUtil {
	//��¥ ������ �Ľ��Ͽ� ���ϴ� ��������  ��¥ ���
	public static String toDay(String format) {
		//simpleDateFormat ��ü ����
		//�Ľ��� ��¥ ���ڿ� ������ ������ ���ڷ� ����
		SimpleDateFormat dateFormate = new SimpleDateFormat(format);
		//Calendar Ŭ������ getInstance�� ���� ���� ��¥�� �ð��� �����ͼ� ����
		return dateFormate.format(Calendar.getInstance().getTime());
	}
	//��¥ ���� ���ڿ��� �����ϴ� �޼���
	public static String toDay() {
		return toDay("yyyy.MM.dd a HH:mm:ss"); // ù��° toDay ��ȯ
	}

}
