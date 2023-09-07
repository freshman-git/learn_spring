package com.example.config;

import com.example.inceptor.LoginInterceptor;
import com.example.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }

//    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
//                设置为false，让矩阵变量生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if (!StringUtils.isEmpty(source)){
                            String[] split = source.split(",");
                            Pet pet = new Pet();
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }

//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginInterceptor())
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/","/css/**");
//            }
        };
    }
}
