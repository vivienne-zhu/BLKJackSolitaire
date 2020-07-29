/**
 * @author JiayuZhu
 */
import java.util.Random;

public class Deck {

	Card[] deck = new Card[52];

	public Deck() {
		String[] suits = new String[] { "Heart", "Club", "Diamond", "Spade" };
		String[] ranks = new String[] { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				Card card = new Card(ranks[j], suits[i]);
				deck[ranks.length * i + j] = card;
			}
		}
	}
	
	/**
	 * This method shuffles a deck of cards.
	 */
	void shuffle() {
		Card[] shuffledDeck = new Card[52];
		for (int i = 0; i < this.deck.length; i++) {
			Random ranInt = new Random();
			int ranPosition = ranInt.nextInt(52);

			while (this.deck[ranPosition] == null) {
				ranPosition = ranInt.nextInt(52);
			}

			Card ranCard = this.deck[ranPosition];
			shuffledDeck[i] = ranCard;
			this.deck[ranPosition] = null;
		}
		this.deck = shuffledDeck;
	}

}
