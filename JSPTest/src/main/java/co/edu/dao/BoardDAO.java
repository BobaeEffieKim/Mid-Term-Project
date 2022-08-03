package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.vo.BoardVO;
import co.edu.vo.CartVO;
import co.edu.vo.Criteria;

public class BoardDAO extends DAO {
	
	public void insertBoard(BoardVO vo) {
		String sql = "insert into test_board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			int r = pstmt.executeUpdate();
			if(r > 0) {
				System.out.println("게시글 " + r + "건 등록완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public List<BoardVO> boardList() {
		String sql = "select * from test_board";
		List<BoardVO> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setSeq(rs.getInt("seq"));
				vo.setContent(rs.getString("content"));
				vo.setVisitCnt(rs.getInt("visit_cnt"));
				vo.setWriteDate(rs.getString("write_date"));
				vo.setWriter(rs.getString("writer"));
				list.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public void updateCnt(int seq) {
		String sql = "update test_board set cnt = cnt+1 where seq = " + seq;
		try {
			connect();
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			if (r>0) {
				System.out.println(seq + " 조회수 업데이트 완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public BoardVO getBoard(int seq) {
		String sql = "select * from test_board where seq = " + seq;
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setSeq(rs.getInt("seq"));
				vo.setContent(rs.getString("content"));
				vo.setVisitCnt(rs.getInt("visit_cnt"));
				vo.setWriteDate(rs.getString("write_date"));
				vo.setWriter(rs.getString("writer"));
				return vo;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	//페이징 처리
	public List<BoardVO> getListPaging(Criteria cri){
		
		List<BoardVO> listPage = new ArrayList<>();
		
		String sql = "select seq,title,content, writer, write_date, visit_cnt "
				+ "from(select rownum rn, seq, title, content, writer, write_date, visit_cnt "
				+ "from(select  seq,title, content, writer, write_date, visit_cnt "
				+ "from test_board "
				+ "order by seq desc) "
				+ "where rownum <= ? ) "	// 1: 0~10, 2: 10~20
				+ "where rn> ? ";
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getAmount() * cri.getPageNum());	//10*1
			pstmt.setInt(2, cri.getAmount() * (cri.getPageNum() -1 ));	//0
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriteDate(rs.getString("write_date"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setVisitCnt(rs.getInt("visit_cnt"));
			
				listPage.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return listPage;
	}
	
	
	//cart 전체 데이터 가지고오는 메소드
	public List<CartVO> cartList(){
		
		String sql = "select * from cart";
		List<CartVO> cartList = new ArrayList<>();
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				CartVO cart = new CartVO();
				cart.setNo(rs.getInt("no"));
				cart.setProductNm(rs.getString("product_nm"));
				cart.setPrice(rs.getInt("price"));
				cart.setQty(rs.getInt("qty"));
				
				cartList.add(cart);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cartList;
	}
	
	//수량변경
	public void updateCart(int no, int qty) {
		String sql = "update cart set qty = " + qty + "where no = "+no;
		connect();
		
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			
			if(r>0) {
				System.out.println(r+"건 수정");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
}
