package com.example.servingwebcontent.controller;



import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.servingwebcontent.mapper.MessageMapper;
import com.example.servingwebcontent.model.ChatForm;
import com.example.servingwebcontent.model.ChatMessage;
import com.example.servingwebcontent.service.MessageListService;
import com.example.servingwebcontent.service.UserService;


@Controller
@RequestMapping("/chat")
public class ChatController {

	private MessageListService messageListService ;



	public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }
	
	/**
	 * @param messageForm
	 * @param model
	 * @return
	 */
	@GetMapping("/chat")
	public String loadHomePage(@ModelAttribute ("chatForm") ChatForm chatForm, Model model){
		model.addAttribute("chatMessages", this.messageListService.getMessages());
		return "chat";
	}


    /**
     * @param messageForm
     * @param model
     * @return
     */
    @PostMapping("/chat")
	public String postChatMessage(@ModelAttribute ("chatForm") ChatForm chatForm,Model model, Authentication authenticate) {
		try
		
		{
			chatForm.setUserName(authenticate.getName());
			if (this.messageListService.checkBadWords(chatForm)) {
				//chatForm.setMessageText("");
				model.addAttribute("chatMessages.messageText", "message has been censored");
			}
			else {
				this.messageListService.addMessage(chatForm);
				//chatForm.setMessageText("");
				model.addAttribute("chatMessages", this.messageListService.getMessages());
			}
				
				
		}
		
		catch (NullPointerException e) {

			System.out.println(e);
		}
	
			return "chat";
		
	}

	
}
