package fr.ustephan.codekata.backtocheckout;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PricingRuleTest {

    private static final Item ITEM = new Item("A", "tomato");

    @Test
    public void shouldCreateAPricingGoodWithNoSpecialPrice() {
        final var pricingRule = new PricingRule(ITEM, 31.49d);
        assertSame(ITEM, pricingRule.getItem());
        assertEquals(31.49d, pricingRule.getUnitPrice(), 1d);
        assertSame(Optional.empty(), pricingRule.getSpecialPricingRule());
    }

    @Test
    public void shouldCreateAPricingGoodWithSpecialPrice() {
        final var specialPricingRule = new SpecialPricingRule(2, 100d);
        final var pricingRule = new PricingRule(ITEM, 60.01d, specialPricingRule);
        assertSame(ITEM, pricingRule.getItem());
        assertEquals(60.01d, pricingRule.getUnitPrice(), 1d);
        assertSame(specialPricingRule, pricingRule.getSpecialPricingRule().orElse(null));
    }

    @Test(expected=RuntimeException.class)
    public void shouldEmitAnErrorIfPriceIsBelowZero() {
        new PricingRule(ITEM, -0.5d);
    }

    @Test(expected=RuntimeException.class)
    public void shouldEmitAnErrorIfPriceIsEqualToZero() {
        new PricingRule(ITEM, 0d);
    }

    @Test(expected=RuntimeException.class)
    public void shouldEmitAnErrorIfItemIsNull() {
        new PricingRule(null, 12d);
    }

    @Test
    public void shouldReturnTheCorrectPriceWhenPlainPrice() {
        final var pricingRule = new PricingRule(ITEM, 10d);
        assertEquals(0d, pricingRule.getPriceFor(0), 1d);
        assertEquals(10d, pricingRule.getPriceFor(1), 1d);
        assertEquals(30d, pricingRule.getPriceFor(3), 1d);
        assertEquals(70d, pricingRule.getPriceFor(7), 1d);
    }

    @Test
    public void shouldReturnTheCorrectPriceWhenFloatPrice() {
        final var pricingRule = new PricingRule(ITEM, 1.89d);
        assertEquals(0d, pricingRule.getPriceFor(0), 1d);
        assertEquals(1.89d, pricingRule.getPriceFor(1), 1d);
        assertEquals(7.56d, pricingRule.getPriceFor(4), 1d);
        assertEquals(17.01d, pricingRule.getPriceFor(9), 1d);
    }

    @Test
    public void shouldReturnTheCorrectPriceWhenSpecialPricingAdded() {
        // 3 items for 6$
        final var specialPricingRule = new SpecialPricingRule(3, 6d);
        final var pricingRule = new PricingRule(ITEM, 2.5d, specialPricingRule);
        assertEquals(5d, pricingRule.getPriceFor(2), 1d);
        assertEquals(6d, pricingRule.getPriceFor(3), 1d);
        assertEquals(8.5, pricingRule.getPriceFor(4), 1d);
        assertEquals(12d, pricingRule.getPriceFor(6), 1d);
    }
}