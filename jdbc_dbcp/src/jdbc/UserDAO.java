package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
// ~ DAO : 데이터베이스 작업을 담당하는 클래스 
//jdbc : 드라이버로드, 커넷션, CRUD(select, update, delete,insert)
//	static { //객체생성을안하고 바로쓸수있음
//		
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	//커넥션
	public Connection getConnection(){
		//2. 데이터베이스 연결을 위한 문자열 생성
		//3. 커넥션
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return null;"
		return con;
	
	}	
	
	//CRUD
	//insert 
	public int insert(String userName,String birthYear,String addr,String mobile) {
		
		Connection con=getConnection();
		PreparedStatement pstmt = null;
		int result =0;
		try {
		if(con!=null){
			//4.sql 구문 생성
			String sql = " insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";
			//5. Statement 생성 후 전송
			pstmt=con.prepareStatement(sql);
			// ? 에 해당하는 값을 set 하기
			pstmt.setString(1, userName); 
			pstmt.setInt(2, Integer.parseInt(birthYear)); 
			pstmt.setString(3, addr); 
			pstmt.setString(4, mobile); 
			
			//6. sql 구문 실행하고 결과 받기
			result = pstmt.executeUpdate();
			

		
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			pstmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		return result;
	}
	//Read
	//전체조회
	public List<UserVO> select() {
		
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		List<UserVO> list = new ArrayList<UserVO>(); //비어있는 박스 만듬 
		
		try {
			if(con!=null){
				//4. sql 구문 생성
				String sql = "select * from USERTBL order by no desc";
				//5. Statement 생성 후 전송: DB연결을 통해 sql 문을 수행해 주는 클래스
				pstmt=con.prepareStatement(sql);
				//6.sql 구문 실행하고 결과 받기 => select구문 executeQuery() => ResultSet
				//insert,update,delete,executeUpdate() => int
				rs=pstmt.executeQuery();
				//7.결과 출력(ResultSet : DB Select 결과를 담는 특수한 객체(테이블 구조))
				while(rs.next()){
					//사용하려면 UserVO객체 생성
					UserVO user = new UserVO();
					user.setNo(rs.getInt(1)); //no(number)
					user.setUsername(rs.getString(2));//username(nchar)
					user.setBirthyear(rs.getInt(3));//birthYear(number)
					user.setAddr(rs.getString(4)); // addr(nchar)
					user.setMobile(rs.getString(5)); //mobil(nvarchar2)
					//System.out.println(no+"\t"+userName+"\t"+birthYear+"\t"+addr+"\t"+mobile);
					list.add(user); //만든 박스에 바구니들 담기
		}
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		return list;//박스채로 돌려줌
	}
	//개별조회
	public UserVO getUser(String no) {
		//DB 연결 후 사용자의 no에 해당하는 정보 가져오기
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO user = null;
		try{
			if(con!=null){
				String sql = "select * from userTBL where no=?";
				/* String sql = "select no, username,addr,mobile from userTBL where no=?"; */
				//sql구문 전송
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,Integer.parseInt(no));
				//sql 실행
				rs=pstmt.executeQuery();
				if(rs.next()){
					user=new UserVO();
					user.setNo(rs.getInt("no"));
					user.setUsername(rs.getString("userName"));
				} //if
			}//if
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public int deletUser(int no) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			//no에 해당하는 user 삭제
						
			if(con!=null){
				//삭제가 성공하면 index.jsp
				String sql = "delete from userTBL where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,no);
				result = pstmt.executeUpdate();
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public int updateUser(int no, String addr, String mobile) {
		Connection con=getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			
			if(con!=null){
				//열명을 올바르게 지정해 주십시오
				String sql = "update userTBL set addr=?, mobile=? where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, addr);
				pstmt.setString(2, mobile);
				pstmt.setInt(3, no);
				result = pstmt.executeUpdate(); //1행 추가되었습니다
				
			}
				//4.sql 구문 생성
		
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					
					pstmt.close();
					con.close();
		
				}catch(Exception e){
					e.printStackTrace();
				}
		}
		return result;
	}
}
