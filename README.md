# CS 212 - Programming Assignment 1
Design Due: 2/09
Final Due: 2/16

## Summary
For this assignment you will use Class to develope a Blackjack game.

## Description
Blackjack is one of the most popular casino card games. It is based on the an old English game called Vingt-Un(Twenty-One). To win a round, a player needs to have a hand that totals higher than the dealer's hand, but the total must not exceed 21 (a bust). For this assignment, we can assume the game only includes the dealer and one player.

### Scoring
To calculate the score of a hand, we use the following rules:  
* Cards 2 through 10 are scored based on their face value.  
* Jacks, Queens, and Kings are all worth 10.  
* Aces can be scored either 1 or 11 depending on the content of the hand.  

### Game play
Game play works as follows:  
1. The dealer deals one face-up card to the player and one to themself.  
2. The second card is dealt face up for the player, but it is dealt face down for the dealer.    
3. A player can decide to "Hit" or "Stay"  
4. While a player opts to "Hit":  
    1. They are dealt an additional face up card.  
    2. If their total is less than or equal to 21:  
        1. The player is asked whether to "hit" or "Stay"  
    3. Otherwise:
        1. The player loses  
5. If the player's hand is less than or equal to 21:  
    1. The dealer flips their face down card
    2. While the dealer total is less than 17:
        1. The Dealer "Hits" (i.e., deals themselves a new card.
    3. If the dealer total is greater than 21 or player total is greater than the dealer total:
        1. The player wins
    4. Otherwise, if the dealer total is greater than the dealer total:
        1. The player loses
    5. Otherwise
        1. The game is a tie

## Assignment Details
You are tasked to write a completed Blackjack game. You can assume there is no betting in the game, just who wins, who loses each round.

Beside the client class Main which contains only the `main()` method, you must to create another **class** named **Hand**. It is up to you how to design and implement the **Hand** class. However, it should have the following minimum requirements:

### Data Members

1. Number of card(s) in the hand.
2. Content (including suit) of all the cards in the hand.

### Methods

1. A constructor to instantiate a hand.
2. `void add()` to add a card to the hand.
3. `int total()` to calculate the total value of the hand.
4. `void display()` to print out the content of the hand.

## Sample Runs

Here is an example of how program should work:

```
A game of Blackjack:
Dealer: TC XX
Player: 3D 9C 
12
Hit(1) or Stay(2)
1
Dealer: TC XX
Player: 3D 9C 6C 
18
Hit(1) or Stay(2)
2
Dealer: TC 4S 
14
Dealer: TC 4S 3C 
17
Player wins
```
Another hand:

```
A game of Blackjack:
Dealer: JS XX
Player: 8C 5D 
13
Hit(1) or Stay(2)
1
Dealer: JS XX
Player: 8C 5D JD 
23
Dealer wins
```

Another run:

```
A game of Blackjack:
Dealer: 2C XX
Player: AS AS 
12
Hit(1) or Stay(2)
1
Dealer: 2C XX
Player: AS AS 7C 
19
Hit(1) or Stay(2)
1
Dealer: 2C XX
Player: AS AS 7C TC 
19
Hit(1) or Stay(2)
2
Dealer: 2C JS 
12
Dealer: 2C JS AD 
13
Dealer: 2C JS AD 9D 
22
Player wins
```

**Note: The dealer often deals from multiple decks of cards which means it is possible to see more than one of the same cards in one hand.**

## Submission

### Part 1 (10 points): Design and test cases.
No code is required for the design.

To GitHub:  
* In design.txt, a description of what is in your **Hand** class. The description should include:  
    * data type of the data  
    * return type and list of parameters(if any) for the constructor(s) and methods  
    * an algorithm for *either* `add()` or `total()` given the choices made for your data members.  
* For the test cases, we are going to use **unit testing** for this assignment. Therefore, submit a file, testcases.txt for the `int total()` method.  
    * This file should contain at least 5 meaningfully different tests. The input should be a hand, the output should be a total.  

### Part 2 (40 points):  Final Product

To GitHub:
* All coded needed to run your program.  
    * Reminders: Don't forget to include header comments and appropriate JavaDoc  
* A file, reflection.txt, containing answers to at least the following:  
    * What is the most challenging thing you experienced?  
    * How did you overcome it?  
    * Anything you would do differently given what you know now. 
    * What did you like about working with classes and what was difficult?  
    * How you felt about the step up in difficulty between this and PA0.

