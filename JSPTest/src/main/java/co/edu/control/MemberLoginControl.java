package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.vo.MemberVO;

public class MemberLoginControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		HttpSession session = req.getSession();
		
		String id = req.getParameter("memberId");
		String pw = req.getParameter("memberPassword");
		
		MemberVO vo = service.searchMember(id);
		
		if(vo == null || !pw.equals(vo.getPasswd())) {
			// 로그인 실패 시 memberLoginFail.jsp로 이동.
			HttpUtil.forward(req, resp, "member/memberLoginFail.tiles");
		} else {
			// 로그인 성공 시 memberLoginSuccess.jsp로 이동.
			session.setAttribute("member", vo);
			HttpUtil.forward(req, resp, "member/memberLoginSuccess.tiles");
		}
	}

}
