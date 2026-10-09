package com.spring.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AiChatController {

    private  ChatClient chatClient;

    //create the chatClient builder--this is constructor
    public AiChatController(ChatClient.Builder builder){
        this.chatClient= builder.build();
    }
    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String string){

        var resultResponse=chatClient.prompt(string).call().content();
        return ResponseEntity.ok(resultResponse);
    }

}
