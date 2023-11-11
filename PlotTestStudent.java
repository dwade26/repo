package application;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent {
	private Plot plot1,plot2,plot3,plot4, plot5, plot6, plot7;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot2 = new Plot();
		plot3 = new Plot(plot1);
		plot4 = new Plot(7,6,4,5);
		plot5 = new Plot(3, 4, 4, 3);
		plot6 = new Plot(6,7,4,5);
		plot7 = new Plot(2, 11, 6, 6);
		
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot2 = plot3 = plot4 = plot5= plot6 = plot7 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
		assertTrue(plot1.overlaps(plot3));
		assertFalse(plot5.overlaps(plot4));
		assertFalse(plot5.overlaps(plot6));
		assertTrue(plot1.overlaps(plot5));
		assertTrue(plot4.overlaps(plot6));
		assertFalse(plot1.overlaps(plot7));
	}
	
	@Test
	public void testEncompasses() {
		assertTrue(plot1.encompass(plot5)); // plot5 is entirely inside plot1
		assertTrue(plot1.encompass(plot3));
		assertFalse(plot5.encompass(plot4));
		assertFalse(plot5.encompass(plot6));
	}
	
	@Test
	public void testToString() {
		assertEquals("3,4,4,3",plot5.toString());
		assertEquals("0,0,1,1",plot2.toString());
		assertEquals("2,2,6,6",plot3.toString());
		assertEquals("2,2,6,6",plot1.toString());
	}

}
