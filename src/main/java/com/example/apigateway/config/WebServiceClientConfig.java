package com.example.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Webサービス設定クラス
 * SOAP Webサービスに関するBean定義を提供する
 */
@Configuration
public class WebServiceClientConfig {

    @Value("${soap.server.endpoint.uri}")
    private String soapEndpointUri;

    /**
     * JAXB2マーシャラーを設定するBean
     * XMLとJavaオブジェクト間の変換を担当
     * 
     * @return 設定済みのJaxb2Marshallerインスタンス
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // JAXBが処理するパッケージを指定
        marshaller.setContextPath("com.example.apigateway.webservice");
         marshaller.setSupportJaxbElementClass(true);
        return marshaller;
    }

    /**
     * Webサービステンプレートを設定するBean
     * SOAP Webサービスとの通信を担当
     * 
     * @param marshaller XML変換用マーシャラー
     * @return 設定済みのWebServiceTemplateインスタンス
     */
    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        // マーシャラーを設定（Javaオブジェクト→XML）
        webServiceTemplate.setMarshaller(marshaller);
        // アンマーシャラーを設定（XML→Javaオブジェクト）
        webServiceTemplate.setUnmarshaller(marshaller);
        // デフォルトのWebサービスエンドポイントURIを設定
        webServiceTemplate.setDefaultUri(soapEndpointUri);
       
        return webServiceTemplate;
    }
    
}