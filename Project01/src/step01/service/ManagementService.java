package step01.service;

import step01.entity.StudyGroup;

public interface ManagementService {
	//���͵� �׷� ��� �޼ҵ�
	abstract void register(StudyGroup studyGroup);
	//��ü ���͵� �׷��� �迭�� ��ȯ�ϴ� �޼ҵ�
	
	abstract StudyGroup[] findAll();

	//id�� ���͵�׷��� ã�� �迭�� ��ȯ�ϴ� �޼ҵ�
	abstract StudyGroup findById(String studyId);

	//�̸����� ���͵�׷��� ã�� �迭�� ��ȯ�ϴ� �޼ҵ�
	abstract StudyGroup[] findByName(String studyName);

	//���͵�׷� ���� �޼ҵ�
	abstract void modify(StudyGroup modifyGroup);

	//���͵� �׷� ���� �޼ҵ�
	abstract void remove(String studyId);
}