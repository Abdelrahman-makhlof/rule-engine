package com.gs1.rule.engine.controller;

import com.gs1.rule.engine.db.entity.BusinessRule;
import com.gs1.rule.engine.exception.RuleNotFoundException;
import com.gs1.rule.engine.mapper.RuleMapper;
import com.gs1.rule.engine.model.RuleDTO;
import com.gs1.rule.engine.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    private final RuleService ruleService;
    private final RuleMapper mapper;

    public RuleController(RuleService ruleService, RuleMapper mapper) {
        this.ruleService = ruleService;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<List<RuleDTO>> getAllRules() {
        return ResponseEntity.ok(mapper.toDtoList(ruleService.getAllRules()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RuleDTO> getRuleById(@PathVariable Long id) throws RuleNotFoundException {
        return ResponseEntity.ok(mapper.toDto(ruleService.getRuleById(id)));
    }

    @PostMapping
    public ResponseEntity<RuleDTO> createRule(@RequestBody RuleDTO rule) {
        var entity =  ruleService.createRule(mapper.toEntity(rule));
        return ResponseEntity.ok(mapper.toDto(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessRule> updateRule(@PathVariable Long id, @RequestBody RuleDTO ruleDetails) throws RuleNotFoundException {
        return ResponseEntity.ok(ruleService.updateRule(id, mapper.toEntity(ruleDetails)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRule(@PathVariable Long id) throws RuleNotFoundException {
        return ResponseEntity.ok(ruleService.deleteRule(id));
    }
}
