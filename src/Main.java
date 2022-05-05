import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        final Optional<String> numHandsRaw = Arrays.stream(args).findFirst();
        int numHands;
        if(numHandsRaw.isPresent()) {
            numHands = Integer.parseInt(numHandsRaw.get());
        } else {
            throw new IllegalArgumentException("Must specify number of poker hands to generate as first argument");
        }

        System.out.printf("Generating %d poker hand(s)...%n", numHands);

        for (int i = 0; i < numHands; i++) {
            Deck deck = new Deck();
            Hand hand = deck.getHand();
            final String handRank = HandRankEngine.getHandRank(hand);

        }
    }

}