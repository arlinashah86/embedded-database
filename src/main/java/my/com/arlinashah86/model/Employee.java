package my.com.arlinashah86.model;

public class Employee {
	
	private Integer id;
	private String name;
	private String email;
	
			
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	

}
