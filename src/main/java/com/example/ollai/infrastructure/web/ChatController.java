package com.example.ollai.infrastructure.web;
import com.example.ollai.domain.ports.inbound.ChatUseCase;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

/**
 * # Web inbound driving adapter
 */
@RestController
public class ChatController {

    private final ChatUseCase chatUseCase;

    public ChatController(ChatUseCase chatUseCase) {
        this.chatUseCase = chatUseCase;
    }

    @GetMapping
    public String hello( @RequestParam(value = "message", defaultValue = "Tell me a joke") String message, HttpSession session) {
        long t0 = System.currentTimeMillis();
        String response = chatUseCase.handleChat(message, session.getId());
        long t1 = System.currentTimeMillis();
        return response + " (" + (t1 - t0) + " ms)";
    }


}
