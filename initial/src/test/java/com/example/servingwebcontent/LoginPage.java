package com.example.servingwebcontent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id="inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "errormsg")
    private WebElement errormsg;

    @FindBy(id = "submit-button")
    private WebElement submitButton;
    
    @FindBy(id = "signup-link")
    private WebElement signupLink;
   
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getErrorMsg() {
        return errormsg.getText();
    }


    public void setInputUsername(String value) {
        inputUsername.clear();
        inputUsername.sendKeys(value);
    }

    public void setInputPassword(String value) {
        inputPassword.clear();
        inputPassword.sendKeys(value);
        submitButton.click();
    }

    public void clickSignupLink() {
        signupLink.click();
        
    }

}
