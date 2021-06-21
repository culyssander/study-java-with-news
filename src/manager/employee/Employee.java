package manager.employee;

import java.time.LocalDate;

public class Employee {

	private Integer id;
	private String name;
	private String role;
	private String email;
	private LocalDate birth;
	
	public Employee() {}
	
	public Employee(Integer id, String name, String role, String email, LocalDate birth) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.email = email;
		this.birth = birth;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + role + "," + email + "," + birth;
	}
}
