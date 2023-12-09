package com.vovi.backend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Component
public class EndpointsListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);

        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        handlerMethods.forEach((info, method) -> {
            try {
                String completeUrl = getCompleteUrl(info);
                System.out.println("Mapped URL: " + completeUrl);
                System.out.println("Mapped Method: " + method);
            } catch (Exception e) {
                e.getMessage();
            }
            // You can add more information as needed
        });
    }

    private String getCompleteUrl(RequestMappingInfo info) {
        StringBuilder urlBuilder = new StringBuilder();

        assert info.getPatternsCondition() != null;
        info.getPatternsCondition().getPatterns().forEach(urlBuilder::append);

        return urlBuilder.toString();
    }
}

