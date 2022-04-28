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
        System.out.println(hand);
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
}
