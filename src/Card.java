/**
 * 
 * @author JiayuZhu 
 *
 */
public class Card {
	private String rank;
	private String suit;
	private int value;

	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;

		if (this.rank == "Jack" || this.rank == "Queen" || this.rank == "King") {
			this.value = 10;
		} else if (this.rank == "Ace") {
			this.value = 1;
		} else {
			this.value = Integer.valueOf(this.rank);
		}

	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * This method ensures that when a card is printed,
	 * a string representation is associated with it.  
	 * When a card is printed, it contains its rank and the first letter of its suit. 
	 */
	public String toString() {
		if (this.rank == "Ace" || this.rank == "Jack" || this.rank == "Queen" || this.rank == "King") {
			return this.rank.charAt(0) + "" + this.suit.charAt(0);
		} else {
			return this.rank + this.suit.charAt(0);
		}

	}

}
