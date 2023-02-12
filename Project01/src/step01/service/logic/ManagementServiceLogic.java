package step01.service.logic;

import java.util.Arrays;
import java.util.Iterator;

import step01.entity.StudyGroup;
import step01.service.ManagementService;

public class ManagementServiceLogic implements ManagementService {
	// StudyGroup�� ������ �迭 ����
	private StudyGroup[] groups;

	// �迭 �ε��� ����
	private int index;

	// ������
	public ManagementServiceLogic() {
		// ���͵� �׷��� ������ �迭 ����
		this.groups = new StudyGroup[6];
		this.index = 0;
	}

	// ���͵� �׷� ���
	@Override
	public void register(StudyGroup studyGroup) {
		// �Ű������� ���� ������ ���͵�׺ظ� groups �迭�� ����
		groups[index] = studyGroup;
		index++;
	}

	// ��ϵ� ���͵�׷� �˻�(��ü)
	@Override
	public StudyGroup[] findAll() {
		/*
		 * groups �迭�� ��ϵ� ���͵�׷��� ��Ҹ�ŭ �����Ͽ� ��ȯ �迭 ���� : Array.copyOfRange(�����迭,0,�ε���)
		 */
		return Arrays.copyOfRange(groups, 0, index);
	}

	@Override
	public StudyGroup findById(String studyId) {
		// ��ϵ� ���͵�׷�鸸 �̾Ƴ��� registeredGroups �迭�� �Ҵ�(�迭���� 0���� index���� ����)
		StudyGroup[] registeredGroups = Arrays.copyOfRange(groups, 0, index);

		// Id�� ã�� ���͵�׷��� ������ ��������
		StudyGroup findGroup = null;

		for (StudyGroup group : registeredGroups) {
			if (group.getId().equals(studyId)) {
				findGroup = group;
				break;
			}
		}
		return findGroup;
	}

	@Override
	public StudyGroup[] findByName(String studyName) {
		// ��ϵ� ���͵�׷�鸸 �̾Ƴ��� registeredGroups �迭�� �Ҵ�(�迭���� 0���� index���� ����)
		StudyGroup[] registeredGroups = Arrays.copyOfRange(groups, 0, index);

		// Name�� ã�� ���͵�׷��� ������ ��������
		StudyGroup[] findGroups = new StudyGroup[registeredGroups.length];

		// findGroups �迭�� index
		int subIndex = 0;

		// StudyName�� ���� ���͵�׷��� ��� ã�� findGroups �迭�� ����
		for (StudyGroup group : registeredGroups) {
			if (group.getName().equals(studyName)) {
				findGroups[subIndex] = group;
				subIndex++;
			}
		}

		/*
		 * studyName���� �˻��� ���͵�׷���� ����� findGroups �迭���� ���͵� �׷� NAme�� ����� ��Ҹ� �����Ͽ� ��ȯ
		 * - NULL����
		 * 
		 */
		return Arrays.copyOfRange(findGroups, 0, subIndex);

	}

	//��ϵ� StudyGroup ����(modifyGroup(StudyGroupManagement���� ������ ���͵�׷�)
	@Override
	public void modify(StudyGroup modifyGroup) {
		/* ������ ���͵�׷�(modifyGroup)�� �Ű������� �޾� StudyGroup[] Ÿ����
		 * ���� �迭(groups)���� �ش� id�� ã�� ������ modifyGroup�� ����
		 */
		int modifyIndex=0;
		
		//���� �迭(groups)���� ������ ���͵�׷��� �ε���(modifyIndex)�� ã��
		for (int i = 0; i < groups.length; i++) {
			if (groups[i].getId().equals(modifyGroup.getId())) {
				modifyIndex=1;
				break;
			}
		}
		/* ���͵�׷� ���� �迭(groups)�� modifyIndex �ش��ϴ� ��ҿ�
		 * ������ ���͵� �׷�(modifyGroup)�� ����*/
		this.groups[modifyIndex]=modifyGroup;
	}

	@Override
	public void remove(String studyId) {
		//������ studyId�� �Ű������� �޾� ���� �迭(groups)���� ������ id�� �ε���(removeIndex)
		int removeIndex=0;
		
		//���� �迭(groups)���� ������ ���͵�׷��� �ε���(removeIndex)�� ã��
		for (int i = 0; i < groups.length; i++) {
			if (groups[i].getId().equals(studyId)) {
				removeIndex=1;
				break;
			}
		}
		/* ���� �迭(groups)���� ������ removeIndex�� �ش��ϴ� ���(groups[i])��
		 * ���� ���(groups[i+1])�� �ִ� ���͵�׷� ��ü�� ���������� �����ϴ� �������
		 * removeIndex�� �ش��ϴ� ���͵�׷��� ����
		 */
		for (int i = removeIndex; i < this.index+1; i++) {
			groups[i]=groups[i+1];
		}
		
		/* this.index�� ���͵�׷��� �����ɶ� ���� 1�� �����ϱ� ������
		 * ���͵�׷��� ������ ������ 1�� ���ҽ��Ѿ� ��
		 */
		this.index--;
	}
}
