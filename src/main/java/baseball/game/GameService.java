package baseball.game;

import static baseball.Constant.*;

import baseball.player.Computer;
import baseball.player.User;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
		numberOfStrike = countCharacterInSameIndex(user.getGuess(), computer.getRandomNumbers());
		numberOfBall = countCharacterInDifferentIndex(user.getGuess(), computer.getRandomNumbers());

		if (numberOfBall == 0 && numberOfStrike == 0) {
			System.out.print(RESULT_NOTHING);
		}

		if (numberOfBall > 0) {
			System.out.print(numberOfBall + RESULT_BALL);
		}

		if (numberOfStrike > 0) {
			if (numberOfBall > 0)
				System.out.print(" ");
			System.out.print(numberOfStrike + RESULT_STRIKE);
		}

		System.out.println();

		if (numberOfStrike == 3) {
			System.out.println(RESULT_GAME_OVER);
			game.stop();
		}
	}

	private int countCharacterInSameIndex(String input1, String input2) {
		int count = 0;
		for (int i = 0; i < DIGIT_LENGTH; i++) {
			if (input1.charAt(i) == input2.charAt(i))
				count++;
		}
		return count;
	}

	private int countCharacterInDifferentIndex(String input1, String input2) {
		int count = 0;
		for (int i = 0; i < DIGIT_LENGTH; i++) {
			String target = Character.toString(input1.charAt(i));
			if (input2.indexOf(target) != i && input2.contains(target))
				count++;
		}
		return count;
	}

	public void userTurn() throws Exception {
		System.out.print(ENTER_THREE_DIGIT);

		String input = Console.readLine();
		try {
			user.setGuess(input);
			validate();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void askUserWantToPlay() {
		System.out.println(ENTER_RESTART_FLAG);

		String input = Console.readLine();
		user.setWantToPlay(input);
		if (user.getWantToPlay().equals(RESTART)) {
			game.initialize();
		}
		if (user.getWantToPlay().equals(END_GAME)) {
			game.exit();
		}

	}

	public void validate() throws Exception {
		String pattern = "[0-9]{3}";
		String userGuess = user.getGuess();
		if (!userGuess.matches(pattern))
			throw new IllegalArgumentException();
	}

	public void generateRandom() {
		StringBuilder randomStringBuilder = new StringBuilder();
		for (int i = 0; i < DIGIT_LENGTH; i++) {
			int randomNumber = Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
			String parsedRandomNumber = Integer.toString(randomNumber);

			while (randomStringBuilder.toString().contains(parsedRandomNumber)) {
				randomNumber = Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
				parsedRandomNumber = Integer.toString(randomNumber);

			}

			randomStringBuilder.append(parsedRandomNumber);
		}
		computer.setRandomNumbers(randomStringBuilder.toString());
	}
}
