package com.gs1.rule.engine.db.repository;

import com.gs1.rule.engine.common.RuleType;
import com.gs1.rule.engine.db.entity.BusinessRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRuleRepository extends JpaRepository<BusinessRule, Long> {

    List<BusinessRule> findAllByRuleTypeOrderByPriorityDesc(RuleType ruleType);
}