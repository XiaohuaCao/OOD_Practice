package ood_disign.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cards;
	
	

	public Hand() {
		cards = new ArrayList<>();
		
	}
	public void insertCard(Card c) {
		this.cards.add(c);
	}
	public int getBestValue() throws CardValueInvalidException {
		
		List<Integer> results = getPossibleValues();
		int maxUnder = -1;
		for(int result: results) {
			if(result <= 21 && result > maxUnder) {
				maxUnder = result;
			}
		}
		
		
		return maxUnder;
		
	}
	
	public List<Integer> getPossibleValues() throws CardValueInvalidException{
		//calculate number of Ace cards
		int numAce = 0;
		int sumNoAce = 0;
		for(Card card: cards) {
			if(card.getValue() > 10 && card.getValue() <= 13) {
				sumNoAce += 10;
			}
			else if(card.getValue() == 1) {
				numAce++;
			}
			else if(card.getValue() > 13 || card.getValue() < 1) {
				throw new CardValueInvalidException();
			}
			else {
				sumNoAce += card.getValue();
				
			}
			
		}
		
		// Get possible values
		List<Integer> results = new ArrayList<>();
		int result = sumNoAce;
		for(int i = 0; i <= numAce; i++) {
			int ace = numAce - i;
			result += i * 1 + ace * 11;
			results.add(result);
			result = sumNoAce;
		}
		return results;
		
	}
	

}
