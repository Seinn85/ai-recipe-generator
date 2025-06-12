package com.example.airecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiRecipeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiRecipeAppApplication.class, args);
    }
}

//http://localhost:8080/hello
//http://localhost:8080/hello/name?name=Seinn

//http://localhost:8080/ai/chat?message=こんにちは

//http://localhost:8080/api/recipe/generate