package service;

import java.sql.Connection;
import java.util.List;

import domain.UserVO;
import persistence.UserDAO;
import static persistence.JDBCUtil.*;


public class UserserviceImpl implements UserService {
	
	Connection con;
	UserDAO dao;
	
	public UserserviceImpl() {
		con = getConnection();
		dao = new UserDAO(con);
	}

	@Override
	public boolean insertUser(String userName, String birthYear, String addr, String mobile) {
		//db작업 DAO로 뺐음 DAO가 일을하도록 시킨다
		//그럴러면 객체를 생성해야한다  - DB 작업 시키기
		int result=dao.insert(userName, birthYear, addr, mobile);
		
		//DB작업 결과를 action에게 보내기 - commit,rollback
		boolean insertFlag = false;
		if(result>0) {
			insertFlag = true;
			commit(con);		
		} else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateUser(int no, String addr, String mobile) {
		
		boolean updateFlag = false;
		int result = dao.updateUser(no, addr, mobile);
		
		if(result>0) {
			updateFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return updateFlag;
	}

	@Override
	public boolean deleteUser(int no) {
		boolean deleteFlag =false;
		int result = dao.deletUser(no);
		
		if(result>0) {
			commit(con);
			deleteFlag=true;
		}else {
			rollback(con);
		}
		close(con);

		return deleteFlag;
	}

	@Override
	public UserVO getUser(int no) {
		UserVO user=dao.getUser(no);
		close(con);
		return user;
	}

	@Override
	public List<UserVO> getUserList() {
		List<UserVO> list=dao.select();
		close(con);
		return list;
	}

}
