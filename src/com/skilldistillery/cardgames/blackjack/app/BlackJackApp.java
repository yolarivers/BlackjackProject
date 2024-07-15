package com.skilldistillery.cardgames.blackjack.app;

import java.util.Scanner;

public class BlackJackApp {
    private Player player = new Player();
    private Dealer dealer = new Dealer();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BlackJackApp app = new BlackJackApp();
        app.launch();
    }

    public void launch() {
        boolean playAgain = true;
        boolean firstRound = true;

        while (playAgain) {
            if (firstRound) {
                System.out.println("============================");
                System.out.println("   Welcome to Blackjack!   ");
                System.out.println("============================");
                firstRound = false;
            } else {
                System.out.println("============================");
                System.out.println("   Welcome to another round!   ");
                System.out.println("============================");
            }

            dealer.shuffleDeck();
            initialDeal();
            playerTurn();
            if (!player.isOver21()) {
                dealerTurn();
            }
            determineWinner();
            playAgain = askToPlayAgain();
            if (playAgain) {
                resetGame();
            }
        }

        System.out.println("============================");
        System.out.println("   Thank you for playing!   ");
        System.out.println("============================");
    }

    private void initialDeal() {
        player.addCardToHand(dealer.dealCard());
        dealer.addCardToHand(dealer.dealCard());
        player.addCardToHand(dealer.dealCard());
        dealer.addCardToHand(dealer.dealCard());
        displayHands(true);
    }

    private void playerTurn() {
        boolean playerStands = false;
        while (!playerStands && !player.isOver21()) {
            System.out.println("Your hand value: " + player.getHandValue());
            System.out.print("Would you like to hit or stand? (h/s): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.addCardToHand(dealer.dealCard());
                if (!player.isOver21()) {
                    System.out.println("Your hand value: " + player.getHandValue());
                } else {
                    System.out.println("Your hand value: " + player.getHandValue());
                    System.out.println("YOU ARE OVER 21!");
                }
            } else {
                playerStands = true;
            }
        }
    }

    private void dealerTurn() {
        while (dealer.getHandValue() < 17) {
            dealer.addCardToHand(dealer.dealCard());
        }
        System.out.println("Dealer's hand: " + dealer.getHandDetails(false));
        System.out.println("Dealer's hand value: " + dealer.getHandValue());
    }

    private void determineWinner() {
        int playerHandValue = player.getHandValue();
        int dealerHandValue = dealer.getHandValue();
        System.out.println("Dealer's hand: " + dealer.getHandDetails(false));
        System.out.println("Dealer's hand value: " + dealerHandValue);
        System.out.println("Your hand: " + player.getHandDetails());
        System.out.println("Your hand value: " + playerHandValue);

        if (player.isOver21()) {
            System.out.println("You are over 21! Dealer wins.");
        } else if (dealer.isOver21()) {
            System.out.println("Dealer over 21! ");
            System.out.println("****************************");
            System.out.println("*                                  *");
            System.out.println("*        YOU WIN!          *");
            System.out.println("*                                   *");
            System.out.println("****************************");
        } else if (playerHandValue > dealerHandValue) {
        	System.out.println("****************************");
        	System.out.println("*                                  *");
        	System.out.println("*        YOU WIN!          *");
        	System.out.println("*                                   *");
        	System.out.println("****************************");
        } else if (dealerHandValue > playerHandValue) {
            System.out.println("DEALER WINS.");
        } else {
            System.out.println("It's a TIE!");
        }
    }

    private void displayHands(boolean hideDealerSecondCard) {
        System.out.println("Dealer's hand: " + dealer.getHandDetails(hideDealerSecondCard));
        System.out.println("Your hand: " + player.getHandDetails());
    }

    private boolean askToPlayAgain() {
        System.out.print("Would you like to play again? (y/n): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("y");
    }

    private void resetGame() {
        player.getHand().clear();
        dealer.getHand().clear();
    }
}
