package fr.ustephan.codekata.backtocheckout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    private static final Item ITEM_A = new Item("A", "tomato");
    private static final Item ITEM_B = new Item("B", "cereals");
    private static final Item ITEM_C = new Item("C", "milk");
    private static final Item ITEM_D = new Item("D", "tooth brush");

    @Test(expected = RuntimeException.class)
    public void shouldEmitAnErrorIfPricingRulesIsNullAtCreation() {
        new Checkout(null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldEmitAnErrorIfNoPricingRulesArePresentAtCreation() {
        new Checkout(new PricingRules());
    }

    @Test
    public void shouldReturnTheCorrectTotal() {
        final var checkout = new Checkout(getPricingRules());
        checkout.scan(ITEM_A);
        checkout.scan(ITEM_B);
        assertEquals(59.55d, checkout.getTotal(), 1d);
    }

    @Test
    public void shouldReturnTheCorrectTotalWhenSpecialPriceItems() {
        final var checkout = new Checkout(getPricingRules());
        checkout.scan(ITEM_A);
        checkout.scan(ITEM_D);
        checkout.scan(ITEM_D);
        checkout.scan(ITEM_D);
        assertEquals(19d, checkout.getTotal(), 1d);
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