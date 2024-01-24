package baseball.player;

import java.io.IOException;
import java.util.Scanner;

public class User {
	private String guess;

	public String getGuess() {
		return guess;
	}

	public void getUserInput() throws IOException {
		Scanner scanner = new Scanner(System.in);

		String userInput = scanner.nextLine();

		setGuess(userInput);
	}

	private void setGuess(String guess) {
		this.guess = guess;
	}
}
