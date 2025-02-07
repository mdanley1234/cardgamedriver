package edu.guilford;


/**
 * The Blackjack class represents a game of Blackjack.
 * The game has a player and a dealer, each with a hand of cards.
 */
public class Blackjack {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;

    /**
     * Generate a new game of Blackjack.
     */
    public Blackjack() {
        reset(true);
    }

    public Hand getPlayerHand() {
        return playerHand;
    }


    public Hand getDealerHand() {
        return dealerHand;
    }


    public Deck getDeck() {
        return deck;
    }


    public void reset(boolean newDeck) {
        if (newDeck) {
            deck = new Deck();
            deck.shuffle();
        }
    }

    /**
     * Deal 2 cards from the deck to both the player and dealer.
     */
    public void deal() {
        playerHand = new Hand();
        dealerHand = new Hand();
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
    }

    /**
     * Player draws cards until their total is 16 or higher.
     * @return Returns true if the player's total is 21 or less.
     */
    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.addCard(deck.deal());
        }
        return playerHand.getTotalValue() <= 21;

    }

    /**
     * Dealer draws cards until their total is 17 or higher.
     * @return Returns true if the dealer's total is 21 or less.
     */
    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.addCard(deck.deal());
        }
        return dealerHand.getTotalValue() <= 21;
    }

    /**
     * Returns a string representation of the game.
     * Both hands and value totals are displayed.
     */
    public String toString() {
        String result = "Player's Hand:\n";
        for (int i = 0; i < playerHand.size(); i++) {
            result += playerHand.getCard(i) + "\n";
        }
        result += "Player's Total: " + playerHand.getTotalValue() + "\n\n";
        result += "Dealer's Hand:\n";
        for (int i = 0; i < dealerHand.size(); i++) {
            result += dealerHand.getCard(i) + "\n";
        }
        result += "Dealer's Total: " + dealerHand.getTotalValue() + "\n\n";
        return result;
    }

}
