// グローバル例外ハンドラー
package com.example.airecipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.airecipe.dto.RecipeResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    
	@ExceptionHandler(RecipeGenerationException.class)
    public ResponseEntity<RecipeResponse> handleRecipeGenerationException(RecipeGenerationException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new RecipeResponse("レシピ生成に失敗しました: " + e.getMessage(), false));
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RecipeResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new RecipeResponse("入力エラー: " + e.getMessage(), false));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RecipeResponse> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new RecipeResponse("予期しないエラーが発生しました", false));
    }
}