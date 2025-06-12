# 🍳 AIレシピ生成アプリ

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![LangChain4j](https://img.shields.io/badge/LangChain4j-0.25.0-blue.svg)](https://github.com/langchain4j/langchain4j)
[![OpenAI](https://img.shields.io/badge/OpenAI-GPT--3.5--turbo-purple.svg)](https://openai.com/)


材料を入力するだけで、AIが美味しいレシピを自動生成するWebアプリケーションです。

## 🎯 プロジェクト概要

このプロジェクトは、最新のAI技術を活用したレシピ生成アプリケーションです。Spring BootとLangChain4jを使用してOpenAI APIと連携し、ユーザーが入力した材料から創意工夫に富んだレシピを自動生成します。

### 🌟 主な機能

- **AIレシピ生成**: 材料を入力するだけで、AIが詳細なレシピを提案
- **レシピ履歴管理**: 生成したレシピを自動保存・検索
- **お気に入り機能**: 気に入ったレシピをメモ付きで保存
- **検索・フィルター**: 履歴やお気に入りから特定のレシピを検索
- **レスポンシブデザイン**: スマートフォンからデスクトップまで対応

## 🛠️ 使用技術

### バックエンド
- **Java 21**: 最新のJava LTS版を使用
- **Spring Boot 3.2.x**: Webアプリケーションフレームワーク
- **LangChain4j**: AI統合ライブラリ
- **OpenAI API**: GPT-3.5-turboモデルを使用

### フロントエンド
- **Thymeleaf**: サーバーサイドテンプレートエンジン
- **HTML5/CSS3**: モダンなWebスタンダード
- **JavaScript (ES6+)**: 非同期通信とインタラクティブUI
- **レスポンシブデザイン**: モバイルファーストアプローチ

### 開発・デプロイ
- **Maven**: ビルドツール・依存関係管理
- **Git/GitHub**: バージョン管理
- **Eclipse IDE**: 開発環境

## 📋 セットアップ方法

### 前提条件
- Java 21以上
- Maven 3.6以上
- OpenAI APIキー