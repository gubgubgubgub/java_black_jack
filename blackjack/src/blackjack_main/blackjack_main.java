package blackjack_main;
import java.util.*;
//black jack 처리 아직


public class blackjack_main {
	
	
	public static void  main(String[] args){
				
		int num=0; // 플레이어의 수
		int i=0;
		int final_result =0;
		
		player player1 = new player();	
		player player2 = new player();
		dealer dealer = new dealer();
		card card = new card();
		// 쓰레드
		//my_tread r = new my_tread();
		//r.start();
		//Thread t = new Thread(r);
		//t.start();
		//bgm
		music bgm = new music();
		bgm.bgm();
		
		dot_picture dot_picture = new dot_picture();
		
		Scanner sc = new Scanner(System.in);
		dot_picture.black_jack();
		System.out.println("=============================Black Jack 게임을 시작합니다=============================");
		System.out.println("");
		System.out.println("==============================>>>>게임 설명<<<<====================================");
		System.out.println("===	1.플레이어 수는 최대 2명까지 가능하며 둘중 한명이라도 재산이 100만원 이상이 되면 게임 clear 입니다.");	
		System.out.println("===	2.딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임입니다.");
		System.out.println("===	3.Ace는 1 또는 11로 계산합니다.");
		System.out.println("===	4.King, Queen, Jack은 각각 10으로 계산합니다.");
		System.out.println("===	5.그 외의 카드는 카드에 표시된 숫자로 계산합니다.");
		System.out.println("===	6.처음 받은 2장의 카드 수가 21일때 black jack 입니다. 승리시 3배의 배팅금을 드립니다.");
		System.out.println("==================================================================================");
		System.out.println("==============================>>>>게임 방법<<<<=====================================");
		System.out.println("=================================================================================");
		System.out.println("===	1.베팅을 한 후 모든 플레이어와 딜러는 두 장의 카드를 받습니다.");
		System.out.println("===	2.딜러는 카드의 합이 17이 될 때까지 반드시 추가 카드를 뽑아야 합니다.");
		System.out.println("===	3.플레이어는 카드의 합이 21을 넘지 않는 범위 내에서 추가 카드를 받을 수도,받지 않을 수도 있습니다.");
		System.out.println("=================================================================================");
		while(i==0) {
			 System.out.println(">>>>>>>>>게임 하실 플레이어 수를 입력하세요 최대 2명<<<<<<<<<<<<<<<"); 
			num = sc.nextInt();
			if(num == 1) {
				System.out.printf("플레이어1의 이름을 정해주세요 ");
				player1.player_name = sc.next();
				System.out.println("");
				System.out.printf(player1.player_name + "님 보유중인 돈은 정해주세요\n");
				System.out.printf("최소 10만원 이상 50만원 이하로 입력해주세요(만원 단위) :");
				player1.money = sc.nextInt();
				System.out.println();
				while (player1.money > 50 || player1.money < 10) {
					System.out.printf("다시 입력해주세여(10만원 이상 50만원 이하) ");
					player1.money = sc.nextInt();
				}
				i=1;
			}else if(num == 2) {
				System.out.printf("플레이어1의 이름을 정해주세요: ");
				player1.player_name = sc.next();
				System.out.println("");
				System.out.printf(player1.player_name + "님 보유중인 돈은 정해주세요\n");
				System.out.printf("최소 10만원 이상 50만원 이하로 입력해주세요(만원 단위) :");
				player1.money = sc.nextInt();
				System.out.println();
				while(player1.money > 50 || player1.money < 10) {
					System.out.printf("다시 입력해주세여(10만원 이상 50만원 이하) ");
					player1.money = sc.nextInt();
				}
				
				System.out.printf("플레이어2의 이름을 정해주세요: ");
				player2.player_name = sc.next();
				
				while(player1.player_name == player2.player_name) {
					System.out.printf("플레이어 1이랑 이름이 같습니다. 다시입력해주세요 :");
					player2.player_name = sc.next();
				}
				System.out.println("");
				System.out.printf(player2.player_name + "님 보유중인 돈은 정해주세요\n ");
				System.out.printf("최소 10만원 이상 50만원 이하로 입력해주세요(만원 단위) :");
				player2.money = sc.nextInt();
				while(player2.money > 50 || player2.money < 10) {
					System.out.printf("다시 입력해주세여(10만원 이상 50만원 이하) ");
					player2.money = sc.nextInt();
				}
			i=1;
			}else {
			System.out.println("잘못된 수 입니다."); 	
			}
		}
		//player1, player2 돈 이름 결정
		
		while(player1.money<100 && player2.money<100) {
			if(num == 1) {
				if(player1.money == 0) {
					System.out.println("가진돈을 전부 잃었습니다. ㅠㅠㅠㅠ");
					dot_picture.game_over();
					break;
				}
			}else {
				if(player2.money <= 0 && player1.money <= 0) {
					System.out.println("가진돈을 전부 잃었습니다. ㅠㅠㅠㅠ");
					dot_picture.game_over();
					break;
				}
			}
			System.out.println("");
			for(int j =3; j>0; j--) {
				System.out.printf("%d초 후 자동으로 게임이 시작합니다.\n",j);
				try {
					Thread.sleep(1000); //4초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
					
			dot_picture.play();
			System.out.println("");
			System.out.println("");
			int select=0;
			int over=0;
			int result=2;
			
			
			
			card.player1_card = new String[10];
			card.player2_card = new String[10];
			card.dealer_card = new String[10];
			player1.bet_money = 0;
			player2.bet_money = 0;
			
			if(num==1){
				player1.bet();
				
			}else {
				if(player1.money>1)
				player1.bet();
				
				if(player2.money>1)
				player2.bet();
				}// 배팅 완료
			
			int player1_money_sum = player1.money + player1.bet_money;
			int player2_money_sum = player2.money + player2.bet_money;
			
			card.dealer_card[0] = card.dack();
			card.first_card(num, player1_money_sum, player2_money_sum, player1.player_name, player2.player_name );
			card.show_card(player1.player_name, player2.player_name, num);
			if((player1.money + player1.bet_money) != 0) {
				if(21>card.card_total_num(card.player1_card)) {
					System.out.printf("%s님 차례입니다.\n",player1.player_name); // player1차례
					System.out.println("1.Hit 2.Stay 3.Info ");
					select = sc.nextInt();
					System.out.println("");
					while(select ==3) {
						card.show_card(player1.player_name, player2.player_name, num);
						select = sc.nextInt();
						System.out.printf("%s님 차례입니다.\n",player1.player_name); // player2차례
						System.out.println("1.Hit 2.Stay 3.Info");
					}
				}
				
				if(select == 2) {
					System.out.printf("Stay!!! 차례를 넘깁니다.\n");
					System.out.println("");	
				}else if(select == 0){
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆☆★☆");
					System.out.println(player1.player_name+"님 BLACK JACK!!!! 최강의 수");
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆☆★☆");
					dot_picture.hit_blackjack();
				}else if(select == 1){
					while(select==1 && over<21) { // stay or bust
						if(select == 1) {
							System.out.printf("Hit!!! 카드 한장을 받습니다.\n");
							over = player1.Hit(card.player1_card);
							card.show_card(player1.player_name, player2.player_name, num);
							if(over>21) {
								System.out.println("※※※※※※※※※※※※※※※※※※※");
								System.out.printf("%s님 BUST\n",player1.player_name);
								System.out.println("※※※※※※※※※※※※※※※※※※※");
								dot_picture.bust();
								System.out.println("");
								card.player1_card = new String[10];
								card.player1_card[0] = "bust";
								break;
							}else if(over == 21) {
								System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆");
								System.out.println("21!!!! 최강의 수");
								System.out.printf("차례를 자동으로 넘깁니다.\n");
								System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆");
								break;
							}
						}else if(select == 2) {
							System.out.printf("Stay!!! 차례를 넘깁니다.\n");
							System.out.println("");
						}
						System.out.println("1.Hit 2.Stay 3.Info");
						select = sc.nextInt();
						System.out.println("");
					}
				}
			}
			
				if((player2.money + player2.bet_money) != 0) {
				over=0;
				select =0;
				if(21>card.card_total_num(card.player2_card)) {
					System.out.printf("%s님 차례입니다.\n",player2.player_name); // player2차례
					System.out.println("1.Hit 2.Stay 3.Info");
					select = sc.nextInt();
					System.out.println("");
				}
				
				while(select ==3) {
					card.show_card(player1.player_name, player2.player_name, num);
					System.out.printf("%s님 차례입니다.\n",player2.player_name); // player2차례
					System.out.println("1.Hit 2.Stay 3.Info");
					select = sc.nextInt();
				}
				if(select == 2) {
					System.out.printf("Stay!!! 차례를 넘깁니다.\n");
					System.out.println("");
				}else if(select == 0){
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					System.out.println(player1.player_name+"BLACK JACK!!!! 최강의 수");
					System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
					dot_picture.hit_blackjack();
				}else if(select == 1){
					while(select==1 && over<21) { // stay or bust
						if(select == 1) {
							System.out.printf("Hit!!! 카드 한장을 받습니다.\n");
							over = player2.Hit(card.player2_card);

							card.show_card(player1.player_name, player2.player_name, num);
							if(over>21) { 
								System.out.println("※※※※※※※※※※※※※※※※※※※");
								System.out.println(player2.player_name+"님 BUST");
								System.out.println("※※※※※※※※※※※※※※※※※※※");
								dot_picture.bust();
								System.out.println("");
								card.player2_card = new String[10];
								card.player2_card[0] = "bust";
								break;
							}else if(over == 21) {
								System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆");
								System.out.println("21!!!! 최강의 수");
								System.out.printf("차례를 넘깁니다.\n");
								System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆");
								System.out.println("");
								break;
							}
						}else if(select == 2) {
							System.out.printf("Stay!!! 차례를 넘깁니다.\n");
							System.out.println("");
						}
						System.out.println("1.Hit 2.Stay 3.Info");
						select = sc.nextInt();
						System.out.println("");
					}
				}
				// 딜러 뽑고 계산
	
				}
				if(card.player2_card[0] == "bust" && card.player1_card[0] == "bust") {
					System.out.println("※※※※※※※※※※※※※※※※※※※");
					System.out.println("플레이어 전부 BUST!!!!");
					System.out.println("※※※※※※※※※※※※※※※※※※※");
				}else {
					if(card.player2_card[0] == "bust" && card.player1_card[0] == null) {
						result=3;
					}else if(card.player1_card[0] == "bust" && card.player2_card[0] == null) {
						result=3;
					}else {
						System.out.println("※※※※※※※※※※");
						System.out.printf("딜러 카드 오픈.\n");
						System.out.println("※※※※※※※※※※");
						for(int j=3; j>0; j--) {
							System.out.printf("%d\n",j);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						
						while(result==2) {
							result = dealer.dealer_hit(card.dealer_card);
							card.show_card(player1.player_name, player2.player_name, num);
							if(result == 0) {
								System.out.println("※※※※※※※※※※");
								System.out.println("딜러 STOP!!!");
								System.out.println("※※※※※※※※※※");
							}else if(result == 1) {
								System.out.println("※※※※※※※※※※");
								System.out.println("딜러 버스트!!!");
								System.out.println("※※※※※※※※※※");
								dot_picture.bust();
							}else if(result == 2) {
								System.out.println("※※※※※※※※※※");
								System.out.println("한번더 뽑습니다.");
								System.out.println("※※※※※※※※※※");
								for(int j=3; j>0; j--) {
									System.out.printf("%d\n",j);
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									}
								}
							}
						}
					}
				
				if(result == 1) { // bust
					System.out.printf("승리 하신분은 배팅 금액 2배를 드립니다.\n");
					if(card.player1_card[0] != "bust" && card.player1_card[0] != null) {
						player1.money += (player1.bet_money)*2;
						System.out.printf("%s님 %d만원 획득.\n",player1.player_name, player1.bet_money);
					}
					
					if(card.player2_card[0] != "bust" && card.player2_card[0] != null) {
						player2.money += (player2.bet_money)*2;
						System.out.printf("%s님 %d만원 획득.\n",player2.player_name, player2.bet_money);
					}	
					
				}else if(result == 0) { // vs
					if(card.player1_card[0] != "bust" && card.player1_card[0] != null) {
						final_result  = card.vs(1,card.player1_card); // 1->player1 2->player2
						if(final_result == 0) {//  0-> 짐 1-> 이김 2->비김
							if(card.player1_card[0] == "bust")
							System.out.printf("%s님 bust입니다 . 0원 획득.\n",player1.player_name);
							else
							System.out.printf("%s님 딜러보다 패가 낮습니다. 0원 획득.\n",player1.player_name);	
						}else if(final_result == 1) {
							System.out.printf("%s님 딜러보다 패가 높습니다. %d만원 획득.\n",player1.player_name, (player1.bet_money)*2);
							player1.money += (player1.bet_money)*2;
						}else if(final_result ==2) {
							System.out.printf("%s님 딜러랑 비겼습니다 배팅금액을 돌려드립니다.\n",player1.player_name);
							player1.money += (player1.bet_money);
						}
					}	
					if(card.player2_card[0] != "bust" && card.player2_card[0] != null) {
							if(num == 2) {
								final_result = card.vs(2, card.player2_card);//  0-> 짐 1-> 이김 2->비김
								if(final_result == 0) {
									if(card.player2_card[0] == "bust")
									System.out.printf("%s님 bust입니다 . 0원 획득.\n",player2.player_name);
									else
									System.out.printf("%s님 딜러보다 패가 낮습니다. 0원 획득.\n",player2.player_name);	
								}else if(final_result == 1) {
									System.out.printf("%s님 딜러보다 패가 높습니다. %d만원 획득.\n",player2.player_name, (player2.bet_money)*2);
									player2.money += (player2.bet_money)*2;
								}else if(final_result ==2) {
									System.out.printf("%s님 딜러랑 비겼습니다 배팅금액을 돌려드립니다.\n",player2.player_name);
									player2.money += (player2.bet_money);
								}
							}
					}else if(card.player2_card[0] == "bust") {
						System.out.printf("%s님 BUST로. 0원 획득.\n",player2.player_name);
					}
				}
				System.out.println("");
			}
			
		}

		
		if(player1.money >= 100 || player2.money >= 100) {
			if(num==1) {
				player1.info();	
			}
			else {
				player1.info();
				player2.info();
			}
			dot_picture.game_win();
		}
		
		

	sc.close();		
	}	
}
		



















