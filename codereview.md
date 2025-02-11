# A Code Review of the Card Game Driver Program

## Documentation

The program was poorly documented with little to no JDOC. However, I made sure to go through the document and add JDOC to all classes and most methods. This ensures that the program is easy to understand and read by anyone who opens the repository.

## Code Structure

### Specifications

Every specification is met for every class implemented. The only specification that appears to be lacking is the toString method for the LamarckianPoker class. It appears that the pool object toString representation isn't returned correctly. 

### Formatting

The code is formatted well.

### Methods

Every method appears to have a purpose.

### Debug

No forgotten debugging code was left in the code uncommented out.

### DRY

A lot of the code is redundant across multiple classes. The first example is the Hand and Deck classes which appear to hold similar functionality. I do think a distinction between those two classes is useful since they are both lightweight and have distinct and specific use cases. However, the two game classes are very redundant. It almost looks like some of the methods were copy and pasted across the two classes. I think a better implementation would be to create a base Game class that is extended and contains many of the base elements shared between the two classes. The first example is from the LamarckianPoker class while the second reset method is from the Blackjack class. Both have very similar behaviors.

```java
public void reset(boolean newDeck) {
    if (newDeck) {
        deck = new Deck();
        discard = new Deck();
        discard.clear();
        deck.shuffle();
    }
    iTurn = 0;
}
```

```java
public void reset(boolean newDeck) {
    public void reset(boolean newDeck) {
        if (newDeck) {
            deck = new Deck();
            deck.shuffle();
        }
    }
}
```

### Final and Static

The variables for the suit and rank of cards in the Card class could be final and so could the Random objects in some of the other classes. However, everything else doesn't really work as a final. Nothing can be converted to a static variable.

```java
// instance variables from the Card class
private Suit suit;
private Rank rank;
```

### Simplify Methods

Without extending another class, all the present methods are required. There isn't any good examples of methods that can be combined and simplified that I could find that would make a significant difference. Most of the methods are actually getters and setters. 

## Variables

### Identifiers and Types

All variables appear to have the right types and good identifiers. The use of enums really helps to simplify the structure of the rank and suit variables.

### Double Use

Every variable only has single use within its scope.

### Casting

Every number is an int, no casting is required.

### Unused variables

The iTurn variable appears to have been used for debugging but is no read for data.

## Arithmetic Operators

### Floating-Point Operations

No floating-point numbers are present.

### Division by Zero

No division by zero is present.

## Loops

### Nesting Errors

All loops are setup correctly.

```java
for (Card poolCard : pool.getHand()) {
    if (firstCard.getRank().ordinal() == poolCard.getRank().ordinal() ||
            firstCard.getSuit().ordinal() == poolCard.getSuit().ordinal()) {
        firstHand.addCard(poolCard);
        poolRemove.add(poolCard);
    }
}
```

### Conditionals

All conditional blocks appear correctly and efficiently implemented. Switches are used for enums and if statements for everything else.

### Loop Usages

All usages of loops appear correct with index and the actual method code.

## General

### Index Errors

The code actually has multiple index errors. The first is the toString method of the LamarckianPoker class which attempts to return the data in the pool variable. However, this variable is sometimes empty and throws an error crashing the program. I removed the pool variable from the toString as it wasn't providing any really useful data and had no explicit specification.

The second error is in the deal method of the Deck class. It fails to check for empty decks leaving it up to the programmer to implement the correct checks to prevent an index zero error. However, the code fails to do this sometimes leading to an error crashing the code.

```java
public Card deal() {

    // TODO: The deal() method fails to check for empty decks.
    // Add a check to see if the deck is empty.

    return deck.remove(0);
}
```

### Returns

Returns appear correct.

### Print Statements

No print statements appear to be used (except for debug) outside of the driver program. Every piece of text is returned as a String.

### Correct Data

All data operations appear correct.

### Edge Cases

The edge cases are mainly index errors that could be fixed with the above changes.

### Other

Other than redundancy and index errors the program appears to meet specifications adequately.  