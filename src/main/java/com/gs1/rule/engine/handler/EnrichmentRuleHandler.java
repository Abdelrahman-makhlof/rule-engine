package com.gs1.rule.engine.handler;

import com.gs1.rule.engine.common.RuleType;
import com.gs1.rule.engine.db.entity.BusinessRule;
import com.gs1.rule.engine.db.entity.PaymentTransaction;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnrichmentRuleHandler extends RuleHandler {

    private final ExpressionParser parser;
    private final EvaluationContext context;

    public EnrichmentRuleHandler(ExpressionParser parser, EvaluationContext context) {
        this.parser = parser;
        this.context = context;
    }

    @Override
    public RuleType getType() {
        return RuleType.ENRICHMENT;
    }

    @Override
    public void applyRules(List<BusinessRule> rules, PaymentTransaction input, PaymentTransaction output, List<String> appliedRules) {
        for (BusinessRule rule : rules) {
            if (evaluateCondition(rule.getCondition(), input)) {
                applyAction(rule.getAction(), output);
                appliedRules.add(rule.getName());
            }
        }
    }

}
