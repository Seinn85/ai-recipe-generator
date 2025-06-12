package com.example.airecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.langchain4j.model.chat.ChatLanguageModel;

@Service
public class AiService {

    @Autowired
    private ChatLanguageModel chatModel;

    public String getSimpleResponse(String userInput) {
        String prompt = "以下の質問に日本語で簡潔に答えてください: " + userInput;
        return chatModel.generate(prompt);
    }
}