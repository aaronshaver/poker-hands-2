import java.util.ArrayList;

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
}
