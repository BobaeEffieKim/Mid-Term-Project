package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.vo.MemberVO;

public class MemberJoinControl extends HttpServlet implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		
		String id = req.getParameter("memberId");
		String pw = req.getParameter("memberPassword");
		String nm = req.getParameter("memberName");
		String addr = req.getParameter("memberAddress");
		MemberVO vo = new MemberVO(id, pw, nm, addr);
		service.addMember(vo);
		
		
		// 회원가입화면: 회원가입 후 첫페이지로 이동.
		HttpUtil.forward(req, resp, "index.jsp");
	}

}
