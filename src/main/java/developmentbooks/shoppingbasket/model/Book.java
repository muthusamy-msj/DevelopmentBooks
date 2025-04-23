package developmentbooks.shoppingbasket.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Book {
    private String title;
    private double price;

    public Book(String title) {
        this.title = title;
        this.price = 50.00;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
