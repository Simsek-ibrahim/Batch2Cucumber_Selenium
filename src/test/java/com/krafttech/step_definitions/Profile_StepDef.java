package com.krafttech.step_definitions;

import com.krafttech.pages.pages.ProfilePages;
import com.krafttech.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Profile_StepDef {
ProfilePages profilePages=new ProfilePages();
    @When("User should go to My Profile")
    public void user_should_go_to_my_profile() {
      profilePages.myProfileBtn.click();
    }
    @When("User should navigate to {string}")
    public void user_should_navigate_to(String tabName) {
      profilePages.profileTabs(tabName);
    }
    @When("User should input the information boxes")
    public void user_should_input_the_information_boxes() {
       profilePages.fullName.sendKeys("Harun");
       profilePages.about.sendKeys("This is great work");
       profilePages.company.sendKeys("GHAN IT");

        BrowserUtils.waitForVisibility(profilePages.slider, 5);
        BrowserUtils.dragAndDropBy(profilePages.slider,150,0);

        Select select=new Select(profilePages.job);
        select.selectByVisibleText("SDET");

        profilePages.website.sendKeys("krafttechnologie.com");
        profilePages.location.sendKeys("Ankara");
        profilePages.skills.sendKeys("Postman, RestAssured,API, SQL");

        BrowserUtils.clickWithJS(profilePages.save);

    }
    @Then("User should verify the profile updated message")
    public void user_should_verify_the_profile_updated_message() {

        BrowserUtils.waitFor(5);

        String actualMsg= profilePages.profileUpdatemsg.getText();
        String expctedMsg= "Profile Updated";

        Assert.assertEquals(expctedMsg,actualMsg);

    }


    @Then("User should see the profile options")
    public void user_should_see_the_profile_options(List<String> proOptions) {

        List<String> actualOptions= BrowserUtils.getElementsText(profilePages.profileOptions);
        System.out.println("actualOptions.size() = " + actualOptions.size());

        System.out.println("actualOptions = " + actualOptions);
        System.out.println("proOptions = " + proOptions);

        Assert.assertEquals(proOptions,actualOptions);

        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }



}
