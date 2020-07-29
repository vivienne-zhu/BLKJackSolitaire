/**
 * @author JiayuZhu
 */
import java.util.Scanner;

public class BlackjackSolitaire {

	Card dealtCard(Deck deck, int round) {
		System.out.println("\nCard to Play: ");
		Card dealtCard = deck.deck[round - 1];
		;
		System.out.println(dealtCard);

		return dealtCard;
	}

		/**
		 * This method asks the user to pick the position, 
		 * where he wants to put the card on the grid. 
		 * @param table
		 * @return
		 */
	public int inputCard(Table table) {
		boolean errorCheck = false;
		int inputPosition = 0;

		while (errorCheck == false) {
			System.out.println("Where would you like to put your card? (Please enter a position number)");
			Scanner input = new Scanner(System.in);
			inputPosition = input.nextInt() - 1;

			errorCheck = inputErrorCheck(inputPosition, table);
		}

		return inputPosition;
	}
	
	/**
	 * This method checks whether the position the user inputs is taken, 
	 * if taken, it will prompt the user to input a different position number. 
	 * @param inputPosition
	 * @param table
	 * @return
	 */

	public boolean inputErrorCheck(int inputPosition, Table table) {
		if (table.table[inputPosition] != null) {
			System.out.println("This spot has been taken!");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method counts the number of cards in the deck, 
	 * if all 16 positions have been filled with cards, 
	 * the game ends.
	 * @param table
	 * @return
	 */
	public boolean gameFinish(Table table) {
		int cardCount = 0;

		for (int i = 0; i < 16; i++) {
			if (table.table[i] != null) {
				cardCount++;
			}
		}

		if (cardCount == 16) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * This method combines all parts together,
	 * and begins the game. 
	 */
	public void play() {
		Deck deck = new Deck();
		deck.shuffle();

		Table table = new Table();
		int round = 1;
		boolean gameFinish = false;

		while (gameFinish == false) {
			table.currentTable();
			Card dealtCard = dealtCard(deck, round);
			int inputPosition = inputCard(table);

			table.updateTable(inputPosition, dealtCard);
			round++;
			gameFinish = gameFinish(table);
		}

		table.currentTable();

		int finalScore = table.handSum();
		System.out.println("\nScoring...");
		System.out.println("\nFinal Score: " + finalScore);
		System.out.println("Thanks for playing:)");

	}

}
