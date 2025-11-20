package com.example.ollai.domain;

import com.example.ollai.domain.ports.inbound.ChatUseCase;
import com.example.ollai.domain.ports.outbound.LLMPort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatUseCaseImpl implements ChatUseCase {

    private final LLMPort chatService;
    private final Map<String, List<String>> sessionStore = new HashMap<>();

    public ChatUseCaseImpl(LLMPort chatService) {
        this.chatService = chatService;
    }

    @Override
    public String handleChat(String message, String sessionId) {
        List<String> history = sessionStore.computeIfAbsent(sessionId, id -> new ArrayList<>());

        history.add("User: " + message);
        String response = chatService.chat(history);
        history.add("AI: " + response);

        return response;
    }

}
