package co.edu.service;

import co.edu.dao.BoardDAO;
import co.edu.vo.BoardVO;

public class BoardService {
	BoardDAO bdao = new BoardDAO();
	
	private static BoardService instance = null;
	private BoardService() {}
	public static BoardService getInstance() {
		if (instance == null) {
			instance = new BoardService();
		}
		return instance;
	}
	
	public void insertBoard(BoardVO vo) {
		bdao.insertBoard(vo);
	}
}
