package transformers;

import java.util.Map;

import io.cucumber.java.DataTableType;
import models.Login;

public class LoginTransformer {

	@DataTableType
	public Login defineLogin(Map<String, String> entry) {
		 return new Login(entry.get("email"), entry.get("password"));
	}
}
