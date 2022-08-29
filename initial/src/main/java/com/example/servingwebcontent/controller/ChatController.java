package com.example.servingwebcontent.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.servingwebcontent.model.ChatForm;
import com.example.servingwebcontent.service.MessageListService;


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
	public String postChatMessage(@ModelAttribute ("chatForm") ChatForm chatForm,Model model) {
		try
		{
			if (this.messageListService.checkBadWords(chatForm)) {
				chatForm.setMessageText("");
				model.addAttribute("chatMessages.messageText", "message has been censored");
			}
			else {
				this.messageListService.addMessage(chatForm);
				chatForm.setMessageText("");
				model.addAttribute("chatMessages", messageListService.getMessages());
			}
				
				
		}
		
		catch (NullPointerException e) {

			System.out.println(e);
		}
	
			return "chat";
		
	}

	
}
