package fr.ustephan.codekata.backtocheckout;

import java.util.Optional;

class PricingRule {

    private final Item item;
    private final Double unitPrice;
    private final Optional<SpecialPricingRule> specialPricing;

    PricingRule(final Item item, final Double unitPrice) {
        this(item, unitPrice, null);
    }

    PricingRule(final Item item, final Double unitPrice, final SpecialPricingRule specialPricing) {
        if (item == null) {
            throw new RuntimeException("The item must not be null");
        }
        if (unitPrice <= 0d) {
            throw new RuntimeException("The price must be above 0.00");
        }
        this.item = item;
        this.unitPrice = unitPrice;
        this.specialPricing = Optional.ofNullable(specialPricing);
    }

    Item getItem() {
        return item;
    }

    Double getUnitPrice() {
        return unitPrice;
    }

    Optional<SpecialPricingRule> getSpecialPricingRule() {
        return specialPricing;
    }

    Double getPriceFor(final int quantity) {
        double price = 0d;
        int q = quantity;

        if (this.specialPricing.isPresent()) {
            final SpecialPricingRule sp = this.specialPricing.get();

            while (q >= sp.getApplicableNumberOfItems()) {
                q -= sp.getApplicableNumberOfItems();
                price += sp.getNewPrice();
            }
        }

        return (unitPrice * q) + price;
    }
}
