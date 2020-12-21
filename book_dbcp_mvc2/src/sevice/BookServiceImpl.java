package sevice;

import java.sql.Connection;
import java.util.List;

import domain.BookVO;
import persistence.BookDAO;
import static persistence.JDBCUtil.*;

public class BookServiceImpl implements BookService {
	
	Connection con;
	BookDAO dao;
	
	public BookServiceImpl() {
		con = getConnection();
		dao = new BookDAO(con);
	}
	

	@Override
	public boolean insertBook(BookVO vo) {
		int result = dao.bookInsert(vo);
		boolean insertFlag = false;
		
		if(result>0) {
			commit(con);
			insertFlag=true;
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateBook(BookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(int code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookVO getRow(int code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> getList() {
		List<BookVO> list = dao.getList();
		close(con);
		return list;
	}

}
