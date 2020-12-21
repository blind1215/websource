package student;

public class Student {
	
	private int classNum,year;
	private String name,addr,birthday;
	
	
	
	public Student() {
		super();
		
	}

	public Student(int classNum, int year, String name, String addr, String birthday) {
		super();
		this.classNum = classNum;
		this.year = year;
		this.name = name;
		this.addr = addr;
		this.birthday = birthday;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [classNum=" + classNum + ", year=" + year + ", name=" + name + ", addr=" + addr + ", birthday="
				+ birthday + "]";
	}
	
	
	
}

