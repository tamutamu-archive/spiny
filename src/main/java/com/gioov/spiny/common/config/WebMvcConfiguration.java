package com.gioov.spiny.common.config;

import com.gioov.spiny.common.constant.Api;
import com.gioov.spiny.common.constant.Page;
import com.gioov.spiny.common.constant.Url;
import com.gioov.spiny.common.interceptor.ApiInterceptor;
import com.gioov.spiny.common.interceptor.WebInterceptor;
import com.gioov.spiny.common.property.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author godcheese
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Autowired
    private AppProperties appProperties;

    @Bean
    public WebInterceptor webInterceptor() {
        return new WebInterceptor();
    }

    @Bean
    public ApiInterceptor apiInterceptor() {
        return new ApiInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // WebInterceptor
        registry.addInterceptor(webInterceptor())
                .addPathPatterns(Url.ALL_PATH_PATTERN)
                .excludePathPatterns(Page.STATIC);

        // ApiInterceptor
        registry.addInterceptor(apiInterceptor())
                .addPathPatterns(Api.API_PATH_PATTERN).excludePathPatterns(Page.STATIC);


//
//        // Oauth2Interceptor
//        registry.addInterceptor(oauth2Interceptor()).addPathPatterns(OAUTH2_PATH_PATTERN);
//
//        // GenerateCsrfTokenInterceptor
//        registry.addInterceptor(generateCsrfTokenInterceptor()).addPathPatterns(WEB_PATH_PATTERN)
//                .excludePathPatterns(API_PATH_PATTERN, OAUTH2_PATH_PATTERN);
//
//        // VerifyCsrfInterceptor
//        registry.addInterceptor(verifyCsrfTokenInterceptor()).addPathPatterns(API_PATH_PATTERN);

    }

}
