import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    public Deck() {

        for (Suit suit : Suit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                cards.add(new Card(cardRank, suit));
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

    public Hand getHand() {
        Hand hand = new Hand();
        while (hand.getSize() < 5) {
            Card card = this.dealCard();
            hand.addCard(card);
        }
        return hand;
    }
}
