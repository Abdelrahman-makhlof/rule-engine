package com.gs1.rule.engine.mapper;

import com.gs1.rule.engine.db.entity.BusinessRule;
import com.gs1.rule.engine.model.RuleDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RuleMapper {

    public RuleDTO toDto(BusinessRule entity) {
        var dto = new RuleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRuleType(entity.getRuleType());
        dto.setCondition(entity.getCondition());
        dto.setAction(entity.getAction());
        dto.setPriority(entity.getPriority());
        return dto;
    }

    public BusinessRule toEntity(RuleDTO dto) {
        var entity = new BusinessRule();
        entity.setName(dto.getName());
        entity.setRuleType(dto.getRuleType());
        entity.setCondition(dto.getCondition());
        entity.setAction(dto.getAction());
        entity.setPriority(dto.getPriority());
        return entity;
    }

    public List<RuleDTO> toDtoList(List<BusinessRule> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
