package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 文字列変換アプリケーションのメインクラス
 * 
 * <p>Spring Bootアプリケーションの起動エントリーポイントを提供します。</p>
 * 
 * <ul>
 *   <li>自動設定の有効化</li>
 *   <li>コンポーネントスキャンの実行</li>
 *   <li>組み込みサーバーの起動</li>
 * </ul>
 */
@SpringBootApplication // (1) Spring Bootの自動設定を有効化（@Configuration + @EnableAutoConfiguration + @ComponentScan）
public class GetImageSoapClientApplication {

    /**
     * アプリケーションのメインメソッド
     * 
     * <p>Spring Bootアプリケーションを起動します。</p>
     * 
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // (2) Springアプリケーションコンテキストの初期化と起動
        // - 自動設定の適用
        // - 組み込みTomcatサーバーの起動
        // - アプリケーションコンポーネントの初期化
        SpringApplication.run(GetImageSoapClientApplication.class, args);
    }
}