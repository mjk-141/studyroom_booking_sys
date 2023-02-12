package step01.service;

import step01.entity.StudyGroup;

public interface ManagementService {
	//스터디 그룹 등록 메소드
	abstract void register(StudyGroup studyGroup);
	//전체 스터디 그룹을 배열로 반환하는 메소드
	
	abstract StudyGroup[] findAll();

	//id로 스터디그룹을 찾아 배열로 반환하는 메소드
	abstract StudyGroup findById(String studyId);

	//이름으로 스터디그룹을 찾아 배열로 반환하는 메소드
	abstract StudyGroup[] findByName(String studyName);

	//스터디그룹 수정 메소드
	abstract void modify(StudyGroup modifyGroup);

	//스터디 그룹 삭제 메소드
	abstract void remove(String studyId);
}