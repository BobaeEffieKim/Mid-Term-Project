package co.edu.service;

import co.edu.dao.MemberDAO;
import co.edu.vo.MemberVO;

public class MemberService {
	MemberDAO mdao = new MemberDAO();
	
	private static MemberService instance = null;
	private MemberService() {}
	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	
	public void addMember(MemberVO vo) {
		mdao.insertMember(vo);
	}
	
	public MemberVO searchMember(String id) {
		return mdao.searchMember(id);
	}
	
}
