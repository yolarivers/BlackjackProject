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
        
    }

    private void initialDeal() {
       
    }

    private void playerTurn() {
        
    }

    private void dealerTurn() {
        
        }
      

    private void determineWinner() {
       
    }

    private void displayHands() {
       
    }
}
