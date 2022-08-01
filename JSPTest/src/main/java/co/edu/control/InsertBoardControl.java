package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.vo.BoardVO;

public class InsertBoardControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		
		String tt = req.getParameter("title");
		String wr = req.getParameter("writer");
		String ct = req.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(tt);
		vo.setWriter(wr);
		vo.setContent(ct);
		
		service.insertBoard(vo);
		
		HttpUtil.forward(req, resp, "board/boardInsertAlert.tiles");
	}

}
