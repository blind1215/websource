package persistence;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.MemberVO;
import static persistence.JDBCUtil.*;


public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}


	
	//로그인 => userid,password 가 일치해야 함
	//select userid, name from member where userid=? and password =?
	public MemberVO isLogin(String userid,String password) {
		
		MemberVO member = null;
		try {
			String sql = "select userid, name from member where userid=? and password =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setUserid(rs.getString("userid"));
				member.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(rs);
				close(pstmt);
			
		}
		return member;

	}//isLogin
	
	//회원가입
	//insert into member values(?,?,?,?,?);
	public int register(MemberVO member) {
	
		int result=0;
		try {
			String sql="insert into member(userid,password,name,gender,email) values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getEmail());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(pstmt);
			
		}
		return result;
	}
	
	//비밀번호 변경
	//update member set password=새로운 비밀번호 where userid=userid
	public int updateMember(String userid,String password) {
		
		int result = 0;
		try {
			String sql="update member set password=? where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, userid);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(pstmt);
				
				
			
		}
		return result;
	}
	//회원탈퇴
	//delete from member where userid=? and password=?
	public int leaverMember(String userid,String password) {
		
		int result = 0;
		try {
			String sql = "delete from member where userid=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(pstmt);
			
		}
		return result;
	}
}
