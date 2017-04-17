package com.inthergroup.internship.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfig {

    @Bean(name = "todoBean")
    public TodoBean getTodoBean() {
        return new TodoBean();
    }
}
