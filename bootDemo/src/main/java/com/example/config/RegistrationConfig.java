package com.example.config;

import com.example.filter.MyFilter;
import com.example.listener.MyListener;
import com.example.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@Configuration
public class RegistrationConfig {

//    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet,"/my");
    }

//    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
//        return new FilterRegistrationBean(myFilter,myServlet());
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>(myFilter);
        myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/my"));
        return myFilterFilterRegistrationBean;
    }

//    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyListener myListener = new MyListener();
        return new ServletListenerRegistrationBean(myListener);
    }
}
