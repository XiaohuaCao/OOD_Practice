package ood_disign.BlackJack;

public class Dealer {
	private int id;
	private Hand hand;
	private int bets = 10000;
	private Deck deck;
	public Dealer() {
		
		
		hand = new Hand();
		deck = Deck.getInstance();
	}
	
	public void insertCard(Card c) {
		hand.insertCard(c);
	}
	public void getNextCard() {
		insertCard(deck.dealNextCard());
	}
	public int getBestValue() throws CardValueInvalidException {
		return hand.getBestValue();
	}
	public void updateBet(int amount) {
		bets += amount;
	}
	public String printDealer() {
		return "Dealer " + ", total bets: " + bets + "\n";
	}
	

}
