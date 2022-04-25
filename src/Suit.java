public enum Suit {
    CLUB("c");

    private final String text;

    Suit(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
