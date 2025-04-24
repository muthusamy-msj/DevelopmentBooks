package developmentbooks.shoppingbasket.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import developmentbooks.shoppingbasket.enums.BookTitle;
import developmentbooks.shoppingbasket.model.Book;

@ExtendWith(MockitoExtension.class)
public class ShoppingBasketTest {

	@InjectMocks
	ShoppingBasket basket;
	
	@Test
	void addTest() {
		Book b1 = new Book(BookTitle.CLEAN_CODE.getTitle());		
		Book b2 = new Book(BookTitle.CLEAN_CODER.getTitle());
		Book b3 = new Book(BookTitle.CLEAN_ARCHITECTURE.getTitle());
		Book b4 = new Book(BookTitle.TEST_DRIVEN_DEVELOPMENT.getTitle());
		Book b5 = new Book(BookTitle.WORKING_EFFECTIVELY.getTitle());
		basket.add(b1);
		basket.add(b1);
		basket.add(b2);
		basket.add(b2);
		basket.add(b3);
		basket.add(b3);
		basket.add(b4);
		basket.add(b5);
		
		
		assertEquals(322.5, basket.calculatePrice());
	}
}
