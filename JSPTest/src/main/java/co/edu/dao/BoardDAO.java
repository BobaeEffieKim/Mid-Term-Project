package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.vo.BoardVO;

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
}
