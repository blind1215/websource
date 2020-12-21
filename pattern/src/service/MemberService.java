package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {//추상메소드기때문에
	//DAO와 연동 - C(insert)R(select)U(update)D(delete)
	public void print(); //구현부분이없는 메소드{}<-있는것이 구현메소드
	
	public boolean insertMember(String name);
	public boolean updateMember(String name);
	public boolean deleteMember(String name);
	
	public MemberVO getMember(String name);
	public List<MemberVO> getList();
}

