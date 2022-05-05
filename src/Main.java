import java.util.*;

public class Main {
    public static void main(String[] args) {

        final Optional<String> numHandsRaw = Arrays.stream(args).findFirst();
        int numHands;
        if(numHandsRaw.isPresent()) {
            numHands = Integer.parseInt(numHandsRaw.get());
        } else {
            throw new IllegalArgumentException("Must specify number of poker hands to generate as first argument");
        }

        System.out.printf("%nGenerating up to %d poker hand(s)... (will exit early if Royal flush)%n", numHands);

        HashMap<String, Integer> handRankCounts = new HashMap<>();

        int i;
        for (i = 0; i < numHands; i++) {
            Deck deck = new Deck();
            Hand hand = deck.getHand();
            final String handRank = HandRankEngine.getHandRank(hand);

            if (handRankCounts.get(handRank) == null) {
                handRankCounts.put(handRank, 1);
            } else {
                final int count = handRankCounts.get(handRank);
                handRankCounts.put(handRank, count + 1);
            }

            if (handRank.equals("Royal flush")) break;
        }

        System.out.printf("Generated %d poker hands%n", i);
        handRankCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }

}