package com.gs1.rule.engine.service;

import com.gs1.rule.engine.db.entity.BusinessRule;
import com.gs1.rule.engine.db.repository.BusinessRuleRepository;
import com.gs1.rule.engine.exception.RuleNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {

    private final BusinessRuleRepository businessRuleRepository;

    public RuleService(BusinessRuleRepository businessRuleRepository) {
        this.businessRuleRepository = businessRuleRepository;
    }


    public BusinessRule getRuleById(Long id) throws RuleNotFoundException {

        var rule = businessRuleRepository.findById(id);
        if (rule.isPresent())
            return rule.get();
        else
            throw new RuleNotFoundException("No rule found");

    }

    public List<BusinessRule> getAllRules() {
        return businessRuleRepository.findAll();
    }

    public BusinessRule createRule(BusinessRule rule) {
        return businessRuleRepository.save(rule);
    }

    public BusinessRule updateRule(Long id, BusinessRule rule) throws RuleNotFoundException {
       var entity = getRuleById(id);
        rule.setId(entity.getId());
        return businessRuleRepository.save(rule);
    }

    public String deleteRule(Long id) throws RuleNotFoundException {
        getRuleById(id);
        businessRuleRepository.deleteById(id);
        return "Rule deleted";
    }
}
