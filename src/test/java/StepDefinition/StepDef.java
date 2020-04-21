package StepDefinition;

import Businessmethods.Basesetupdriver;
import Businessmethods.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef extends Basesetupdriver {
	public static LoginPage l = new LoginPage();

	@Given("^User is StoB login page$")
	public void user_is_StoB_login_page() throws Throwable {
		ReadPropertyfile_and_OpenBrowser();
	}

	@When("^User enter the username,groupid and password from excel \"([^\"]*)\"$")
	public void user_enter_the_username_groupid_and_password_from_excel(String arg1) throws Throwable {
		l.login(arg1);
	}

	@Then("^click the login button$")
	public void click_the_login_button() throws Throwable {
		l.browserclose();
	}
	
	

}