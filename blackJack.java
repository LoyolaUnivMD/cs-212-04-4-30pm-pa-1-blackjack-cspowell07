import java.util.ArrayList;
import java.util.Scanner;

public class blackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate a deck of cards - H hearts D diamonds C clubs S spades
        String[] deck = {"2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AH",
                "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AD",
                "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "AC",
                "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AS"};


        // Keep game running until user is done (Found while loop/equalsIgnoreCase in an online example)
        boolean playAgain = true;
        while (playAgain) {
            // Shuffle the deck
            shuffle(deck);

            // Deal initial cards
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();

            dealInitialCards(deck, playerHand, dealerHand);

            // Player's turn
            playerTurn(scanner, deck, playerHand);

            // Dealer's turn
            dealerTurn(deck, dealerHand);

            // Determine the winner
            determineWinner(playerHand, dealerHand);

            // Ask if the player wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String input = scanner.next();
            playAgain = input.equalsIgnoreCase("yes");
        }

        scanner.close();
    }

    // Shuffle the deck
    //Found idea for shuffle online
    private static void shuffle(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int j = (int) (Math.random() * deck.length);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    // Deal initial cards
    private static void dealInitialCards(String[] deck, Hand playerHand, Hand dealerHand) {
        playerHand.add(deck[0]);
        dealerHand.add(deck[1]);
        playerHand.add(deck[2]);
        dealerHand.add(deck[3]);

        System.out.println("Player's Hand:");
        playerHand.display();
        System.out.println("Total: " + playerHand.total()); // Print total for player
        System.out.println("Dealer's Hand:");
        dealerHand.display();
        System.out.println("Total: " + dealerHand.total()); // Print total for dealer
    }

    // Player's turn
    private static void playerTurn(Scanner scanner, String[] deck, Hand playerHand) {
        while (true) {
            System.out.print("Do you want to Hit or Stay? ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("hit")) {
                playerHand.add(deck[playerHand.total() / 2]); // Deal next card from the deck
                System.out.println("Player's Hand:");
                playerHand.display();
                System.out.println("Total: " + playerHand.total()); // Print total for player
                if (playerHand.total() > 21) {
                    System.out.println("Busted! You lose.");
                    break;
                }
            } else if (choice.equalsIgnoreCase("stay")) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter Hit or Stay.");
            }
        }
    }

    // Dealer's turn
    private static void dealerTurn(String[] deck, Hand dealerHand) {
        System.out.println("Dealer's turn:");
        dealerHand.display();
        System.out.println("Total: " + dealerHand.total()); // Print total for dealer
        while (dealerHand.total() < 17) {
            dealerHand.add(deck[dealerHand.total() / 2]); // Deal next card from the deck
            dealerHand.display();
            System.out.println("Total: " + dealerHand.total()); // Print total for dealer
        }
    }

    // Determine the winner
    private static void determineWinner(Hand playerHand, Hand dealerHand) {
        int playerTotal = playerHand.total();
        int dealerTotal = dealerHand.total();

        System.out.println("Player's Total: " + playerTotal);
        System.out.println("Dealer's Total: " + dealerTotal);

        if (playerTotal > 21) {
            System.out.println("Player Busted! Dealer Wins.");
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("Player Wins!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer Wins.");
        } else {
            System.out.println("It's a Tie!");
        }
    }
}

class Hand {
    private ArrayList<String> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void add(String card) {
        cards.add(card);
    }

    public int total() {
        int total = 0;
        int aceCount = 0;

        for (String card : cards) {
            if (card.startsWith("A")) {
                aceCount++;
                total += 11; // Assume ace initially counts as 11
            } else if (card.startsWith("K") || card.startsWith("Q") || card.startsWith("J")) {
                total += 10; // Face cards count as 10
            } else {
                total += Integer.parseInt(card.substring(0, card.length() - 1)); // Extract numeric value of card
            }
        }

        // Adjust ace value if needed to prevent bust
        while (total > 21 && aceCount > 0) {
            total -= 10; // Change the value of ace from 11 to 1
            aceCount--;
        }

        return total;
    }

    public void display() {
        System.out.println("Hand: " + cards);
    }
}
