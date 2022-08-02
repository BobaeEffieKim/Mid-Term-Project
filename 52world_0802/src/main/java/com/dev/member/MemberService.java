package com.dev.member;

public class MemberService {

	MemberDAO dao = new MemberDAO();
	
	private static MemberService instance = null;
	private MemberService() {}
	public static MemberService getInstance() {
		if(instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	public void addMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	public MemberVO searchMember(String id) {
		return dao.searchMember(id);
	}
	
	public int tryLogin(String id, String password) {
		return dao.loginCheck(id, password);
	}
}
