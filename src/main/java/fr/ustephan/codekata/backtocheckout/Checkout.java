package fr.ustephan.codekata.backtocheckout;

import java.util.HashMap;
import java.util.Map;

class Checkout {

    private final PricingRules pricingRules;
    private final Map<Item, Integer> scannedItems;

    Checkout(final PricingRules pricingRules) {
        if (pricingRules == null || pricingRules.getRules().isEmpty()) {
            throw new RuntimeException("Checkout need at list one pricing rule");
        }
        this.pricingRules = pricingRules;
        this.scannedItems = new HashMap<>();
    }

    void scan(final Item item) {
        if (!scannedItems.containsKey(item)) {
            scannedItems.put(item, 0);
        }
        final var value = scannedItems.get(item) + 1;
        scannedItems.put(item, value);
    }

    Double getTotal() {
        return scannedItems.entrySet().stream()
                .map(entry -> pricingRules.getRuleForItem(entry.getKey()).getPriceFor(entry.getValue()))
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
