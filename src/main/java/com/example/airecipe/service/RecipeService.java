package com.example.airecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airecipe.exception.RecipeGenerationException;
import dev.langchain4j.model.chat.ChatLanguageModel;

@Service
public class RecipeService {

    @Autowired
    private ChatLanguageModel chatModel;

    public String generateRecipe(String ingredients) {
    	// 入力チェック
        if (ingredients == null || ingredients.trim().isEmpty()) {
            throw new IllegalArgumentException("材料が入力されていません");
        }
        if (ingredients.length() > 500) {
            throw new IllegalArgumentException("材料の入力が長すぎます（500文字以内で入力してください）");
        }

        try {
            String prompt = createRecipePrompt(ingredients);
            String response = chatModel.generate(prompt);

            if (response == null || response.trim().isEmpty()) {
            	throw new RecipeGenerationException("AIからの応答が空でした");
            }
            return response;

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                throw e; // Re-throw to be handled by global handler
            }
            throw new RecipeGenerationException("レシピ生成中にエラーが発生しました", e);
        }
    }

    private String createRecipePrompt(String ingredients) {
        return "あなたは経験豊富な料理研究家です。以下の材料を使って、家庭で簡単に作れる美味しい料理のレシピを提案してください。\n\n" +
               "使用する材料: " + ingredients + "\n\n" +
               "以下の形式で、分かりやすく回答してください：\n\n" +
               "【料理名】\n（魅力的で分かりやすい料理名を付けてください）\n\n" +
               "【材料】（4人分）\n・具体的な分量を含めて記載してください\n・足りない基本調味料があれば追加してください\n\n" +
               "【調理時間】\n準備時間: ○分\n調理時間: ○分\n\n" +
               "【作り方】\n1. （具体的で分かりやすい手順を番号付きで記載）\n2. \n...\n\n" +
               "【コツ・ポイント】\n・美味しく作るためのポイントを1〜2つ記載\n\n" +
               "【栄養のポイント】\n・この料理の栄養面での特徴を簡潔に説明";
    }
}