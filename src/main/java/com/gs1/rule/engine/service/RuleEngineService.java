package com.gs1.rule.engine.service;

import com.gs1.rule.engine.common.RuleType;
import com.gs1.rule.engine.db.entity.BusinessRule;
import com.gs1.rule.engine.db.entity.PaymentTransaction;
import com.gs1.rule.engine.db.repository.BusinessRuleRepository;
import com.gs1.rule.engine.handler.RuleHandlerFactory;
import com.gs1.rule.engine.mapper.PaymentTransactionMapper;
import com.gs1.rule.engine.model.PaymentTransactionDTO;
import com.gs1.rule.engine.model.RuleExecutionResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleEngineService {

    private final BusinessRuleRepository ruleRepository;
    private final RuleHandlerFactory ruleHandlerFactory;
    private final PaymentTransactionMapper mapper;

    public RuleEngineService(BusinessRuleRepository ruleRepository, RuleHandlerFactory ruleHandlerFactory, PaymentTransactionMapper mapper) {
        this.ruleRepository = ruleRepository;
        this.ruleHandlerFactory = ruleHandlerFactory;
        this.mapper = mapper;
    }


    public RuleExecutionResponse applyRules(PaymentTransactionDTO input) {
        PaymentTransaction paymentTransaction = mapper.toEntity(input);
        PaymentTransaction output = new PaymentTransaction();
        BeanUtils.copyProperties(paymentTransaction, output);
        List<String> appliedRules = new ArrayList<>();

        for (RuleType type : ruleHandlerFactory.getRulesTypes()) {
            List<BusinessRule> rules = ruleRepository.findAllByRuleTypeOrderByPriorityDesc(type);
            var handler = ruleHandlerFactory.getHandler(type);
            if (handler != null && !rules.isEmpty()) {
                handler.applyRules(rules, paymentTransaction, output, appliedRules);
            }
        }

        return new RuleExecutionResponse(mapper.toDto(output),appliedRules.size(), appliedRules);
    }
}
