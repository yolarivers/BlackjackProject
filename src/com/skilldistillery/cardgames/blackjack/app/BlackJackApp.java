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
        dealer.shuffleDeck();
        initialDeal();
        playerTurn();
        if (!player.isOver21()) {
            dealerTurn();
        }
        determineWinner();
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
            System.out.println("Your hand: " + player.getHandDetails());
            System.out.println("Your hand value: " + player.getHandValue());
            System.out.print("Would you like to hit or stand? (h/s): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                player.addCardToHand(dealer.dealCard());
                System.out.println("Your hand: " + player.getHandDetails());
                System.out.println("Your hand value: " + player.getHandValue());
                if (player.isOver21()) {
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
            System.out.println("Dealer over 21! You win.");
        } else if (playerHandValue > dealerHandValue) {
            System.out.println("YOU WIN!");
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
}
