import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();

    Hand() {
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
