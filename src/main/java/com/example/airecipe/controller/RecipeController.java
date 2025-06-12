package com.example.airecipe.controller;

import com.example.airecipe.dto.RecipeRequest;
import com.example.airecipe.dto.RecipeResponse;
import com.example.airecipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
@CrossOrigin(origins = "*")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/generate")
    public ResponseEntity<RecipeResponse> generateRecipe(@RequestBody RecipeRequest request) {
        try {
            if (request.getIngredients() == null || request.getIngredients().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(new RecipeResponse("材料を入力してください", false));
            }

            String recipe = recipeService.generateRecipe(request.getIngredients());
            return ResponseEntity.ok(new RecipeResponse(recipe));

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(new RecipeResponse("レシピ生成中にエラーが発生しました", false));
        }
    }
}