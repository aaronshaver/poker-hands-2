import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    Hand() {
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
