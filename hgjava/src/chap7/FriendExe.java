package chap7;

public class FriendExe {
	Friend[] storage = new Friend[10];

	// 새로 짜보기
	// 1:등록 2:목록 3조회
	public boolean addFriend(Friend friend) {
		return false;
	}

	public Friend[] friendList() {
		return null;
	}

	// 결과값이 null여부로 체크(X)
	public Friend[] searchFriend(String name) {
		// 반환유형이 정해져있음.
		Friend[] result = new Friend[10];
		return result;
	}

	// 결과값이 null여부로 체크.
	public Friend searchPhone(String phone) {
		return null;
	}
}
