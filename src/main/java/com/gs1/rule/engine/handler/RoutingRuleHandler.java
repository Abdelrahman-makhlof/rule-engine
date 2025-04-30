package com.gs1.rule.engine.handler;

import com.gs1.rule.engine.common.RuleType;
import com.gs1.rule.engine.db.entity.BusinessRule;
import com.gs1.rule.engine.db.entity.PaymentTransaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoutingRuleHandler extends RuleHandler {

    @Override
    public RuleType getType() {
        return RuleType.ROUTING;
    }

    @Override
    public void applyRules(List<BusinessRule> rules, PaymentTransaction input, PaymentTransaction output, List<String> appliedRules) {
        for (BusinessRule rule : rules) {
            if (evaluateCondition(rule.getCondition(), input)) {
                applyAction(rule.getAction(), output);
                appliedRules.add(rule.getName());
                break;
            }
        }
    }
}
