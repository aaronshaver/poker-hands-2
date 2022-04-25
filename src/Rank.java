public enum Rank {
    ACE("A");

    private final String text;

    Rank(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
