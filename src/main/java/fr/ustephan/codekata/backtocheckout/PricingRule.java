package fr.ustephan.codekata.backtocheckout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static java.math.RoundingMode.HALF_UP;

class PricingRule {

    private final Item item;
    private final BigDecimal unitPrice;
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
        this.unitPrice = new BigDecimal(unitPrice);
        this.specialPricing = Optional.ofNullable(specialPricing);
    }

    Item getItem() {
        return item;
    }

    Double getUnitPrice() {
        return unitPrice.doubleValue();
    }

    Optional<SpecialPricingRule> getSpecialPricingRule() {
        return specialPricing;
    }

    Double getPriceFor(final int quantity) {
        BigDecimal price = new BigDecimal(0);
        int remainQuantity = quantity;

        if (this.specialPricing.isPresent()) {
            final SpecialPricingRule sp = this.specialPricing.get();

            while (remainQuantity >= sp.getApplicableNumberOfItems()) {
                remainQuantity -= sp.getApplicableNumberOfItems();
                price = price.add(new BigDecimal(sp.getNewPrice()));
            }
        }

        return unitPrice
                .multiply(new BigDecimal(remainQuantity))
                .add(price)
                .setScale(2, HALF_UP)
                .doubleValue();
    }
}
