import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MainTests {

    @Test
    public void testAceClubsHasProperToString() {
        Card card = new Card(CardRank.ACE, Suit.CLUBS);
        Assert.assertEquals("Ac", card.toString());
    }

    @Test
    public void testConstructedDeckHas52Cards() {
        Deck deck = new Deck();
        Assert.assertEquals(52, deck.getCount());
    }

    @Test
    public void testDealCardDealsCardAndReducesDeckSize() {
        Deck deck = new Deck();
        final int originalSize = deck.getCount();
        Card card = deck.dealCard();
        Assert.assertEquals(Suit.class, card.getSuit().getClass());
        Assert.assertEquals(CardRank.class, card.getRank().getClass());
        Assert.assertEquals(originalSize - 1, deck.getCount());
    }

    @Test
    public void testDealHandDealsTheRightSizeAndDeckSizeIsRightToo() {
        Deck deck = new Deck();
        final int originalSize = deck.getCount();
        ArrayList<Card> hand = deck.getHand();
        Assert.assertEquals(5, hand.size());
        Assert.assertEquals(originalSize - 5, deck.getCount());
    }

    @Test
    public void testFourOfAKindHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.ACE, Suit.CLUBS));
        cards.add(new Card(CardRank.ACE, Suit.HEARTS));
        cards.add(new Card(CardRank.ACE, Suit.SPADES));
        cards.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Four of a kind", handRank);
    }

    @Test
    public void testFullHouseHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.ACE, Suit.CLUBS));
        cards.add(new Card(CardRank.ACE, Suit.HEARTS));
        cards.add(new Card(CardRank.FOUR, Suit.SPADES));
        cards.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Full house", handRank);
    }

    @Test
    public void testFlushHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.THREE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Flush", handRank);
    }

    @Test
    public void testStraightFlushHandAceLow() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.TWO, Suit.DIAMONDS));
        cards.add(new Card(CardRank.THREE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Straight flush", handRank);
    }

    @Test
    public void testStraightFlushHandNoAce() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        cards.add(new Card(CardRank.TWO, Suit.DIAMONDS));
        cards.add(new Card(CardRank.THREE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Straight flush", handRank);
    }

    @Test
    public void testRoyalFlushHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.HEARTS));
        cards.add(new Card(CardRank.KING, Suit.HEARTS));
        cards.add(new Card(CardRank.JACK, Suit.HEARTS));
        cards.add(new Card(CardRank.QUEEN, Suit.HEARTS));
        cards.add(new Card(CardRank.TEN, Suit.HEARTS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Royal flush", handRank);
    }

    @Test
    public void testStraightHandHighNumsNoAce() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.NINE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.JACK, Suit.DIAMONDS));
        cards.add(new Card(CardRank.TEN, Suit.CLUBS));
        cards.add(new Card(CardRank.QUEEN, Suit.HEARTS));
        cards.add(new Card(CardRank.KING, Suit.SPADES));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Straight", handRank);
    }

    @Test
    public void testStraightHandLowNumsNoAce() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        cards.add(new Card(CardRank.TWO, Suit.DIAMONDS));
        cards.add(new Card(CardRank.THREE, Suit.CLUBS));
        cards.add(new Card(CardRank.FOUR, Suit.HEARTS));
        cards.add(new Card(CardRank.FIVE, Suit.SPADES));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Straight", handRank);
    }

    @Test
    public void testStraightHandLowNumsWithAce() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.TWO, Suit.DIAMONDS));
        cards.add(new Card(CardRank.THREE, Suit.CLUBS));
        cards.add(new Card(CardRank.FOUR, Suit.HEARTS));
        cards.add(new Card(CardRank.FIVE, Suit.SPADES));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Straight", handRank);
    }

    @Test
    public void testStraightHandHighNumsWithAce() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.JACK, Suit.DIAMONDS));
        cards.add(new Card(CardRank.TEN, Suit.CLUBS));
        cards.add(new Card(CardRank.QUEEN, Suit.HEARTS));
        cards.add(new Card(CardRank.KING, Suit.SPADES));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Straight", handRank);
    }

    @Test
    public void testGetNumericRankLowAce() {
        Assert.assertEquals(1, HandRankEngine.getNumericRank(CardRank.ACE, true));
    }

    @Test
    public void testGetNumericRankHighAce() {
        Assert.assertEquals(14, HandRankEngine.getNumericRank(CardRank.ACE, false));
    }

    @Test
    public void testGetNumericRankNonAceJack() {
        Assert.assertEquals(11, HandRankEngine.getNumericRank(CardRank.JACK, false));
    }

    @Test
    public void testGetNumericRankNonAceFour() {
        Assert.assertEquals(4, HandRankEngine.getNumericRank(CardRank.FOUR, false));
    }

    @Test
    public void testThreeOfAKindHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.ACE, Suit.CLUBS));
        cards.add(new Card(CardRank.ACE, Suit.HEARTS));
        cards.add(new Card(CardRank.FOUR, Suit.SPADES));
        cards.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Three of a kind", handRank);
    }

    @Test
    public void testTwoPairHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.ACE, Suit.CLUBS));
        cards.add(new Card(CardRank.FOUR, Suit.HEARTS));
        cards.add(new Card(CardRank.FOUR, Suit.SPADES));
        cards.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("Two pair", handRank);
    }

    @Test
    public void testOnePairHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.ACE, Suit.CLUBS));
        cards.add(new Card(CardRank.FOUR, Suit.HEARTS));
        cards.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("One pair", handRank);
    }

    @Test
    public void testAceCardHighHand() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.ACE, Suit.CLUBS));
        cards.add(new Card(CardRank.THREE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        cards.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(cards);
        Assert.assertEquals("High card", handRank);
    }

}
