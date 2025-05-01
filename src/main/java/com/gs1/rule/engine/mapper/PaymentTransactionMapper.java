package com.gs1.rule.engine.mapper;

import com.gs1.rule.engine.db.entity.PaymentTransaction;
import com.gs1.rule.engine.model.PaymentTransactionDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentTransactionMapper {

    public PaymentTransactionDTO toDto(PaymentTransaction entity) {
        var dto = new PaymentTransactionDTO();
        dto.setAmount(entity.getAmount());
        dto.setCurrency(entity.getCurrency());
        dto.setDirection(entity.getDirection());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PaymentTransaction toEntity(PaymentTransactionDTO dto) {
        var entity = new PaymentTransaction();
        entity.setAmount(dto.getAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setDirection(dto.getDirection());
        entity.setType(dto.getType());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public List<PaymentTransactionDTO> toDtoList(List<PaymentTransaction> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
