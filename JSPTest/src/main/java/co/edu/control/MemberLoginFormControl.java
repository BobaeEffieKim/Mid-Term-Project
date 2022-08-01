package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.vo.MemberVO;

public class MemberLoginFormControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		MemberVO vo = (MemberVO) session.getAttribute("member");
		
		if(vo == null) {
			HttpUtil.forward(req, resp, "member/memberLoginForm.tiles");
		} else {
			HttpUtil.forward(req, resp, "member/memberLoginSuccess.tiles");
		}
	}

}
