package com.example.ollai.infrastructure.config;

import com.example.ollai.domain.ChatUseCaseImpl;
import com.example.ollai.domain.ports.inbound.ChatUseCase;
import com.example.ollai.domain.ports.outbound.LLMPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ChatUseCase chatUseCase(LLMPort chatService) {
        return new ChatUseCaseImpl(chatService);
    }

}
