import org.junit.Assert;
import org.junit.Test;

public class MainTests {

    @Test
    public void testCardHasSuitsRanks() {
        Card card = new Card(new Suit(), new Rank());
        Assert.assertNotNull(card.getSuit());
        Assert.assertNotNull(card.getRank());
    }

}
