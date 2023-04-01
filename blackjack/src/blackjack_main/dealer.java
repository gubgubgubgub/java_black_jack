package blackjack_main;

public class dealer extends card {

	public int dealer_hit(String[] dealer_card) {
		int sum = 0;
		int result = 0;
		int i = 0;

		while (true) {
			if (dealer_card[i] == null) {
				dealer_card[i] = dack();
				sum = dealer_sum(dealer_card);
				if (sum > 16 && sum < 22) {
					result = 0;
					break;
				} else if (sum < 17) {
					result = 2;
					break;
				} else if (sum > 21) {
					result = 1;
					break;
				}
			} else {
				i++;
			}
		}
		return result;// 0-> 비교 1-> bust 2-> again
	}

	public int dealer_sum(String[] dealer_card) {
		int result = 0;

		for (int i = 0; i < dealer_card.length; i++) {
			if (dealer_card[i] == "A") {
				result += 11;
				if (result > 21) {
					result -= 10;
				}
			} else if (dealer_card[i] == "J" || dealer_card[i] == "Q" || dealer_card[i] == "K") {
				result += 10;
			} else if (dealer_card[i] == null) {

			} else {
				result += Integer.parseInt(dealer_card[i]);
			}

			if (result > 21) {
				if (dealer_card[i] == "A") {
					result -= 10;
				}
			}
		}
		return result;

	}

}
