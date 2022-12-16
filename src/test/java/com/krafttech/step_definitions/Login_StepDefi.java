package com.krafttech.step_definitions;

import com.krafttech.pages.pages.DashboardPage;
import com.krafttech.pages.pages.LoginPages;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class Login_StepDefi {

   LoginPages loginPages=new LoginPages();
   DashboardPage dashboardPage=new DashboardPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Batch2 was here");
        System.out.println("I open the browser and navigate to krafttech web page");

    }
    @When("The user enters Mike credentials")
    public void the_user_enters_mike_credentials() {
        System.out.println("I enter Mike username and password and click login button");

    }
    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
        System.out.println("I verify that url changed Dashboard page");

    }

    @When("The user enters Sebastian credentials")
    public void theUserEntersSebastianCredentials() {
        System.out.println("I enter Sebastian username and password and click login button");
    }

    @When("The user enters Jhon Nash credentials")
    public void theUserEntersJhonNashCredentials() {
        System.out.println("I enter Jhon Nash username and password and click login button");

        


    }

    @Given("User should be on the login page")
    public void userShouldBeOnTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
        
    }

    @When("User should input login information")
    public void userShouldInputLoginInformation() {
        loginPages.loginUser();
        
    }

    @Then("User should be on home page")
    public void userShouldBeOnHomePage() {
        BrowserUtils.waitFor(3);

        String actualTitle= Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);

        Assert.assertEquals("Verify Title","Dashboard - Kraft Techex Lab - aFm",actualTitle);
    }

    @When("User should input {string} and {string}")
    public void userShouldInputAnd(String email, String password) {

        loginPages.loginWithParameters(email, password);


    }

    @Then("User should input following credentials")
    public void user_should_input_following_credentials(Map<String,String> userInfo) {

        loginPages.loginWithParameters(userInfo.get("email"), userInfo.get("password"));

        String actualName = dashboardPage.getUserName();
        String expectedName = userInfo.get("Name");

        System.out.println("actualName = " + actualName);
        System.out.println("expectedName = " + expectedName);

        Assert.assertEquals(expectedName, actualName);
        {
            // Write code here that turns the phrase above into concrete actions
            // For automatic transformation, change DataTable to one of
            // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
            // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
            // Double, Byte, Short, Long, BigInteger or BigDecimal.
            //
            // For other transformations you can register a DataTableType.

        }
    }


    @Then("The warning message contains {string}")
    public void the_warning_message_contains(String expectedWarningMessage) {
        BrowserUtils.waitFor(1);
        String actualWarningMessage = loginPages.getWarningMessageText(expectedWarningMessage);
        Assert.assertEquals(expectedWarningMessage,actualWarningMessage);
    }
}
