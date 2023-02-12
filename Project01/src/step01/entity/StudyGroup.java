package step01.entity;

import java.util.UUID;

import step01.util.DateUtil;

public class StudyGroup {
	private static final int MIN_NAME_LENGTH = 2;
	private static final int MIN_TOPIC_LENGTH = 5;

	// �ʵ�
	private String id; // ���̵�(����ID)
	private String name; // ���͵�׷� �̸�
	private String topic; // ���͵� ����
	private String period; // ���͵� �Ⱓ
	private String room; // ���͵� ��
	private String foundationDay; // ���(����)��

	// ������
	private StudyGroup() {
		/* UUID ������ �ĺ��ڸ� ����� �ִ� Ŭ����
		 * UUID�� 128 bit ���ڷ�, UUID Ŭ������ randomUUID()�޼ҵ带 ��뤾���� ������ �ĺ��ڸ� �����Ͽ� ���ڿ��� ��ȯ�Ͽ� ����
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
			System.out.println("GroupName�� 2�ڸ� �̻��Դϴ�");
			return; //������ �������ҽ� ������������ �Ѵ�. ������ �ۼ��ϱ�
		}
		this.name = name;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		if(topic.length()<MIN_TOPIC_LENGTH) {
			System.out.println("topic�� 5�ڸ� �̻��Դϴ�");
			return; //������ �������ҽ� ������������ �Ѵ�. ������ �ۼ��ϱ�
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
		builder .append("[���͵� �׷� ����]");
		builder .append("\n------------------------------");
		builder .append("\n * ���̵�: ").append(id);
		builder .append("\n * ���͵��: ").append(name);
		builder .append("\n * ���͵�����: ").append(topic);
		builder .append("\n * ���͵�Ⱓ: ").append(period);
		builder .append("\n * ���͵����: ").append(room);
		builder .append("\n * �����: ").append(foundationDay);
		
		return builder.toString(); 
	}
	
	
	
}
