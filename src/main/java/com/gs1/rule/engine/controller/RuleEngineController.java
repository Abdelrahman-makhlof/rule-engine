package com.gs1.rule.engine.controller;

import com.gs1.rule.engine.mapper.PaymentTransactionMapper;
import com.gs1.rule.engine.model.PaymentTransactionDTO;
import com.gs1.rule.engine.model.RuleExecutionResponse;
import com.gs1.rule.engine.service.RuleEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/engine")
public class RuleEngineController {

    private final RuleEngineService ruleEngineService;

    public RuleEngineController(RuleEngineService ruleEngineService) {
        this.ruleEngineService = ruleEngineService;
    }

    @PostMapping("/execute")
    public ResponseEntity<RuleExecutionResponse> executeRules(@RequestBody PaymentTransactionDTO transaction) {
        return ResponseEntity.ok(ruleEngineService.applyRules(transaction));
    }

}
