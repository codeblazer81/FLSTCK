package com.example.servingwebcontent.service;

import org.springframework.stereotype.Service;

import com.example.servingwebcontent.model.ChatForm;
import com.example.servingwebcontent.model.ChatMessage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class MessageListService {
   List <ChatMessage> chatMessages;
   
    public List<ChatMessage> getMessages() {
        return chatMessages;
    }
    
    public void addMessage(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserName(chatForm.getUserName());
        switch (chatForm.getMessageType()){
            case "Whisper":
                chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
            case "Shout":
                chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
            break;
            default:
                chatMessage.setMessageText(chatForm.getMessageText());
                break;
            }
        chatMessages.add(chatMessage);
    }

    public boolean checkBadWords (ChatForm chatForm){
        
        String messageText = chatForm.getMessageText();

        if (messageText.matches("(.*)fuck(.*)")){
            return true;
        }
        else {
            return false;
        }


    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }
}
