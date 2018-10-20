package com.dadagum.team.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    /**
     * 增加跨域支持(CORS方式)
     * 返回的token字段中承载jwt
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost")
                        .allowedMethods("PUT", "DELETE")
                        .allowedHeaders("Authorization")
                        .exposedHeaders("token")
                        .allowCredentials(true).maxAge(3600);
            }
        };
    }
}
