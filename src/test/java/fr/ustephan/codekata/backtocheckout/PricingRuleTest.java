package fr.ustephan.codekata.backtocheckout;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PricingRuleTest {

    private static final Item ITEM = new Item("A", "tomato");

    @Test
    void shouldCreateAPricingGoodWithNoSpecialPrice() {
        final var pricingRule = new PricingRule(ITEM, 31.49d);
        assertThat(pricingRule.getItem()).isSameAs(ITEM);
        assertThat(pricingRule.getUnitPrice()).isEqualTo(31.49d);
        assertThat(pricingRule.getSpecialPricingRule()).isEmpty();
    }

    @Test
    void shouldCreateAPricingGoodWithSpecialPrice() {
        final var specialPricingRule = new SpecialPricingRule(2, 100d);
        final var pricingRule = new PricingRule(ITEM, 60.01d, specialPricingRule);

        assertThat(pricingRule.getItem()).isSameAs(ITEM);
        assertThat(pricingRule.getUnitPrice()).isEqualTo(60.01d);
        assertThat(pricingRule.getSpecialPricingRule())
                .isNotEmpty()
                .containsSame(specialPricingRule);
    }

    @Test
    void shouldEmitAnErrorIfPriceIsBelowZero() {
        assertThat(catchThrowable(() -> new PricingRule(ITEM, -0.5d))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldEmitAnErrorIfPriceIsEqualToZero() {
        assertThat(catchThrowable(() -> new PricingRule(ITEM, 0d))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldEmitAnErrorIfItemIsNull() {
        assertThat(catchThrowable(() -> new PricingRule(null, 12d))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldReturnTheCorrectPriceWhenPlainPrice() {
        final var pricingRule = new PricingRule(ITEM, 10d);
        assertThat(pricingRule.getPriceFor(0)).isEqualTo(0d);
        assertThat(pricingRule.getPriceFor(1)).isEqualTo(10d);
        assertThat(pricingRule.getPriceFor(3)).isEqualTo(30d);
        assertThat(pricingRule.getPriceFor(7)).isEqualTo(70d);
    }

    @Test
    void shouldReturnTheCorrectPriceWhenFloatPrice() {
        final var pricingRule = new PricingRule(ITEM, 1.89d);
        assertThat(pricingRule.getPriceFor(0)).isEqualTo(0d);
        assertThat(pricingRule.getPriceFor(1)).isEqualTo(1.89d);
        assertThat(pricingRule.getPriceFor(4)).isEqualTo(7.56d);
        assertThat(pricingRule.getPriceFor(9)).isEqualTo(17.01d);
    }

    @Test
    void shouldReturnTheCorrectPriceWhenSpecialPricingAdded() {
        // 3 items for 6$
        final var specialPricingRule = new SpecialPricingRule(3, 6d);
        final var pricingRule = new PricingRule(ITEM, 2.5d, specialPricingRule);

        assertThat(pricingRule.getPriceFor(2)).isEqualTo(5d);
        assertThat(pricingRule.getPriceFor(3)).isEqualTo(6d);
        assertThat(pricingRule.getPriceFor(4)).isEqualTo(8.5d);
        assertThat(pricingRule.getPriceFor(6)).isEqualTo(12d);
    }
}