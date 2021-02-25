package com.qa.DemoSiteCucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StepDefinitions {
	
	private static RemoteWebDriver driver;
	private static WebElement targ;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/com/qa/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
	}
	
	@Given("that I can access {string}")
	public void that_i_can_access(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get("http://" + string);
	}
	
	@When("I select Add User tab")
	public void i_select_add_user_tab() {
		driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
	    
	}
	
	@When("I Enter Credentials of User {string} and Password {string} and submit")
	public void i_enter_credentials_of_user_and_password_and_submit(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys(string);
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys(string2);
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).submit();
	}
	@When("I Select Login tab")
	public void i_select_login_tab() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
	}
	@When("I enter Credentials of created user {string} and Password {string} and submit")
	public void i_enter_credentials_of_created_user_and_password_and_submit(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys(string);
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys(string2);
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).submit();
	}
	@Then("Check if Login was successful")
	public void check_if_login_was_successful() {
		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		String result = targ.getText();
		assertEquals("**Successful Login**", result);
	}
	
	@After
    public static void tearDown() {
        driver.quit();
        System.out.println("driver closed");
    }
	
	public static ChromeOptions chromeCfg() {
	     Map<String, Object> prefs = new HashMap<String, Object>();
	     ChromeOptions cOptions = new ChromeOptions();
	      
	     // Settings
	     prefs.put("profile.default_content_setting_values.cookies", 2);
	     prefs.put("network.cookie.cookieBehavior", 2);
	     prefs.put("profile.block_third_party_cookies", true);

	     // Create ChromeOptions to disable Cookies pop-up
	     cOptions.setExperimentalOption("prefs", prefs);
	     // cOptions.setHeadless(headless);

	     return cOptions;
    }
	
	

}
