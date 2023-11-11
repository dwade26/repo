package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	Property propertyOne, property2, property3, property4;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
		property2 = new Property(propertyOne);
		property3 = new Property();
		property4 = new Property("Property 4", "Silver Spring", 2000.00, "Bank of America", 1,1,10,5);
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = property2 = property3 = property4 = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property ABC", propertyOne.getPropertyName());
		assertEquals("Property ABC", property2.getPropertyName());
		assertEquals("", property3.getPropertyName());
		assertEquals("Property 4", property4.getPropertyName());
	}
	
	@Test
	void testGetCity() {
		assertEquals("Wells Fargo Bank", propertyOne.getOwner());
		assertEquals("Wells Fargo Bank", property2.getOwner());
		assertEquals("", property3.getOwner());
		assertEquals("Bank of America", property4.getOwner());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, propertyOne.getRentAmount());
		assertEquals(2450.00, property2.getRentAmount());
		assertEquals(0, property3.getRentAmount());
		assertEquals(2000.00, property4.getRentAmount());
	}
	
	@Test
	void testGetOwner() {
		assertEquals("Rockville", propertyOne.getCity());
		assertEquals("Rockville", property2.getCity());
		assertEquals("", property3.getCity());
		assertEquals("Silver Spring", property4.getCity());
	}


	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
		assertEquals("0,0,1,1", property2.getPlot().toString());
		assertEquals("0,0,1,1", property3.getPlot().toString());
		assertEquals("1,1,10,5", property4.getPlot().toString());
	}

	@Test
	void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0",propertyOne.toString());
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0",property2.toString());
		assertEquals(",,,0.0",property3.toString());
		assertEquals("Property 4,Silver Spring,Bank of America,2000.0",property4.toString());
	}

}
