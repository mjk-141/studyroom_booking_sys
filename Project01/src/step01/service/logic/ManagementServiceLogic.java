package step01.service.logic;

import java.util.Arrays;
import java.util.Iterator;

import step01.entity.StudyGroup;
import step01.service.ManagementService;

public class ManagementServiceLogic implements ManagementService {
	// StudyGroup을 저장할 배열 선언
	private StudyGroup[] groups;

	// 배열 인덱스 선언
	private int index;

	// 생성자
	public ManagementServiceLogic() {
		// 스터디 그룹을 저장할 배열 생성
		this.groups = new StudyGroup[6];
		this.index = 0;
	}

	// 스터디 그룹 등록
	@Override
	public void register(StudyGroup studyGroup) {
		// 매개변수로 받은 생성된 스터디그붕르 groups 배열에 저장
		groups[index] = studyGroup;
		index++;
	}

	// 등록된 스터디그룹 검색(전체)
	@Override
	public StudyGroup[] findAll() {
		/*
		 * groups 배열에 등록된 스터디그룹의 요소만큼 복사하여 반환 배열 복사 : Array.copyOfRange(원본배열,0,인덱스)
		 */
		return Arrays.copyOfRange(groups, 0, index);
	}

	@Override
	public StudyGroup findById(String studyId) {
		// 등록된 스터디그룹들만 뽑아내서 registeredGroups 배열에 할당(배열에서 0부터 index까지 복사)
		StudyGroup[] registeredGroups = Arrays.copyOfRange(groups, 0, index);

		// Id로 찾은 스터디그룹을 저장할 참조변수
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
		// 등록된 스터디그룹들만 뽑아내서 registeredGroups 배열에 할당(배열에서 0부터 index까지 복사)
		StudyGroup[] registeredGroups = Arrays.copyOfRange(groups, 0, index);

		// Name로 찾은 스터디그룹을 저장할 참조변수
		StudyGroup[] findGroups = new StudyGroup[registeredGroups.length];

		// findGroups 배열의 index
		int subIndex = 0;

		// StudyName과 같은 스터디그룹을 모두 찾아 findGroups 배열에 저장
		for (StudyGroup group : registeredGroups) {
			if (group.getName().equals(studyName)) {
				findGroups[subIndex] = group;
				subIndex++;
			}
		}

		/*
		 * studyName으로 검색한 스터디그룹들이 저장된 findGroups 배열에서 스터디 그룹 NAme이 저장된 요소만 복사하여 반환
		 * - NULL제외
		 * 
		 */
		return Arrays.copyOfRange(findGroups, 0, subIndex);

	}

	//등록된 StudyGroup 수정(modifyGroup(StudyGroupManagement에서 수정된 스터디그룹)
	@Override
	public void modify(StudyGroup modifyGroup) {
		/* 수정된 스터디그룹(modifyGroup)을 매개변수로 받아 StudyGroup[] 타입의
		 * 원본 배열(groups)에서 해당 id를 찾아 수정된 modifyGroup로 변경
		 */
		int modifyIndex=0;
		
		//원본 배열(groups)에서 수정할 스터디그룹의 인덱스(modifyIndex)를 찾음
		for (int i = 0; i < groups.length; i++) {
			if (groups[i].getId().equals(modifyGroup.getId())) {
				modifyIndex=1;
				break;
			}
		}
		/* 스터디그룹 원본 배열(groups)의 modifyIndex 해당하는 요소에
		 * 수정된 스터디 그룹(modifyGroup)을 저장*/
		this.groups[modifyIndex]=modifyGroup;
	}

	@Override
	public void remove(String studyId) {
		//삭제할 studyId를 매개변수로 받아 원본 배열(groups)에서 삭제할 id의 인덱스(removeIndex)
		int removeIndex=0;
		
		//원본 배열(groups)에서 삭제할 스터디그룹의 인덱스(removeIndex)를 찾음
		for (int i = 0; i < groups.length; i++) {
			if (groups[i].getId().equals(studyId)) {
				removeIndex=1;
				break;
			}
		}
		/* 원본 배열(groups)에서 삭제할 removeIndex에 해당하는 요소(groups[i])에
		 * 다음 요소(groups[i+1])에 있는 스터디그룹 객체의 참조변수를 저장하는 방식으로
		 * removeIndex에 해당하는 스터디그룹을 삭제
		 */
		for (int i = removeIndex; i < this.index+1; i++) {
			groups[i]=groups[i+1];
		}
		
		/* this.index는 스터디그룹이 생성될때 마다 1씩 증가하기 때문에
		 * 스터디그룹이 삭제될 때마다 1씩 감소시켜야 함
		 */
		this.index--;
	}
}
