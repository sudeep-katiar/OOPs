package com.blblz.deck.serviceimplementation;

import com.blblz.deck.service.DeckInterface;

public class DeckImpl implements DeckInterface{
	String[] Suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	String[] Ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	int n = Suits.length * Ranks.length;
	String[] deck = new String[n];
	
	@Override
	public void intializeCard() {
		for (int i = 0; i < Ranks.length; i++) {
			for (int j = 0; j < Suits.length; j++) {
				deck[Suits.length * i + j] = Ranks[i] + " " + Suits[j];
			}
		}
	}

	@Override
	public void shuffleCard() {
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
	}

	@Override
	public void displayCard() {
		System.out.println("Total number of deck of cards are " + deck.length);

		for (int i = 0; i < 4; i++) {
			System.out.print(" person"+ i+"\t");
		}
		System.out.print("\n");

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(" "+(deck[i + j * 4])+"\t" ); 
			}
			System.out.println();
		}
	}

}
