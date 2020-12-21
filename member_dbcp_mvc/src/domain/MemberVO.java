package domain;

import lombok.Data;

//get/set,equals,default constructor, hashCode , toString
@Data
public class MemberVO {

	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
}
