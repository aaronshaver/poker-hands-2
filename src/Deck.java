import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    public Deck() {

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public int getCount() {
        return cards.size();
    }

    public Card dealCard() {
        Random random = new Random();
        final int randomIndex = random.nextInt((cards.size() - 1) + 1);
        Card card = cards.get(randomIndex);
        cards.remove(randomIndex);
        return card;
    }

    public ArrayList<Card> getHand() {
        ArrayList<Card> hand = new ArrayList<>();
        while (hand.size() < 5) {
            Card card = this.dealCard();
            hand.add(card);
        }
        return hand;
    }
}
