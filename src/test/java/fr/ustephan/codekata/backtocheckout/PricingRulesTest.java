package fr.ustephan.codekata.backtocheckout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PricingRulesTest {

    private static final Item ITEM_A = new Item("A", "tomato");
    private static final Item ITEM_B = new Item("B", "cereals");
    private static final Item ITEM_C = new Item("C", "milk");
    private static final Item ITEM_D = new Item("D", "tooth brush");
    private static final Item ITEM_D_Prime = new Item("D", "soap");

    private PricingRules pricingRules;

    @BeforeEach
    void setUp() {
        pricingRules = new PricingRules();
    }

    @Test
    void shouldAddRulesCorrectly() {
        final var r1 = new PricingRule(ITEM_A, 9d);
        final var r2 = new PricingRule(ITEM_B, 50.87d);
        final var r3 = new PricingRule(ITEM_C, 5d, new SpecialPricingRule(2, 9d));
        final var r4 = new PricingRule(ITEM_D, 1.78d);

        final var rules = pricingRules.addRule(r1).addRule(r2).addRule(r3).addRule(r4).getRules();

        assertThat(rules.size()).isEqualTo(4);
        assertThat(rules.get(ITEM_A.getId())).isSameAs(r1);
        assertThat(rules.get(ITEM_B.getId())).isSameAs(r2);
        assertThat(rules.get(ITEM_C.getId())).isSameAs(r3);
        assertThat(rules.get(ITEM_D.getId())).isSameAs(r4);
    }

    @Test
    void shouldEmitAnErrorIfItemAlreadyHaveARule() {
        assertThat(catchThrowable(() -> {
            final var r1 = new PricingRule(ITEM_D, 5d);
            final var r2 = new PricingRule(ITEM_D_Prime, 5.89d, new SpecialPricingRule(2, 7d));

            pricingRules.addRule(r1).addRule(r2).getRules();
        })).isInstanceOf(RuntimeException.class);
    }
}