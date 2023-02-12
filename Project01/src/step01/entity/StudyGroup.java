package step01.entity;

import java.util.UUID;

import step01.util.DateUtil;

public class StudyGroup {
	private static final int MIN_NAME_LENGTH = 2;
	private static final int MIN_TOPIC_LENGTH = 5;

	// 필드
	private String id; // 아이디(고유ID)
	private String name; // 스터디그룹 이름
	private String topic; // 스터디 주제
	private String period; // 스터디 기간
	private String room; // 스터디 룸
	private String foundationDay; // 등록(개설)일

	// 생성자
	private StudyGroup() {
		/* UUID 고유한 식별자를 만들어 주는 클래스
		 * UUID는 128 bit 숫자로, UUID 클래스의 randomUUID()메소드를 사용ㅎ새ㅓ 유일한 식별자를 생성하여 문자열로 변환하여 저장
		 */
		this.id = UUID.randomUUID().toString();
	}

	public StudyGroup(String name, String topic, String period, String room) {
		this();
		setName(name);
		setTopic(topic);
		this.period = period;
		this.room = room;
		this.foundationDay = DateUtil.toDay();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length()<MIN_NAME_LENGTH) {
			System.out.println("GroupName은 2자리 이상입니다");
			return; //조건을 충족안할시 빠져나오도록 한다. 무조건 작성하기
		}
		this.name = name;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		if(topic.length()<MIN_TOPIC_LENGTH) {
			System.out.println("topic은 5자리 이상입니다");
			return; //조건을 충족안할시 빠져나오도록 한다. 무조건 작성하기
		}
		this.topic=topic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder .append("[스터디 그룹 정보]");
		builder .append("\n------------------------------");
		builder .append("\n * 아이디: ").append(id);
		builder .append("\n * 스터디명: ").append(name);
		builder .append("\n * 스터디주제: ").append(topic);
		builder .append("\n * 스터디기간: ").append(period);
		builder .append("\n * 스터디장소: ").append(room);
		builder .append("\n * 등록일: ").append(foundationDay);
		
		return builder.toString(); 
	}
	
	
	
}
