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
        // TODO: there might an off by 1 here; test it
        Random random = new Random();
        final int randomIndex = random.nextInt((cards.size() - 1) + 1);
        Card card = cards.get(randomIndex);
        cards.remove(randomIndex);
        return card;
    }
}
