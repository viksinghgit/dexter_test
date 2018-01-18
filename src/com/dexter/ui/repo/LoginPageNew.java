/**
 * 
 */
package com.dexter.ui.repo;
import org.openqa.selenium.support.How;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author Vikrant
 * Example using Page Factory
 *
 */
public class LoginPageNew {
	@FindBy (id="username") 
	@CacheLookup
	WebElement user;
	
	@FindBy(how=How.XPATH,using="//input[@name='pwd']")
	WebElement pass;
	
	@FindBy(how=How.XPATH,using=".//*[@id='loginButton']/div")
	WebElement button;
	
	public void loginActitime( String uid,String pwd)
	{
	user.sendKeys(uid);
	pass.sendKeys(pwd);
	button.click();
	}
	
	

}
