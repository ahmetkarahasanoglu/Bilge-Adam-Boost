package utility;

public class Kullanici {
	
	private String name;
	private String email;
	private String phone;
	
	// CONSTRUCTOR 1:
	public Kullanici(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	// CONSTRUCTOR 2:
	public Kullanici(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	// CONSTRUCTOR 3:
	public Kullanici(String name) {
		super();
		this.name = name;
	}

	// GETTERS AND SETTERS:
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
