package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.CardStack;

public class CardStackTest {

	static CardStack cardStack;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cardStack = new CardStack();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAddCard() {
		assertTrue(true);
	}

	@Test
	public final void testAddStack() {
		assertTrue(true);
	}

	@Test
	public final void testPushCard() {
		assertTrue(true);
	}

	@Test
	public final void testPushCardStack() {
		assertTrue(true);
	}

	@Test
	public final void testPop() {
		assertTrue(true);
	}

	@Test
	public final void testPopCardStack() {
		assertTrue(true);
	}

	@Test
	public final void testPeek() {
		assertTrue(true);
	}

	@Test
	public final void testIsEmpty() {
		assertTrue(true);
	}

	@Test
	public final void testLength() {
		assertTrue(true);
	}
}
