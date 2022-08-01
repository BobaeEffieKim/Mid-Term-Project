package com.dev.log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.controller.Controller;
import com.dev.member.MemberVO;

public class MemberLoginFormControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		MemberVO vo = (MemberVO)session.getAttribute("member");
		
		if(vo == null) {
			HttpUtil.forward(req, resp, "member/memberLoginForm.tiles");
		} else {
			HttpUtil.forward(req, resp, "main/middle.tiles");
			//HttpUtil.forward(req, resp, "member/memberLoginSuccess.tiles");
		}
	}

}
