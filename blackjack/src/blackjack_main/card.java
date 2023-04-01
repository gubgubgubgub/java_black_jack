package blackjack_main;

import java.util.Random;

class card {
	String[] player1_card = new String[10];
	String[] player2_card = new String[10];
	String[] dealer_card = new String[10];

	public String dack() {

		int card;
		String change;
		Random random = new Random(); // 52장 -> 나중에

		card = random.nextInt(13) + 1;

		if (card == 11) {
			change = "J"; // j,q,k = 10, A=11 나중에 수정
			return change;
		} else if (card == 12) {
			change = "Q";
			return change;
		} else if (card == 13) {
			change = "K";
			return change;
		} else if (card == 1) {
			change = "A";
			return change;
		}
		change = Integer.toString(card);
		return change;
	}

	public void first_card(int num, int player1, int player2, String player1_name, String player2_name) {

		if (num == 1) {
			player1_card[0] = dack();
			player1_card[1] = dack();
		} else if (num == 2) {

			if (player1 > 0) {
				player1_card[0] = dack();
				player1_card[1] = dack();
			} else {
				System.out.println(player1_name + "님은 배팅금이 부족하여 게임에서 제외합니다.");
			}

			if (player2 > 0) {
				player2_card[0] = dack();
				player2_card[1] = dack();
			} else {
				System.out.println(player2_name + "님은 배팅금이 부족하여 게임에서 제외합니다.");
			}
		}

		dealer_card[0] = dack();

	}

	public void show_card(String player1, String player2, int num) {
		int i = 0;
		int sum = 0;
		System.out.println("================================");
		System.out.println("================================");
		System.out.printf("딜러의 카드: ");
		while (dealer_card[i] != null) {
			System.out.printf("[%s] ", dealer_card[i]);
			i++;
		}
		sum = card_total_num(dealer_card);
		System.out.printf("  카드 합: [%d] \n", sum);
		i = 0;
		if (player1_card[0] != null) {
			System.out.println();
			System.out.printf("%s 의 카드: ", player1);
			while (player1_card[i] != null) {
				System.out.printf("[%s] ", player1_card[i]);
				i++;
			}
		}
		sum = card_total_num(player1_card);

		if (player1_card[0] == "bust") {
			System.out.printf("  카드 합: [bust] \n");
		} else if (player1_card[0] != null) {
			System.out.printf("  카드 합: [%d] \n", sum);
		}

		i = 0;
		if (num == 2 && player2_card[0] != null) {
			System.out.println();
			System.out.printf("%s 의 카드: ", player2);
			while (player2_card[i] != null) {
				System.out.printf("[%s] ", player2_card[i]);
				i++;
			}
		}
		sum = card_total_num(player2_card);

		if (player2_card[0] == "bust") {
			System.out.printf("  카드 합: [bust] \n");
		} else if (player2_card[0] != null) {
			System.out.printf("  카드 합: [%d] \n", sum);
		}
		System.out.println("================================");
		System.out.println("================================");
		System.out.println();
		System.out.println();
	}

	public int card_total_num(String[] player_card) {
		int total_num = 0;

		for (int i = 0; i < player_card.length; i++) {
			if (player_card[i] == "A") {
				total_num += 11;
				if (total_num > 21) {
					total_num -= 10;
				}
			} else if (player_card[i] == "J" || player_card[i] == "Q" || player_card[i] == "K") {
				total_num += 10;
			} else if (player_card[i] == null || player_card[i] == "bust") {

			} else {
				total_num += Integer.parseInt(player_card[i]);
			}

			if (total_num > 21) {
				if (player_card[i] == "A") {
					total_num -= 10;
				}
			}

		}

		return total_num; // 0-> ok 1-> bust
	}

	public int vs(int player, String[] player_card) {
		int player_sum = 0;
		int dealer_sum = 0;
		int result = 0;

		player_sum = card_total_num(player_card);
		dealer_sum = card_total_num(dealer_card);

		if (player_sum < dealer_sum) {
			result = 0;
		} else if (player_sum == dealer_sum) {
			result = 2;
		} else {
			result = 1;
		}

		return result; // 0-> 짐 1-> 이김 2->비김
	}
	public int black_jack_check() {
		
		
		
		
		return 0;
	}

}
