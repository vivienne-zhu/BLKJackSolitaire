/**
 * 
 * @author JiayuZhu
 *
 */
public class Table {
	Card[] table = new Card[20];

	/**
	 * This method displays the current grid, including both the table and the
	 * discarded cards.
	 */
	public void currentTable() {
		System.out.println("Current Table: ");

		for (int i = 0; i < 16; i++) {
			int position = i + 1;
			if (i == 10 || i == 13) {
				if (table[i] == null) {
					System.out.print("   " + position + "   ");
				} else {
					System.out.print("   " + table[i] + "   ");
				}
			} else {
				if (table[i] == null) {
					System.out.print(position + "   ");
				} else {
					System.out.print(table[i] + "   ");
				}

				if (i == 4 || i == 9 || i == 12) {
					System.out.println();
				}
			}
		}

		System.out.println("\nDiscards: ");

		for (int i = 16; i < table.length; i++) {
			if (table[i] == null) {
				int position = i + 1;
				System.out.print(position + "   ");
			} else {
				System.out.print(table[i] + "   ");
			}
		}
	}

	/**
	 * This method takes in an input position and a card, and updates the card on
	 * the table.
	 * 
	 * @param inputPosition
	 * @param card
	 */
	public void updateTable(int inputPosition, Card card) {
		this.table[inputPosition] = card;
	}
	
	/**
	 * This method checks whether the ace in the row/column
	 * should take the value of 1 or 11. 
	 * @param sum
	 * @return
	 */
	public int aceValue(int sum) {
		if (sum + 10 <= 21) {
			sum += 10;
		}
		return sum;
	}

	/**
	 * This method calculates the points in a role or in a column, in all situations
	 * except when the sum is equal to 21.
	 * 
	 * @param sum
	 * @return
	 */
	public int handPoints(int sum) {
		int point = 0;

		if (sum == 20) {
			point = 5;
		} else if (sum == 19) {
			point = 4;
		} else if (sum == 18) {
			point = 3;
		} else if (sum == 17) {
			point = 2;
		} else if (sum > 21) {
			point = 0;
		} else if (sum <= 16) {
			point = 1;
		} else {
			point = 0;
		}

		return point;
	}
	/**
	 * This method determines how many points a user gets when there are only two cards in the column. 
	 * @param sum
	 * @return
	 */
	public int blackJackSum(int sum) {
		int points = 0;

		if (sum == 21) {
			points += 10;
		} else {
			points += handPoints(sum);
		}

		return points;
	}
	
	/**
	 * This method determines how many points a user gets,
	 * when there are more than 2 cards in the row or in the column.
	 * @param sum
	 * @return
	 */

	public int otherSum(int sum) {
		int points = 0;

		if (sum == 21) {
			points += 7;
		} else {
			points += handPoints(sum);
		}
		return points;
	}
	
	/**
	 * This method returns the final score the player gets in the game.
	 * @return
	 */
	public int handSum() {
		int points = 0;
		
		/** Depending on whether there is an Ace in the column,
		 * the sum is calculated differently. Thus, this step checks for whether there is an Ace. 
		 */
		int sumColumn1 = table[0].getValue() + table[5].getValue();
		if (table[0].getRank().charAt(0) == 'A' || table[5].getRank().charAt(0) == 'A') {
			sumColumn1 = aceValue(sumColumn1);
		}
		points += blackJackSum(sumColumn1);

		int sumColumn2 = table[1].getValue() + table[6].getValue() + table[10].getValue() + table[13].getValue();
		if (table[1].getRank().charAt(0) == 'A' || table[6].getRank().charAt(0) == 'A'
				|| table[10].getRank().charAt(0) == 'A' || table[13].getRank().charAt(0) == 'A') {
			sumColumn2 = aceValue(sumColumn2);
		}
		points += otherSum(sumColumn2);

		int sumColumn3 = table[2].getValue() + table[7].getValue() + table[11].getValue() + table[14].getValue();
		if (table[2].getRank().charAt(0) == 'A' || table[7].getRank().charAt(0) == 'A'
				|| table[11].getRank().charAt(0) == 'A' || table[14].getRank().charAt(0) == 'A') {
			sumColumn3 = aceValue(sumColumn3);
		}

		points += otherSum(sumColumn3);

		int sumColumn4 = table[3].getValue() + table[8].getValue() + table[12].getValue() + table[15].getValue();
		if (table[3].getRank().charAt(0) == 'A' || table[8].getRank().charAt(0) == 'A'
				|| table[12].getRank().charAt(0) == 'A' || table[15].getRank().charAt(0) == 'A') {
			sumColumn4 = aceValue(sumColumn4);
		}

		points += otherSum(sumColumn4);

		int sumColumn5 = table[4].getValue() + table[9].getValue();
		if (table[4].getRank().charAt(0) == 'A' || table[9].getRank().charAt(0) == 'A') {
			sumColumn5 = aceValue(sumColumn5);
		}

		points += blackJackSum(sumColumn5);

		int sumRow1 = table[0].getValue() + table[1].getValue() + table[2].getValue() + table[3].getValue()
				+ table[4].getValue();
		if (table[0].getRank().charAt(0) == 'A' || table[1].getRank().charAt(0) == 'A'
				|| table[2].getRank().charAt(0) == 'A' || table[3].getRank().charAt(0) == 'A'
				|| table[4].getRank().charAt(0) == 'A') {
			sumRow1 = aceValue(sumRow1);
		}

		points += otherSum(sumRow1);

		int sumRow2 = table[5].getValue() + table[6].getValue() + table[7].getValue() + table[8].getValue()
				+ table[9].getValue();
		if (table[5].getRank().charAt(0) == 'A' || table[6].getRank().charAt(0) == 'A'
				|| table[7].getRank().charAt(0) == 'A' || table[8].getRank().charAt(0) == 'A'
				|| table[9].getRank().charAt(0) == 'A') {
			sumRow2 = aceValue(sumRow2);
		}

		points += otherSum(sumRow2);

		int sumRow3 = table[10].getValue() + table[11].getValue() + table[12].getValue();
		if (table[10].getRank().charAt(0) == 'A' || table[11].getRank().charAt(0) == 'A'
				|| table[12].getRank().charAt(0) == 'A') {
			sumRow3 = aceValue(sumRow3);
		}

		points += otherSum(sumRow3);

		int sumRow4 = table[13].getValue() + table[14].getValue() + table[15].getValue();
		if (table[13].getRank().charAt(0) == 'A' || table[14].getRank().charAt(0) == 'A'
				|| table[15].getRank().charAt(0) == 'A') {
			sumRow4 = aceValue(sumRow4);
		}

		points += otherSum(sumRow4);
//		System.out.println(sumColumn1);
//		System.out.println(sumColumn2);
//		System.out.println(sumColumn3);
//		System.out.println(sumColumn4);
//		System.out.println(sumColumn5);
//		System.out.println(sumRow1);
//		System.out.println(sumRow2);
//		System.out.println(sumRow3);
//		System.out.println(sumRow4);
		return points;
	}

}
