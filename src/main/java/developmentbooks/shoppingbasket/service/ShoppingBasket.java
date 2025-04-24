package developmentbooks.shoppingbasket.service;

import developmentbooks.shoppingbasket.enums.DiscountRule;
import developmentbooks.shoppingbasket.model.BasketItem;
import developmentbooks.shoppingbasket.model.Book;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShoppingBasket {
	
    private List<BasketItem> basketItems = new ArrayList<>();

    public List<BasketItem> getBasketItems() {
		return basketItems;
	}
	public void add(Book book){
        BasketItem item = null;
       //check if book exits in basket already
        item = isBookExist(book);
        if(item != null)
            item.setQuantity(item.getQuantity() + 1);
        else
            basketItems.add(new BasketItem(book,1));
    }
    public double calculatePrice(){
    	 //get count of unique book items
    	log.info("basketItems:"+basketItems);
    	int uniqueCount = basketItems.size();
    	int total = (int) basketItems.stream().map(book -> book.getQuantity()).reduce(0, Integer::sum);
		 int dup = total - uniqueCount;
		 
		 double uniqueCost = uniqueCount * 50;
		 double discount =  percentOf(new BigDecimal(getDiscountPercentage(uniqueCount)), new BigDecimal(uniqueCost)).doubleValue();
		 double totalCost = (uniqueCost - discount);
		 
		 double dupCost = dup * 50;
		 discount =  percentOf(new BigDecimal(getDiscountPercentage(dup)), new BigDecimal(dupCost)).doubleValue();
		 
		 totalCost = totalCost + (dupCost - discount);
		
		 
		 log.info("uniqueCount {}, dup {} , discount {}, totalCost {}",uniqueCount,dup,discount,totalCost);
        
		 return totalCost;
    }
    private BigDecimal percentOf(BigDecimal percentage, BigDecimal total) {
        return percentage.multiply(total).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
    }
    private int getDiscountPercentage(int value) {
    	int discountPercentage = 0;
    	switch(value) {
	    	case 2:
	    		discountPercentage = DiscountRule.PERCENT_2.getValue();
	    			break;
	    	case 3:
	    		discountPercentage = DiscountRule.PERCENT_3.getValue();
					break;
	    	case 4:
	    		discountPercentage = DiscountRule.PERCENT_4.getValue();
					break;
	    	case 5:
	    		discountPercentage = DiscountRule.PERCENT_5.getValue();
				break;
			default:
				discountPercentage = 0;	
    	}
    	log.info("discountPercentage {}",discountPercentage);
    	return discountPercentage;
    }

    private BasketItem isBookExist(Book book) {
        BasketItem basketItem = null;
        for (BasketItem item:basketItems){
            if (item.getBook().equals(book)) {
                basketItem =  item;
                break;
            }
        }
        return basketItem;
    }
}
