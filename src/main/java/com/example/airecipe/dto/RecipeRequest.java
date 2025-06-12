package com.example.airecipe.dto;

public class RecipeRequest {
    private String ingredients;

    public RecipeRequest() {}

    public RecipeRequest(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}