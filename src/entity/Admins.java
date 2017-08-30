package entity;

public class Admins {
	private String uid;
	private String jnum;
	private String name;
	private String gender;
	private String username;
	private String password;
	private String status;
	public final String getGender() {
		return gender;
	}

	public final void setGender(String gender) {
		this.gender = gender;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}

	private String department;
	private String phone;
	private String email;

	public Admins() {

	}

	public Admins(String uid, String jnum, String name, String username, String password, String department,String phone, String email) {
		// super();
		this.uid = uid;
		this.jnum = jnum;
		this.name = name;
		this.username = username;
		this.password = password;
		this.department = department;
		this.phone = phone;
		this.email = email;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getJnum() {
		return jnum;
	}

	public void setJnum(String jnum) {
		this.jnum = jnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
