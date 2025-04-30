package com.gs1.rule.engine.handler;

import com.gs1.rule.engine.common.RuleType;
import com.gs1.rule.engine.db.entity.BusinessRule;
import com.gs1.rule.engine.db.entity.PaymentTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

public abstract class RuleHandler {

    @Autowired
    private ExpressionParser parser;
    @Autowired
    private EvaluationContext context;


    abstract RuleType getType();

    public abstract void applyRules(List<BusinessRule> rules, PaymentTransaction input, PaymentTransaction output, List<String> appliedRules);


    boolean evaluateCondition(String condition, PaymentTransaction input) {
        try {
            StandardEvaluationContext context = new StandardEvaluationContext(input);
//            context.setVariable("input", input);
            Expression expression = parser.parseExpression(condition);
            return Boolean.TRUE.equals(expression.getValue(context, Boolean.class));
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating condition: " + condition, e);
        }
    }

    void applyAction(String action, PaymentTransaction output) {
        try {
            StandardEvaluationContext context = new StandardEvaluationContext(output);
          parser.parseExpression(action).getValue(context);
        } catch (Exception e) {
            throw new RuntimeException("Error executing action: " + action, e);
        }
    }
}
