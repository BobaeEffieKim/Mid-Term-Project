package co.edu.dao;

import java.sql.SQLException;

import co.edu.vo.MemberVO;

public class MemberDAO extends DAO{
	public void insertMember(MemberVO vo) {
		String sql = "insert into test_member values (?,?,?,?)";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("회원 " + vo.getId() + " 등록 완료.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public MemberVO searchMember(String id) {
		String sql = "select * from test_member where id = '" + id + "'";
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
