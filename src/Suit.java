public enum Suit {
    CLUBS("c"),
    DIAMONDS("d"),
    HEARTS("h"),
    SPADES("s");

    private final String text;

    Suit(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
