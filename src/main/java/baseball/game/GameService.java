package baseball.game;

import java.io.IOException;

import baseball.player.Computer;
import baseball.player.User;

public class GameService {
	private User user;
	private Computer computer;

	public GameService(User user, Computer computer) {
		this.user = user;
		this.computer = computer;
	}

	public void judge(Game game) {
		int numberOfStrike = 0;
		int numberOfBall = 0;
		numberOfBall = countCharacterInSameIndex(user.getGuess(), computer.getRandomNumbers());
		numberOfStrike = countCharacterInDifferentIndex(user.getGuess(), computer.getRandomNumbers());

		if (numberOfBall == 0 && numberOfStrike == 0) {
			System.out.print("낫싱");
		}

		if (numberOfBall > 0) {
			System.out.print(numberOfBall + "볼");
		}

		if (numberOfStrike > 0) {
			if(numberOfBall> 0)
				System.out.print(" ");
			System.out.print(numberOfStrike + "스트라이크");
		}

		System.out.println();

		if (numberOfStrike == 3){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			game.stop();
		}
	}

	public void userTurn() {
		try {
			user.getUserInput();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void validate() throws Exception{
		String pattern = "[0-9]{3}";
		if(!user.getGuess().matches(pattern))
			throw new IllegalArgumentException();
	}

	private int countCharacterInSameIndex(String input1, String input2) {
		int count = 0;
		for (int i = 0; i < input1.length(); i++) {
			if (input1.charAt(i) == input2.charAt(i))
				count++;
		}
		return count;
	}

	private int countCharacterInDifferentIndex(String input1, String input2) {
		int count = 0;
		for (int i = 0; i < input1.length(); i++) {
			String target = input1.substring(i, i);
			if (input2.indexOf(target) == i)
				count++;
		}
		return count;
	}


}
