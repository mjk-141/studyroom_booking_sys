package step01.controller;

import java.util.Iterator;

import step01.entity.StudyGroup;
import step01.service.ManagementService;
import step01.service.logic.ManagementServiceLogic;
import step01.util.InputUtil;

//스터디그룹 등록,조회,수정,삭제 작업 수행 클래스
public class StudyGroupManagement {

	// 입력작업을 진행할 InputUtil 객체 필드 선언
	private InputUtil inputUtil;

	// ManageMentService 인터페이스 타입의 참조 변수 선언
	private ManagementService managementService;

	public StudyGroupManagement() {
		// 입력작업을 진행할 InputUtil 객체 생성
		this.inputUtil = new InputUtil();

		/*
		 * ManagemetService 필드 초기화 ManagemetService 인터페이스를 구현한 ManagemetServiceLogic()
		 * 객체 생성 ManagemetService 인터페이스 타입의 참조 변수에 구현 객체 저장(Up-casting)
		 */
		this.managementService = new ManagementServiceLogic();
	}

	// 스터디 그룹 등록
	public void register() {
		System.out.println("[등록 작업]");
		System.out.println("============================================");
		/*
		 * 스터디 그룹에 필요한 name,topic,period,room 필드값을 입력 받아 객체를 생성한 후, 배열에 저장을
		 * ManagemetService 인터페이스를 통해 ManagemetServiceLogic 에 요청
		 */

		while (true) {
			/*
			 * 사용자로부터 필드 값을 입력받음 입력작업은 InputUtil 객체의 getValue()메소드 이용
			 */
			// 스터디명
			String name = inputUtil.getValue(">스터디 Name (0,홉으로)");
			if (name.equals("0")) {
				return;
			}
			// 스터디 주제
			String topic = inputUtil.getValue(">스터디 Topic (0,홉으로)");
			if (topic.equals("0")) {
				return;
			}
			// 스터디 기간
			String period = inputUtil.getValue(">스터디 period (0,홉으로)");
			if (period.equals("0")) {
				return;
			}
			// 스터디 방
			String Room = inputUtil.getValue(">스터디 Room (0,홉으로)");
			if (Room.equals("0")) {
				return;
			}

			String save = inputUtil.getValue(">등록하시겠습니까?(9.등록, 0.홈으로)");
			if (save.equals("9")) {
				StudyGroup newGroup = new StudyGroup(name, topic, period, Room);
				/*
				 * ManagemetService 인터페이스에게 생성된 스터디그룹을 배열에 저장할것을 요청 ManagementService 인터페이스를 구현한
				 * ManagementServiceLogic 객체 의 register() 메소드를 이용해 생성한 스터디그룹을 배열에 저장
				 */
				managementService.register(newGroup);

				System.out.println("===================================");
				System.out.println(">>스터디그룹 등록 : " + newGroup.toString());
				System.out.println("===================================");

			} else {
				System.out.println(">>스터디그룹 등록을 취소했습니다...");
				return;
			}

		}
	}

	public void findALL() {
		System.out.println("검색 전체");
		/*
		 * ManagementService 인터페이스에 스터디 그룹 전체를 검색할 것을 요청(FindALL()호출)하여 반환값을 findGroups에
		 * 저장
		 */
		StudyGroup[] findGroups = managementService.findAll();

		// 등록된 스터디 그룹이 없으면 종료
		if (findGroups.length == 0) {
			System.out.println("등록된 스터디 그룹이 없습니다");
			return;
		} else {
			// 검색한 스터디그룹 출력
			for (StudyGroup group : findGroups) {
				System.out.println(">>스터디그룹 조회(전쳬):" + group.toString());
			}
		}

	}

	public void findByName() {
		System.out.println("검색(Name) 작업");

		/*
		 * 검색한 스터디그룹을 저장할 StudyGroup[] 타입의 배열 findGroups 선언 - 스터디그룹명을 동일한 것이 있을수 있기에 배열로
		 * 선언
		 */
		StudyGroup[] findGroups = null;

		// id로 스터디그룹을 검색할 반복문
		while (true) {
			// inputUtil.getValue를 이용해서 사용자로부터 검색할 id를 받음
			String studyName = inputUtil.getValue(">스터디 Name(0.홈으로)");
			if (studyName.equals("0")) {
				break;
			}

			/*
			 * studyName으로 스터디그룹 검색을 ManagementService 인터페이스에 요청하여 반환값을 findGroup에 저장
			 */
			findGroups = managementService.findByName(studyName);

			// 스터디 그룹을 찾았으면
			if (findGroups != null && findGroups.length != 0) {
				for (StudyGroup group : findGroups) {
					System.out.println(">>스터디 그룹 조회 (Name):" + group.toString());
				}
			} else {
				System.out.println("해당 Name의 스터디그룹이 없습니다. : " + studyName);
			}

		}
	}

	// 수정(등록된 스터디그룹 name,topic,period,room 수정) -id
	public void modify() {
		System.out.println("수정 작업");

		//findByOne()을 통해 수정할 스터디그룹을 찾아 targetGroup에 저장
		StudyGroup targetGroup = findByOne();

		// 수정할 스터디명
		String name = inputUtil.getValue(">스터디 Name (0.홈으로, Enter:수정안함)");
		if (name.equals("0")) {
			return;
		}

		// 스터디명 수정
		if (!name.isEmpty()) {
			targetGroup.setName(name);
		}

		// 스터디 주제
		String topic = inputUtil.getValue(">스터디 Topic (0.홈으로, Enter:수정안함)");
		if (topic.equals("0")) {
			return;
		}

		// 스터디주제(Topic) 수정
		if (!topic.isEmpty()) {
			targetGroup.setTopic(topic);
		}

		// 스터디 기간
		String period = inputUtil.getValue(">스터디 Period (0.홈으로, Enter:수정안함)");
		if (period.equals("0")) {
			return;
		}

		// 스터디기간(Period) 수정
		if (!period.isEmpty()) {
			targetGroup.setPeriod(period);
		}

		// 스터디 공부방
		String Room = inputUtil.getValue(">스터디 Room (0.홈으로, Enter:수정안함)");
		if (Room.equals("0")) {
			return;
		}

		// 스터디 공부방 수정
		if (!Room.isEmpty()) {
			targetGroup.setRoom(Room);
		}
		
		/* ManagemetService 인터페이스에게 수정된 스터디그룹을 배열에 저장할 것을 요청
		 * - ManagementService 인터페이스를 구현한 ManagementServiceLogic 객체의
		 * 	 modify() 메소드를 이용해 수정한 스터디 그룹(targetGroup)을 배열에 저장
		 */
		
		managementService.modify(targetGroup);
		
		System.out.println(">>스터디그룹 수정: "+targetGroup.toString());
		
	}

	// 수정(modify) 및 삭제(remove)에서 사용할 스터디그룹(findGroup)을 StudyId로 찾아주는 메소드
	private StudyGroup findByOne() {
		// 검색한 스터디그룹을 저장할 findGroup 필드 선언
		StudyGroup findGroup = null;

		while (true) {
			String studyId = inputUtil.getValue(">수정 또는 삭제할 스터디그룹 Id (0.홈으로)");
			if (studyId.equals("0")) {
				break;
			}
			/*
			 * StudyId로 스터디그룹 검색을 ManagemetService 인터페이스에 요청하여 반환값을 findGroup에 저장
			 */
			findGroup = managementService.findById(studyId);
			
			if (findGroup != null) {
				break;
			} else {
				System.out.println("해당 Id의 클럽이 없습니다.: " + studyId);
			}

		}

		// 수정 또는 삭제할 스터디 그룹 반환
		return findGroup;
	}

	public void remove() {
		System.out.println("삭제 작업");
		
		//findByOne()을 통해 삭제할 스터디그룹을 찾아 targetGroup에 저장
		StudyGroup targetGroup = findByOne();
		
		//삭제 유무를 확인(y/n)하여 입력값을 confirm에 저장
		String confirm = inputUtil.getValue(">>스터디그룹을 삭제하시겠습니까?(Y/N)");
		
		if (confirm.toLowerCase().equals("y")) {
			System.out.println("==> ["+targetGroup.getName()+"] 스터디그룹이 삭제됩니다.");
			
			//manageMentService 인터페이스를 통해 해당 Id를 배열에서 삭제할 것을 요청
			managementService.remove(targetGroup.getId());
		} else {
			System.out.println(">>스터디그룹 삭제 취소: "+targetGroup.getName());
		}
	}

	public void findById() {
		System.out.println("검색(ID) 작업");
		// 검색한 스터디그룹을 저장할 findGroup 필드 선언
		StudyGroup findGroup = null;

		// id로 스터디그룹을 검색할 반복문
		while (true) {
			// inputUtil.getValue를 이용해서 사용자로부터 검색할 id를 받음
			String studyId = inputUtil.getValue(">스터디 Id(0.홈으로)");
			if (studyId.equals("0")) {
				break;
			}

			/*
			 * studyId로 스터디그룹 검색을 ManagementService 인터페이스에 요청하여 반환값을 findGroup에 저장
			 */
			findGroup = managementService.findById(studyId);

			if (findGroup != null) {
				System.out.println(">>스터디 그룹 조회 (Id):" + findGroup.toString());
			} else {
				System.out.println("해당 Id의 스터디그룹이 없습니다. : " + studyId);
			}

		}
	}

}
