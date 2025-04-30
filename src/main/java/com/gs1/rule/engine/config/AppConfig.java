package com.gs1.rule.engine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@Configuration
public class AppConfig {


    @Bean
    ExpressionParser parser() {
        return new SpelExpressionParser();
    }

    @Bean
    @Scope("prototype")
    EvaluationContext context() {
        return new StandardEvaluationContext();
    }
}
