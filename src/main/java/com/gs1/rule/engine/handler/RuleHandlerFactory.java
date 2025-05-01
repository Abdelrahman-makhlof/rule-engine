package com.gs1.rule.engine.handler;

import com.gs1.rule.engine.common.RuleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RuleHandlerFactory {

    private final Map<RuleType, RuleHandler> handlerMap = new HashMap<>();

    @Autowired
    public RuleHandlerFactory(List<RuleHandler> handlers) {
        for (RuleHandler handler : handlers) {
            handlerMap.put(handler.getType(), handler);
        }
    }

    public RuleHandler getHandler(RuleType type) {
        return handlerMap.get(type);
    }

    public Set<RuleType> getRulesTypes() {
        return handlerMap.keySet();
    }
}
