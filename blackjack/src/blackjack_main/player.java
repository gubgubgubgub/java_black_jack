package blackjack_main;

import java.util.*;

public class player extends card {
	Scanner sc = new Scanner(System.in);
	public String player_name; // 이름
	public int money; // 보유 머니

	public int bet_money;

	public void bet() { // 배팅한 금액 return

		System.out.printf("%s님 배팅할 돈을 입력해주세요  재산:[%d]만원  ", player_name, money);

		while (true) {
			bet_money = sc.nextInt();
			if (bet_money > money) {
				System.out.println("보유중인 돈보다 더 배팅하셨습니다. 다시 배팅해주세요");
			} else {
				money -= bet_money;
				break;
			}
		}

		System.out.println(player_name + "님의 남은 금액: [" + money + "]만원");
		System.out.println();
	}

	public void info() {

		System.out.printf("%s의 최종 보유 금액은 [%d]만원 입니다\n", player_name, money);
		System.out.println();

	}

	public int Hit(String[] player_card) {
		int result = 0;

		for (int i = 0; i < player_card.length; i++) {
			if (player_card[i] == null) {
				player_card[i] = dack();
				break;
			}
		}
		result = card_total_num(player_card);
		return result;
	}

}
