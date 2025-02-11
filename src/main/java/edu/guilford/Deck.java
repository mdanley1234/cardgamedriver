package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck class represents a deck of playing cards.
 * The deck is an ArrayList of Card objects.
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private Random rand = new Random();

    /**
     * Constructor for a Deck object.
     * Builds a deck of 52 cards.
     */
    public Deck() {
        build();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    public void clear() {
        deck.clear();
    }

    /**
     * Generates a standard deck of 52 cards
     */
    public void build() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffles the deck of cards
     */
    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        while (deck.size() > 0) {
            int loc = rand.nextInt(deck.size());
            tempDeck.add(deck.get(loc));
            deck.remove(loc);
        }
        deck = tempDeck;
    }

    /**
     * Pick a card from the deck
     * @param i index of card to pick from the deck
     * @return Card picked from the deck
     */
    public Card pick(int i) {
        Card picked = deck.remove(i);
        return picked;
    }

    /**
     * Deal a card from the deck
     * @return Card dealt from the deck
     */
    public Card deal() {

        // TODO: The deal() method fails to check for empty decks.
        // Add a check to see if the deck is empty.

        return deck.remove(0);
    }

    public int size() {
        return deck.size();
    }

    /**
     * Displays the deck of cards
     */
    public String toString() {
        String deckString = "";
        for (Card card : deck) {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }
}
