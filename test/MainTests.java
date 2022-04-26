import org.junit.Assert;
import org.junit.Test;

public class MainTests {

    @Test
    public void testAceClubsHasProperToString() {
        Card card = new Card(Rank.ACE, Suit.CLUBS);
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
        Assert.assertEquals(Rank.class, card.getRank().getClass());
        Assert.assertEquals(originalSize - 1, deck.getCount());
    }

}
