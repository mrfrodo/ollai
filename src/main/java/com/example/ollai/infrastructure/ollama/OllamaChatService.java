package com.example.ollai.infrastructure.ollama;

import com.example.ollai.domain.ports.outbound.LLMPort;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Ollama outbound driven adapter
 */
@Component
public class OllamaChatService implements LLMPort {

    private final OllamaChatModel chatModel;

    public OllamaChatService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String chat(List<String> history) {
        String prompt = String.join("\n", history);
        return chatModel.call(prompt);
    }
}
