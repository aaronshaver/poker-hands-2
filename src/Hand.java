import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();

    public void add(Card card) {
        if (cards.size() == 5) throw new UnsupportedOperationException("Cannot add more than 5 cards");
        this.cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
