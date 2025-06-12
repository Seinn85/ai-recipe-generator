document.getElementById('recipeForm').addEventListener('submit', async function (e) {
    e.preventDefault();

    const ingredients = document.getElementById('ingredients').value.trim();
    const resultDiv = document.getElementById('result');
    const recipeContent = document.getElementById('recipe-content');
    const generateBtn = document.getElementById('generateBtn');

    // 詳細なバリデーション
    if (!ingredients) {
        showError('材料を入力してください');
        return;
    }

    if (ingredients.length < 3) {
        showError('材料は3文字以上入力してください');
        return;
    }

    if (ingredients.length > 500) {
        showError('材料の入力は500文字以内にしてください');
        return;
    }

	// 不適切な文字のチェック
	//if (!/^[a-zA-Z0-9ひらがなカタカナ漢字\s、,，．.・\-]+$/.test(ingredients)) {
	if (!/^[a-zA-Z0-\u3040-\u309F\u30A0-\u30FF\u4E00-\u9FFF\s、,，．.・\-]+$/.test(ingredients)) {
        showError('材料には使用できない文字が含まれています');
        return;
    }	

    // ボタンの状態変更（読み込み中）
    generateBtn.disabled = true;
    generateBtn.textContent = '生成中...';
    generateBtn.classList.add('loading');

    // レスポンス準備
    resultDiv.style.display = 'block';
    recipeContent.textContent = 'レシピを生成しています...';
    recipeContent.classList.remove('visible');
    resultDiv.classList.remove('fade-in');

    // API通信
    fetch('/api/recipe/generate', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ ingredients }),
    })
        .then(res => res.json())
        .then(data => {
            if (data.success) {
                displayRecipe(data.recipe);
            } else {
                showError('エラー: ' + data.errorMessage);
            }
        })
        .catch(() => {
            showError('通信エラーが発生しました');
        })
        .finally(() => {
            generateBtn.disabled = false;
            generateBtn.textContent = 'レシピを生成する';
            generateBtn.classList.remove('loading');
        });
});

// リアルタイムバリデーション（文字数カウンター）
document.getElementById('ingredients').addEventListener('input', function (e) {
    const value = e.target.value;
    const counter = document.getElementById('char-counter');

    if (counter) {
        counter.textContent = value.length + '/500';
        counter.style.color = value.length > 450 ? '#e74c3c' : '#7f8c8d';
    }
});

// レシピ表示時のアニメーション
function displayRecipe(recipe) {
    const recipeContent = document.getElementById('recipe-content');
    const resultDiv = document.getElementById('result');

    resultDiv.style.opacity = '0';
    recipeContent.innerHTML = '<div class="recipe-text">' + marked.parse(escapeHtml(recipe)) + '</div>';

    setTimeout(() => {
        resultDiv.style.transition = 'opacity 0.5s ease';
        resultDiv.style.opacity = '1';
    }, 100);
}

// エラー表示
function showError(message) {
    const recipeContent = document.getElementById('recipe-content');
    const resultDiv = document.getElementById('result');

    resultDiv.style.display = 'block';
    recipeContent.innerHTML = '<div class="error">❌ ' + escapeHtml(message) + '</div>';
    resultDiv.style.transition = 'opacity 0.3s ease';
    resultDiv.style.opacity = '1';
}

// HTMLエスケープ
function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}