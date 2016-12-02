package test;

import FourRowSolitaire.*;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class DiscardPileIntegrationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void pushStack_drawCountIsNotOne_addsStackCardsProperly () {
		
		//create new discard pile with draw set to two
		DiscardPile discardPile = new DiscardPile (2);
		
		CardStack cardStack = new CardStack ();
		
		Deck deck = new Deck (1);
		
		deck.shuffle();
		
		List<Card> deckCards = deck.getDeck ();
		
		//get 10 random cards from deck and push add to the card stack		
		for (int i = 0; i < 10; i ++) {
			cardStack.push(deckCards.get(i));
		}
		
		//add card stack to discard pile (discard pile should have ten cards at this point)
		discardPile.push(cardStack);
		
		assertTrue (cardStack.isEmpty());
		
		for (int i = 0; i < 10; i ++) {
			Card discardedCard = discardPile.pop();
			Card deckCard = deckCards.get(i);
			
			assertTrue (cardsAreEqual (discardedCard, deckCard));
		}
		
	}
	
	@Test
	public void pushStack_drawCountIsOne_addStackWithSingleCardProperly () {
		
		//create new discard pile with draw set to one
		DiscardPile discardPile = new DiscardPile (1);
		
		CardStack cardStack = new CardStack ();
		
		Deck deck = new Deck (1);
		
		deck.shuffle();
		
		List<Card> deckCards = deck.getDeck ();
		
		//add a single card to the card deck
		cardStack.push(deckCards.get(0));
		
		//add cards from stack to discard pile
		discardPile.push(cardStack);
		
		assertTrue (cardStack.isEmpty());
		
		//make sure random card matches the card added to the discard pile
		Card discardedCard = discardPile.pop();
		Card deckCard = deckCards.get(0);
			
		assertTrue (cardsAreEqual (discardedCard, deckCard));
		
	}
	
	@Test
	public void pushStack_drawCountIsOne_doesNotAddCardsFromStackWithManyCards () {
		
		//create new discard pile with draw set to one		
		DiscardPile discardPile = new DiscardPile (1);
		
		CardStack cardStack = new CardStack ();
		
		Deck deck = new Deck (1);
		
		deck.shuffle();
		
		List<Card> deckCards = deck.getDeck ();
		
		//add two random cards to card stack		
		for (int i = 0; i < 2; i ++) {
			cardStack.push(deckCards.get(i));
		}
		
		discardPile.push(cardStack);
		
		//card stack should still have two cards
		assertTrue (cardStack.length() == 2);
		
		//discard pile should be empty
		assertTrue (discardPile.isEmpty());
	}
	
	private boolean cardsAreEqual (Card first, Card second) {
    	return first.getSuit ().equals(second.getSuit())
    			&& first.getNumber () == second.getNumber()
    			&& first.getFullNumber() == second.getFullNumber();
	}
}
