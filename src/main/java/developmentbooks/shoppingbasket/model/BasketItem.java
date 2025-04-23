package developmentbooks.shoppingbasket.model;

import lombok.Data;

@Data
public class BasketItem {
    private Book book;
    private int quantity;

    public BasketItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }
}
