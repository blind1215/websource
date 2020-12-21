package register2;

public class Member {
	private int id,age;
	private String name,addr,nation,email;
	
	public Member() {
		super();
	}

	public Member(int id, int age, String name, String addr, String nation, String email) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.addr = addr;
		this.nation = nation;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", age=" + age + ", name=" + name + ", addr=" + addr + ", nation=" + nation
				+ ", email=" + email + "]";
	}
	
	
	
	

}
	