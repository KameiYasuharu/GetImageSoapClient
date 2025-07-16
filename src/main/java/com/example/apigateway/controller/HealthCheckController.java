package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // (1) RESTコントローラーとして登録（@Controller + @ResponseBody）
@RequestMapping // ベースURLマッピング
public class HealthCheckController {

	@GetMapping("/health")
	@ResponseBody // 戻り値を直接レスポンスボディとして返却
	public String health() {

		return "Health check OK！";

	}
}