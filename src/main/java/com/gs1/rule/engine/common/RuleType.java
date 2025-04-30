package com.gs1.rule.engine.common;

import lombok.Getter;

@Getter
public enum RuleType {

    ENRICHMENT("Enrichment"),
    ROUTING("Routing");

    private String name;

    RuleType(String name) {
        this.name = name;
    }
}
