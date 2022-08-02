package co.edu.service;

import java.util.List;

import co.edu.dao.BoardDAO;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

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
	
	//리스트 불러오는 것 
	public List<BoardVO> boardList(){
		return bdao.boardList();
	}
	
	//페이징
	public List<BoardVO> getListPaging(Criteria cri){
		return bdao.getListPaging(cri);	//10건씩
	}
}
