package com.example.servingwebcontent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    
    @FindBy(id = "inputFirstName")
    private WebElement inputFirstName;

    @FindBy(id="inputLastName")
    private WebElement inputLastName;

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id="inputPassword")
    private WebElement inputPassword;

    @FindBy(id="submit-button")
    private WebElement submitButton;
    
    @FindBy(id="success-msg")
    private WebElement successMsg;
    
    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMsg() {
        return successMsg.getText();
    }
    

    public void setInputFirstName(String value) {
        inputFirstName.clear();
        inputFirstName.sendKeys(value);
    }
    public void setInputLastName(String value) {
        inputLastName.clear();
        inputLastName.sendKeys(value);
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

}
