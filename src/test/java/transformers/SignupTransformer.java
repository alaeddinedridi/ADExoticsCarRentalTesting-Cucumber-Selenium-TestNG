package transformers;

import java.util.Map;

import io.cucumber.java.DataTableType;
import models.Signup;

public class SignupTransformer {

	@DataTableType
	public Signup defineSignup(Map<String, String> entry) {
		 return new Signup(entry.get("fullName"), entry.get("email"), entry.get("password"), entry.get("confirmPassword"));
	}
}
