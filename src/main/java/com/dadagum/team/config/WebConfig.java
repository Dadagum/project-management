package com.dadagum.team.config;

import com.dadagum.team.common.CorsFilter;
import com.dadagum.team.common.interceptor.AuthorizationInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("PUT", "DELETE")
//                .allowedHeaders("*")
//                .exposedHeaders("Authorization")
//                .allowCredentials(false).maxAge(3600);
//
//    }

    /**
     * 增加跨域支持(CORS方式)
     * 返回的token字段中承载jwt
     */


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/registration", "/authentication");
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CorsFilter());
        return registration;
    }

}
