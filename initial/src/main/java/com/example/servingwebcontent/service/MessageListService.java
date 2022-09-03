package com.example.servingwebcontent.service;

import com.example.servingwebcontent.mapper.MessageMapper;
import org.springframework.stereotype.Service;
import com.example.servingwebcontent.model.ChatForm;
import com.example.servingwebcontent.model.ChatMessage;
import javax.annotation.PostConstruct;

@Service
public class MessageListService {
   private final MessageMapper messageMapper;
   
   public MessageListService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
    
    public Integer addMessage(ChatForm chatForm) {
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
            return messageMapper.insert(new ChatMessage(null, chatMessage.getMessageText(), chatMessage.getUserName()));
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

    public ChatMessage getMessages() {
        
        return messageMapper.getMessage();

    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
       
    }
}
