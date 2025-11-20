package com.example.ollai.domain.ports.outbound;

import java.util.List;

/**
 *  Outbound driving port
 */
public interface LLMPort {
    String chat(List<String> conversationHistory);
}
