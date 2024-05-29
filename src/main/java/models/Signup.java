package models;

public class Signup {
	private String fullName;
	private String email;
	private String password;
	private String confirmPassword;

	public Signup(String fullName, String email, String password, String confirmPassword){
		this.fullName=fullName;
		this.email=email;
		this.password=password;
		this.confirmPassword=confirmPassword;
	}

	public String getFullName() {
		return this.fullName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}
}
