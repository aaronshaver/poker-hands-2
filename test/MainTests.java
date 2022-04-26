import org.junit.Assert;
import org.junit.Test;

public class MainTests {

    @Test
    public void testAceClubsHasProperToString() {
        Card card = new Card(Rank.ACE, Suit.CLUBS);
        Assert.assertEquals("Ac", card.toString());
    }

    @Test
    public void testContructedDeckHas52Cards() {
        Deck deck = new Deck();
        Assert.assertEquals(52, deck.getCount());
    }



}
