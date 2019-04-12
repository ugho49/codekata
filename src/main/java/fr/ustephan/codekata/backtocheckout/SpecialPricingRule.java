package fr.ustephan.codekata.backtocheckout;

public class SpecialPricingRule {

    private final int applicableNumberOfItems;
    private final double newPrice;

    SpecialPricingRule(int applicableNumberOfItems, double newPrice) {
        this.applicableNumberOfItems = applicableNumberOfItems;
        this.newPrice = newPrice;
    }

    public int getApplicableNumberOfItems() {
        return applicableNumberOfItems;
    }

    public double getNewPrice() {
        return newPrice;
    }
}
