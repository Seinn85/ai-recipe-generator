package com.example.airecipe.dto;

public class RecipeResponse {
    private String recipe;
    private boolean success;
    private String errorMessage;

    public RecipeResponse(String recipe) {
        this.recipe = recipe;
        this.success = true;
    }

    public RecipeResponse(String errorMessage, boolean success) {
        this.errorMessage = errorMessage;
        this.success = success;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}