package com.example.ollai;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final OllamaChatModel chatModel;

    public ChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping
    public String hello(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        long t0 = System.currentTimeMillis();
        String call = this.chatModel.call(message);
        long t1 = System.currentTimeMillis();
        long timestamp = t1 - t0;

        return call + " (" + timestamp + " ms)";
    }


}
