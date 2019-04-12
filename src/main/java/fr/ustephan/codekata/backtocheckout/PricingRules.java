package fr.ustephan.codekata.backtocheckout;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class PricingRules {

    private final Map<String, PricingRule> rules;

    PricingRules() {
        rules = new HashMap<>();
    }

    PricingRules addRule(final PricingRule pricingRule) {
        final var itemId = pricingRule.getItem().getId();
        if (this.rules.containsKey(itemId)) {
            throw new RuntimeException("The item " + itemId + "already have a rule");
        }
        this.rules.put(itemId, pricingRule);
        return this;
    }

    PricingRule getRuleForItem(final Item item) {
        return rules.get(item.getId());
    }

    Map<String, PricingRule> getRules() {
        return Collections.unmodifiableMap(rules);
    }
}
