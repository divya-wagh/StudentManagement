package student_management;

public class Student {
	private int rollNo;
	private String name;
	private String city;
	private String mail;
	private String mob;
	
	public Student(){
		super();
	}
	
	public Student(String name, String city, String mail, String mob) {
		super();
		this.name = name;
		this.city = city;
		this.mail = mail;
		this.mob = mob;
	}
	public Student(int rollNo, String name, String city, String mail, String mob) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.city = city;
		this.mail = mail;
		this.mob = mob;
	}
	
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", city=" + city + ", mail=" + mail + ", mob=" + mob
				+ "]";
	}

	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public String getMail() {
		return mail;
	}
	public String getMob() {
		return mob;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}	
}
