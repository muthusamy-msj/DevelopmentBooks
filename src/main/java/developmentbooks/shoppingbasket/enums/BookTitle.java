package developmentbooks.shoppingbasket.enums;

public enum BookTitle {
	CLEAN_CODE("Clean Code"),
	CLEAN_CODER("The Clean Coder"),
	CLEAN_ARCHITECTURE("Clean Architecture"),
	TEST_DRIVEN_DEVELOPMENT("Test Driven Development by Example"),
	WORKING_EFFECTIVELY("Working Effectively With Legacy Code");

	private String title;
	
    BookTitle(String title) {
    	this.title = title;
    }
    
    public String getTitle() {
    	return this.title;
    }
}
