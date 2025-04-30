package com.gs1.rule.engine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Configuration
public class AppConfig {

    @Bean
    ExpressionParser parser() {
        return new SpelExpressionParser();
    }
}
