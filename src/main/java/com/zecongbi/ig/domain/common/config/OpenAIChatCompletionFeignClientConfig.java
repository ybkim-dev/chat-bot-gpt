package com.zecongbi.ig.domain.common.config;

import feign.RequestInterceptor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Data
@EnableFeignClients("com.zecongbi.ig.domain.question.model")
@Configuration
public class OpenAIChatCompletionFeignClientConfig {

  @Value("${openai.api-key}")
  private String apiKey;

  @Value("${openai.gpt-model}")
  private String model;

  @Value("${openai.mode}")
  private String role;

  @Bean
  public RequestInterceptor apiKeyInterceptor() {
    return request -> request.header("Authorization", "Bearer " + apiKey);
  }

}
