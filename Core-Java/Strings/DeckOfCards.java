import java.util.Random;

public class DeckOfCards {

    public static String[] initializeDeck() {
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i + rand.nextInt(deck.length - i);
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int numCards, int numPlayers) {
        if (numCards % numPlayers != 0) {
            System.out.println("Cannot distribute evenly.");
            return null;
        }
        int cardsPerPlayer = numCards / numPlayers;
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int index = 0;
        for (int p = 0; p < numPlayers; p++) {
            for (int c = 0; c < cardsPerPlayer; c++) {
                players[p][c] = deck[index++];
            }
        }
        return players;
    }

    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i+1) + " Cards:");
            for (String card : players[i]) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();
        System.out.print("Enter number of cards to distribute: ");
        int numCards = sc.nextInt();

        String[] deck = initializeDeck();
        shuffleDeck(deck);
        String[][] players = distributeCards(deck, numCards, numPlayers);

        if (players != null) printPlayers(players);
    }
}
