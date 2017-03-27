package com.example.config;

import com.example.interceptor.MyInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;

@Configuration
public class MainConfig {

    @Autowired
    private MyInterceptors myInterceptors;

    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();

        LinkedList<ClientHttpRequestInterceptor> clientHttpRequestInterceptors = new LinkedList<>();
        clientHttpRequestInterceptors.add(myInterceptors);

        restTemplate.setInterceptors(clientHttpRequestInterceptors);
        return restTemplate;
    }
}
