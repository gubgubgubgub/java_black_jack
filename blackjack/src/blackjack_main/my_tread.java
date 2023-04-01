package blackjack_main;

public class my_tread extends Thread  {

	public void run() {

		for(int i=0; i<5 ; i++) {
			System.out.println("tread trst = "+i);
		}
	}

}
