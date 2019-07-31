package fr.ustephan.codekata.backtocheckout;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CheckoutTest {

    private static final Item ITEM_A = new Item("A", "tomato");
    private static final Item ITEM_B = new Item("B", "cereals");
    private static final Item ITEM_C = new Item("C", "milk");
    private static final Item ITEM_D = new Item("D", "tooth brush");

    @Test
    void shouldEmitAnErrorIfPricingRulesIsNullAtCreation() {
        assertThatThrownBy(() -> new Checkout(null)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldEmitAnErrorIfNoPricingRulesArePresentAtCreation() {
        assertThatThrownBy(() -> new Checkout(new PricingRules())).isInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldReturnTheCorrectTotal() {
        final var checkout = new Checkout(getPricingRules());
        checkout.scan(ITEM_A);
        checkout.scan(ITEM_B);
        assertThat(checkout.getTotal()).isEqualTo(59.55d);
    }

    @Test
    void shouldReturnTheCorrectTotalWhenSpecialPriceItems() {
        final var checkout = new Checkout(getPricingRules());
        checkout.scan(ITEM_A);
        checkout.scan(ITEM_D);
        checkout.scan(ITEM_D);
        checkout.scan(ITEM_D);
        assertThat(checkout.getTotal()).isEqualTo(19d);
    }

    private PricingRules getPricingRules() {
        final var rules = new PricingRules();
        rules.addRule(new PricingRule(ITEM_A, 9d))
                .addRule(new PricingRule(ITEM_B, 50.55d))
                .addRule(new PricingRule(ITEM_C, 23.13d))
                .addRule(new PricingRule(ITEM_D, 4d, new SpecialPricingRule(3, 10d)));
        return rules;
    }
}