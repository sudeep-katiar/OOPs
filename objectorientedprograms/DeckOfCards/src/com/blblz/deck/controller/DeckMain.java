package com.blblz.deck.controller;

import com.blblz.deck.service.DeckInterface;
import com.blblz.deck.serviceimplementation.DeckImpl;

public class DeckMain {
	public static void main(String[] args) {

		DeckInterface deckImpl = new DeckImpl();
		deckImpl.intializeCard();
		deckImpl.shuffleCard();
		deckImpl.displayCard();
	}

}
