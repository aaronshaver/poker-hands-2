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
        Hand hand = deck.getHand();
        Assert.assertEquals(5, hand.size());
        Assert.assertEquals(originalSize - 5, deck.getCount());
    }

    @Test
    public void testFourOfAKindHand() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.ACE, Suit.CLUBS));
        hand.add(new Card(CardRank.ACE, Suit.HEARTS));
        hand.add(new Card(CardRank.ACE, Suit.SPADES));
        hand.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Four of a kind", handRank);
    }

    @Test
    public void testFullHouseHand() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.ACE, Suit.CLUBS));
        hand.add(new Card(CardRank.ACE, Suit.HEARTS));
        hand.add(new Card(CardRank.FOUR, Suit.SPADES));
        hand.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Full house", handRank);
    }

    @Test
    public void testFlushHand() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.THREE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        hand.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Flush", handRank);
    }

    @Test
    public void testStraightFlushHandAceLow() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.TWO, Suit.DIAMONDS));
        hand.add(new Card(CardRank.THREE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        hand.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Straight flush", handRank);
    }

    @Test
    public void testStraightFlushHandNoAce() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        hand.add(new Card(CardRank.TWO, Suit.DIAMONDS));
        hand.add(new Card(CardRank.THREE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        hand.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Straight flush", handRank);
    }

    @Test
    public void testRoyalFlushHand() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.HEARTS));
        hand.add(new Card(CardRank.KING, Suit.HEARTS));
        hand.add(new Card(CardRank.JACK, Suit.HEARTS));
        hand.add(new Card(CardRank.QUEEN, Suit.HEARTS));
        hand.add(new Card(CardRank.TEN, Suit.HEARTS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Royal flush", handRank);
    }

    @Test
    public void testStraightHandHighNumsNoAce() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.NINE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.JACK, Suit.DIAMONDS));
        hand.add(new Card(CardRank.TEN, Suit.CLUBS));
        hand.add(new Card(CardRank.QUEEN, Suit.HEARTS));
        hand.add(new Card(CardRank.KING, Suit.SPADES));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Straight", handRank);
    }

    @Test
    public void testStraightHandLowNumsNoAce() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        hand.add(new Card(CardRank.TWO, Suit.DIAMONDS));
        hand.add(new Card(CardRank.THREE, Suit.CLUBS));
        hand.add(new Card(CardRank.FOUR, Suit.HEARTS));
        hand.add(new Card(CardRank.FIVE, Suit.SPADES));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Straight", handRank);
    }

    @Test
    public void testStraightHandLowNumsWithAce() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.TWO, Suit.DIAMONDS));
        hand.add(new Card(CardRank.THREE, Suit.CLUBS));
        hand.add(new Card(CardRank.FOUR, Suit.HEARTS));
        hand.add(new Card(CardRank.FIVE, Suit.SPADES));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Straight", handRank);
    }

    @Test
    public void testStraightHandHighNumsWithAce() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.JACK, Suit.DIAMONDS));
        hand.add(new Card(CardRank.TEN, Suit.CLUBS));
        hand.add(new Card(CardRank.QUEEN, Suit.HEARTS));
        hand.add(new Card(CardRank.KING, Suit.SPADES));
        String handRank = HandRankEngine.getHandRank(hand);
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
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.ACE, Suit.CLUBS));
        hand.add(new Card(CardRank.ACE, Suit.HEARTS));
        hand.add(new Card(CardRank.FOUR, Suit.SPADES));
        hand.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Three of a kind", handRank);
    }

    @Test
    public void testTwoPairHand() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.ACE, Suit.CLUBS));
        hand.add(new Card(CardRank.FOUR, Suit.HEARTS));
        hand.add(new Card(CardRank.FOUR, Suit.SPADES));
        hand.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("Two pair", handRank);
    }

    @Test
    public void testOnePairHand() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.ACE, Suit.CLUBS));
        hand.add(new Card(CardRank.FOUR, Suit.HEARTS));
        hand.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("One pair", handRank);
    }

    @Test
    public void testAceCardHighHand() {
        Hand hand = new Hand();
        hand.add(new Card(CardRank.ACE, Suit.CLUBS));
        hand.add(new Card(CardRank.THREE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.FOUR, Suit.DIAMONDS));
        hand.add(new Card(CardRank.FIVE, Suit.DIAMONDS));
        hand.add(new Card(CardRank.SIX, Suit.DIAMONDS));
        String handRank = HandRankEngine.getHandRank(hand);
        Assert.assertEquals("High card", handRank);
    }

}
