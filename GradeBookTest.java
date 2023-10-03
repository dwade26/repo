import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook book1;
	private GradeBook book2;
	
	@BeforeEach
	void setUp() throws Exception {
		book1 = new GradeBook(5);
		book2 = new GradeBook(5);
		book1.addScore(97);
		book1.addScore(46);
		book1.addScore(0);
		book1.addScore(12);
		book2.addScore(75);
		book2.addScore(67.56);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}


	@Test
	void testGetScoreSize() {		
		assertEquals(4,book1.getScoreSize());
		assertEquals(2,book2.getScoreSize());
	}

	@Test
	void testAddScore() {		
		assertEquals( "97.0 46.0 0.0 12.0 0.0 ",book1.toString());
		assertEquals("75.0 67.56 0.0 0.0 0.0 ",book2.toString());
	}

	@Test
	void testSum() {
		assertEquals(155,book1.sum());
		assertEquals(142.56,book2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(0,book1.minimum());
		assertEquals(67.56,book2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(155,book1.finalScore());
		assertEquals(75,book2.finalScore());
	}

}
