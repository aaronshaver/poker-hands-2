import org.junit.Assert;
import org.junit.Test;

public class MainTests {

    @Test
    public void testAceClubsHasProperToString() {
        Card card = new Card(Rank.ACE, Suit.CLUB);
        Assert.assertEquals("Ac", card.toString());
    }

}
