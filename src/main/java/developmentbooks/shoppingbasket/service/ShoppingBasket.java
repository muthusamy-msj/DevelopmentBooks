package developmentbooks.shoppingbasket.service;

import developmentbooks.shoppingbasket.model.BasketItem;
import developmentbooks.shoppingbasket.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private List<BasketItem> basketItems = new ArrayList<>();

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
        return 0;
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
