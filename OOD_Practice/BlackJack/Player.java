package ood_disign.BlackJack;

public class Player {
	private int id;
	private Hand hand;
	private int currentBets;
	private int totalBets;
	private Deck deck;
	private boolean stopDealing;
	public Player(int currentBets, int totalBets) {
		super();
		this.currentBets = currentBets;
		this.totalBets = totalBets;
		this.stopDealing = false;
		this.hand = new Hand();
		
	}
	public int getID() {
		return this.id;
	}
	public void joinGame() {
		deck = Deck.getInstance();
	}
	public void placeBets(int amount) throws TotalBetsNotEnoughException{
		if(amount > this.totalBets) {
			throw new TotalBetsNotEnoughException();
		}
		this.currentBets = amount;
		totalBets -= amount;
		
	}
	
	public void insertCards(Card card) {
		hand.insertCard(card);
	}
	public void getNextCard() {
		insertCards(deck.dealNextCard());
	}
	public void stopDealing() {
		this.stopDealing = true;
	}
	public int getBestValue() throws CardValueInvalidException{
		return hand.getBestValue();
		
	}
	public void lose() {
		currentBets = 0;
	}
	public void win() {
		totalBets += 2 * currentBets;
	}
	public int getCurrentBet() {
		return currentBets;
	}
	
	
	public String printPlayer() {
		return " current bets: " + currentBets + ", total bets: " + totalBets + "\n";
		
	}

}
