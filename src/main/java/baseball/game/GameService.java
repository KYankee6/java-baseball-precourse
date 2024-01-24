package baseball.game;

import java.util.Scanner;

import baseball.player.Computer;
import baseball.player.User;

public class GameService {
	private Game game;
	private User user;
	private Computer computer;

	public GameService(Game game, User user, Computer computer) {
		this.game = game;
		this.user = user;
		this.computer = computer;
	}

	public void judge() {
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
			if (numberOfBall > 0)
				System.out.print(" ");
			System.out.print(numberOfStrike + "스트라이크");
		}

		System.out.println();

		if (numberOfStrike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			game.stop();
		}
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

	public void userTurn() throws Exception {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		try {
			user.setGuess(input);
			validate();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void askUserWantToPlay() {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		user.setWantToPlay(input);
		if (user.getWantToPlay().equals("1")) {
			game.initialize();
		}
		if (user.getWantToPlay().equals("2")) {
			game.stop();
		}
	}

	public void validate() throws Exception {
		String pattern = "[0-9]{3}";
		String userGuess = user.getGuess();
		if (!userGuess.matches(pattern))
			throw new IllegalArgumentException();
	}
}
