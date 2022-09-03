package com.example.servingwebcontent.model;


public class ChatMessage {
    
    
    private String messageText;
    private String userName;
    private Integer messageId;


    public ChatMessage() {
    }
    
    public ChatMessage(Integer messageId, String messageText, String userName ) {
        this.messageText = messageText;
        this.userName = userName;
        this.messageId = messageId;
    }



    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public Integer getMessageId() {
        return this.messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
    


}
