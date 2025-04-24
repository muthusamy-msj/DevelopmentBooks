package developmentbooks.shoppingbasket.enums;

public enum DiscountRule {
    PERCENT_2(5),
    PERCENT_3(10),
    PERCENT_4(20),
    PERCENT_5(25);

	int discountPercent;
	
    DiscountRule(int discountPercent) {
    	this.discountPercent = discountPercent;
    }
    public int getValue() {
    	return discountPercent;
    }
}
