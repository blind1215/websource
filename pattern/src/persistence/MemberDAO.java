package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static persistence.JDBCUtil.*; 

public class MemberDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO(Connection con) {//생성자
		this.con =con;
	}
	
	public int insert(String name) {
		int result =0;
		try {
			pstmt=con.prepareStatement("insert into member values()");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int delete(String name) {
		System.out.println("memberDAO delete " + name);
		return 1;
	}
}
