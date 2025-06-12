package com.example.airecipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.airecipe.service.AiService;

@RestController
public class AiController {

    @Autowired
    private AiService aiService;

    @GetMapping("/ai/chat")
    public String chat(@RequestParam String message) {
        try {
            return aiService.getSimpleResponse(message);
        } catch (Exception e) {
            return "AI 応答の取得中にエラーが発生しました: " + e.getMessage();
        }
    }
}