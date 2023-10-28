package application;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("CHICKEN"));
		assertTrue(CryptoManager.isStringInBounds("_I LIKE CHOCOLATE"));
		assertFalse(CryptoManager.isStringInBounds("chocolate"));
		assertFalse(CryptoManager.isStringInBounds("|JAVA"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE ~ IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hi", 22));
		assertEquals("EFG", CryptoManager.caesarEncryption("BCD", 3));
		assertEquals("&'(", CryptoManager.caesarEncryption("BCD", 100));
		assertEquals("63::=", CryptoManager.caesarEncryption("HELLO", 110));
		assertEquals("MNOPQ", CryptoManager.caesarEncryption("LMNOP", 1));
		
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("LMNOP", CryptoManager.caesarDecryption("MNOPQ", 1));
		assertEquals("BCD", CryptoManager.caesarDecryption("&'(", 100));
		assertEquals("FCJJM^UMPJB", CryptoManager.caesarDecryption("4188;LC;>80", 302));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WN#\\N &", CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_GOOD"));
		assertEquals("BDD", CryptoManager.bellasoEncryption("ABC", "AB"));
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("I Like chocolate", "HELLO"));
		assertEquals("L-L=5SFU\"FA<4WR", CryptoManager.bellasoEncryption("I LIKE CHOCOLATE", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_GOOD"));
		assertEquals("I LIKE CHOCOLATE", CryptoManager.bellasoDecryption("L-L=5SFU\"FA<4WR", "CMSC203"));
		assertEquals("ABC", CryptoManager.bellasoDecryption("BDD", "AB"));

	}

}
