package ood_disign.BlackJack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Author Xiaohua Cao
public class Deck {
	private List<Player> players;
	private List<Card> cards;
	public Dealer dealer;
	private static Deck deck;
	

	private Deck() {
		players = new ArrayList<>();
		//cards = new ArrayList<>();
		dealer = new Dealer();
		
	}
	//get instance.
	public static Deck getInstance() {
		if(deck == null) {
			deck = new Deck();
		}
		return deck;
	} 
	
	public void initCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}
	public void dealInitCards() {
		for(Player p: players) {
			p.insertCards(dealNextCard());
			
			
		}
		dealer.insertCard(dealNextCard());
		for(Player p: players) {
			p.insertCards(dealNextCard());
			dealer.insertCard(dealNextCard());
			
		}
		dealer.insertCard(dealNextCard());
	}
	public Card dealNextCard() {
		Card next = cards.get(0);
		cards.remove(0);
		return next;
		
		//return null;
	}
	public void compareResult() throws CardValueInvalidException {
		for(Player player: players) {
			if(player.getBestValue() < dealer.getBestValue()) {
				player.win();
				dealer.updateBet(-player.getCurrentBet());
			}
			else {
				player.lose();
				dealer.updateBet(player.getCurrentBet());
			}
		}
	}
	

}
