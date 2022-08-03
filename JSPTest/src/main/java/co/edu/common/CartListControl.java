package co.edu.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.service.BoardService;
import co.edu.vo.CartVO;

public class CartListControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=UTF-8");
		
		// DAO에 메소드 추가, MemberService에 메소드 추가. http://localhost/JSPTEST/cartList.do
		// json 반환
		
		BoardService service = BoardService.getInstance();
		List<CartVO> cartList = service.cartList();
		
		//json으로 변환해주는 라이브러리
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(cartList));
		
	}

}
