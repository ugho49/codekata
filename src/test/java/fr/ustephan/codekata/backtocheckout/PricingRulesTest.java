package fr.ustephan.codekata.backtocheckout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class PricingRulesTest {

    private static final Item ITEM_A = new Item("A", "tomato");
    private static final Item ITEM_B = new Item("B", "cereals");
    private static final Item ITEM_C = new Item("C", "milk");
    private static final Item ITEM_D = new Item("D", "tooth brush");
    private static final Item ITEM_D_Prime = new Item("D", "soap");

    private PricingRules pricingRules;

    @Before
    public void setUp() {
        pricingRules = new PricingRules();
    }

    @Test
    public void shouldAddRulesCorrectly() {
        final var r1 = new PricingRule(ITEM_A, 9d);
        final var r2 = new PricingRule(ITEM_B, 50.87d);
        final var r3 = new PricingRule(ITEM_C, 5d, new SpecialPricingRule(2, 9d));
        final var r4 = new PricingRule(ITEM_D, 1.78d);

        final var rules = pricingRules.addRule(r1).addRule(r2).addRule(r3).addRule(r4).getRules();
        assertEquals(4, rules.size());
        assertSame(r1, rules.get(ITEM_A.getId()));
        assertSame(r2, rules.get(ITEM_B.getId()));
        assertSame(r3, rules.get(ITEM_C.getId()));
        assertSame(r4, rules.get(ITEM_D.getId()));
    }

    @Test(expected=RuntimeException.class)
    public void shouldEmitAnErrorIfItemAlreadyHaveARule() {
        final var r1 = new PricingRule(ITEM_D, 5d);
        final var r2 = new PricingRule(ITEM_D_Prime, 5.89d, new SpecialPricingRule(2, 7d));

        pricingRules.addRule(r1).addRule(r2).getRules();
    }
}