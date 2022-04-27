
public class Card {
    private final Suit suit;
    private final CardRank cardRank;

    Card(CardRank cardRank, Suit suit) {
        this.suit = suit;
        this.cardRank = cardRank;

    }

    public Suit getSuit() {
        return this.suit;
    }

    public CardRank getRank() {
        return this.cardRank;
    }

    @Override
    public String toString() {
        return getRank().toString() + getSuit().toString();
    }

}
