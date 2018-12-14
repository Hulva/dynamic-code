package hulva.luva.xx.demo.dynamiccode.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hulva Luva.H
 * @date 2018年12月14日
 * @description
 *
 */
@Configuration
public class CommonConfig {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }
}
