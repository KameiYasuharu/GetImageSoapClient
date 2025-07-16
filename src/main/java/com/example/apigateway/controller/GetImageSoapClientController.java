package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.apigateway.webservice.GetImageRequest;
import com.example.apigateway.webservice.GetImageResponse;

/**
 * 画像取得処理を行うRESTコントローラークラス
 * 
 * <p>クライアントからのリクエストを受け付け、画像取得サービスを呼び出します。</p>
 */
@RestController // (1) RESTコントローラーとして登録（@Controller + @ResponseBody）
@RequestMapping // ベースURLマッピング
public class GetImageSoapClientController {

	// SOAP通信を行うためのテンプレート
	private final WebServiceTemplate webServiceTemplate;

	/**
	 * コンストラクタ
	 * @param webServiceTemplate Spring WSのWebサービステンプレート
	 */
	public GetImageSoapClientController(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

	/**
	 * 画像取得APIエンドポイント
	 * 
	 * <p>GETリクエストで受け取った画像を返します。</p>
	 * 
	 * @param request 変換リクエスト（画像名前を含む）
	 * @return 
	 * @return 画像取得を含むレスポンス
	 */
	@GetMapping("/getImage") // (2) /image パスへのGETリクエストを処理
	@ResponseBody // 戻り値を直接レスポンスボディとして返却
	public GetImageResponse getImageSoapClient(@ModelAttribute GetImageRequest request) {

		return (GetImageResponse) webServiceTemplate.marshalSendAndReceive(request);

	}
}