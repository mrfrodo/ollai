package com.example.ollai.domain.ports.inbound;

/**
 * Inbound driving port
 */
public interface ChatUseCase {
    String handleChat(String message, String sessionId);
}
