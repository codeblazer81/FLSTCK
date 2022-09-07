package com.example.servingwebcontent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    
    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id="messageType")
    private WebElement messageType;

    @FindBy(id = "outMessageText")
    private WebElement outMessageText;

    @FindBy(id="outUsername")
    private WebElement outUsername;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getOutUsername() {
        return outUsername.getText();
    }
    public String getOutMessageText() {
        return outMessageText.getText();
    }

    public void setMessageText(String value) {
        messageText.clear();
        messageText.sendKeys(value);
    }

    public void setMessageType(String value) {
        messageType.clear();
        messageType.sendKeys(String.valueOf(value));
       
    }


}
