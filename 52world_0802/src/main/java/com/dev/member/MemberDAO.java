package com.dev.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;





public class MemberDAO {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {
		try {
			
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////////////
	
	
	//회원가입
	public void insertMember(MemberVO vo) {
		String sql = "insert into test_member values (?,?,?,?,?,?,?,?,?,?)";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setDate(4, vo.getBirth());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getPhone());
			pstmt.setString(8, vo.getProfile());
			pstmt.setString(9, vo.getIntroduce());
			pstmt.setInt(10, vo.getDotori());
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
	
	//회원검색
	public MemberVO searchMember(String id) {
		String sql = "select * from member where id = '" + id + "'";
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setBirth(rs.getDate("birth"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setProfile(rs.getString("profile"));
				vo.setIntroduce(rs.getString("introduce"));
				vo.setDotori(rs.getInt("dotori"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	//////////////////////////////////////////////////////////////
	
	//이름, 생일, 전화번호로 아이디 검색
	public MemberVO lookUpId(String name, String birth, String phone) {
		String sql = "select id from member where name = ?  "
				+ "                    and birth=? "
				+ "                    and phone=? ";
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "name");
			pstmt.setString(2, "birth");
			pstmt.setString(3, "phone");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setBirth(rs.getDate("birth"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setProfile(rs.getString("profile"));
				vo.setIntroduce(rs.getString("introduce"));
				vo.setDotori(rs.getInt("dotori"));
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}
		return null;
	}
	

	//이름, id, 전화번호로 비밀번호 검색
	public MemberVO lookUpPassword(String name, String id, String phone) {
		String sql = "select password from member where name = ? "
				+ "                    and id = ? "
				+ "                    and phone = ? ";
		
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "name");
			pstmt.setString(2, "id");
			pstmt.setString(3, "phone");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setBirth(rs.getDate("birth"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setProfile(rs.getString("profile"));
				vo.setIntroduce(rs.getString("introduce"));
				vo.setDotori(rs.getInt("dotori"));
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}
		return null;
	}
	
	//////////////////////////////
	
	//로그인 체크하는 메서드
	public int loginCheck(String id, String password) {
		
		String dbPw = "";	//db에서 꺼낸 비번 담을 변수
		int x = -1;
		
		//입력된 아이디로 db에서 비번을 조회
		String sql = "SELECT password FROM member WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			//만약 입력된 아이디에 해당하는 비번이 있을경우
			if(rs.next()) {
				//비번을 변수에 넣음
				dbPw = rs.getString("password");
				
				if(dbPw.equals(password)) {
					x = 1;	//넘겨받은 비번 = db비번 => 인증성공
				} else {
					x = 0;	//입력비번 != db비번 => 인증실패
				}
				
			} else {
				x = -1; 	//해당 아이디가 없을 경우
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return x;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
