package com.yml.tictac;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	public static char[] board = new char[10];
	public char playerCharacter, computerCharacter;
	public char turn = ' ';
	public int index = 0;
	public int t = 0;

	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	public void createBoard() {
		for (int i = 1; i < board.length; i++) // iterate through board array
		{
			board[i] = ' ';
		}

	}

	public void displayBoard() {

		System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3] + " ");
		System.out.println("-----------");
		System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6] + " ");
		System.out.println("-----------");
		System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + " ");

	}

	public void selectCharacter() {

		System.out.println("Enter the input(X or O) ");
		playerCharacter = sc.next().charAt(0);
		if (playerCharacter == 'x' || playerCharacter == 'X') {
			computerCharacter = 'o';
			playerCharacter = 'x';
		} else {
			computerCharacter = 'x';
			playerCharacter = 'o';
		}
	}

	public void desiredLocation() {
		while (t == 0) {
			turn = 'p';
			System.out.println("Player is playing");
			System.out.println("Please enter the index 1 to 9");
			index = sc.nextInt();
			if (index < 1 || index > 9) {
				System.out.println("Please enter the valid index");
				desiredLocation();
			} else {
				checkSpace();
			}
		}
	}

	public void checkSpace() {

		if (board[index] == ' ') {
			board[index] = playerCharacter;
			displayBoard();
			checkWinner();
		} else {
			System.out.println("Please enter different index current one is already filled!!!");
			desiredLocation();
			checkSpace();
		}

	}

	public void toss() {
		System.out.println("Player do you want to choose head or tail (1 or 0)");
		int choice = sc.nextInt();

		int flipResult = rn.nextInt(2);
		if (choice == flipResult) {
			System.out.println("Its player's turn!!!");
			turn = 'p';
			desiredLocation();

		} else {
			System.out.println("Its computer's turn!!!");
			turn = 'c';
			computerStratergy();

		}

	}

	public char isWin() {
		String line = null;

		for (int a = 1; a < 10; a++) {

			switch (a) {
			case 1:
				line = "" + board[1] + board[2] + board[3];
				break;
			case 2:
				line = "" + board[4] + board[5] + board[6];
				break;
			case 3:
				line = "" + board[7] + board[8] + board[9];
				break;
			case 4:
				line = "" + board[1] + board[4] + board[7];
				break;
			case 5:
				line = "" + board[2] + board[5] + board[8];
				break;
			case 6:
				line = "" + board[3] + board[6] + board[9];
				break;
			case 7:
				line = "" + board[1] + board[5] + board[9];
				break;
			case 8:
				line = "" + board[3] + board[5] + board[7];
				break;
			}

			if (line.equals("xxx")) {
				return 'x';
			}

			else if (line.equals("ooo")) {
				return 'o';
			}
		}
		int a1;

		for (a1 = 1; a1 < 10; a1++) {

			if (board[a1] == ' ') {
				break;
			}
		}
		if (a1 == 10)
			return 'd';
		else
			return 'n';
	}

	public void checkWinner() {

		char win = isWin();
		System.out.println(win);
		if (win == playerCharacter) {
			System.out.println("Congratulations!!!! You have won the game");
			t = 1;
		} else if (win == computerCharacter) {
			System.out.println("Sorry!!!Computere has won the game");
			t = 1;
		} else if (win == 'd') {
			System.out.println("It's a draw! Thanks for playing");
			t = 1;
		} else if (win == 'n') {
			if (turn == 'p') {
				turn = 'c';
				computerStratergy();

			} else {
				turn = 'p';
				desiredLocation();

			}

		}
	}

	public void computerStratergy() {
		turn = 'c';
		System.out.println("Computer is playing!!!");
		if ((board[1] == ' ') && ((board[2] == board[3] && board[2] == computerCharacter)
				|| (board[4] == board[7] && board[4] == computerCharacter)
				|| (board[5] == board[9] && board[5] == computerCharacter))) {
			board[1] = computerCharacter;

		} else if ((board[2] == ' ') && ((board[1] == board[3] && board[3] == computerCharacter)
				|| (board[5] == board[8] && board[8] == computerCharacter))) {
			board[2] = computerCharacter;

		} else if ((board[3] == ' ') && ((board[1] == board[2] && board[2] == computerCharacter)
				|| (board[6] == board[9] && board[9] == computerCharacter)
				|| (board[5] == board[7] && board[7] == computerCharacter))) {
			board[3] = computerCharacter;

		} else if ((board[4] == ' ') && ((board[1] == board[7] && board[1] == computerCharacter)
				|| (board[5] == board[6] && board[6] == computerCharacter))) {
			board[4] = computerCharacter;
		} else if ((board[5] == ' ') && ((board[1] == board[9] && board[2] == computerCharacter)
				|| (board[7] == board[3] && board[7] == computerCharacter)
				|| (board[2] == board[8] && board[8] == computerCharacter)
				|| (board[4] == board[6] && board[6] == computerCharacter))) {
			board[5] = computerCharacter;

		} else if ((board[6] == ' ') && ((board[9] == board[3] && board[3] == computerCharacter)
				|| (board[5] == board[4] && board[4] == computerCharacter))) {
			board[6] = computerCharacter;

		} else if ((board[7] == ' ') && ((board[1] == board[4] && board[4] == computerCharacter)
				|| (board[3] == board[5] && board[3] == computerCharacter)
				|| (board[8] == board[9] && board[8] == computerCharacter))) {
			board[7] = computerCharacter;

		} else if ((board[8] == ' ') && ((board[9] == board[7] && board[7] == computerCharacter)
				|| (board[2] == board[5] && board[2] == computerCharacter))) {
			board[8] = computerCharacter;

		} else if ((board[9] == ' ') && ((board[1] == board[5] && board[5] == computerCharacter)
				|| (board[6] == board[3] && board[3] == computerCharacter)
				|| (board[8] == board[7] && board[7] == computerCharacter))) {
			board[9] = computerCharacter;

		} else if ((board[1] == ' ') && ((board[2] == board[3] && board[2] == playerCharacter)
				|| (board[4] == board[7] && board[4] == playerCharacter)
				|| (board[5] == board[9] && board[5] == playerCharacter))) {
			board[1] = computerCharacter;

		}

		else if ((board[2] == ' ') && ((board[1] == board[3] && board[3] == playerCharacter)
				|| (board[5] == board[8] && board[8] == playerCharacter))) {
			board[2] = computerCharacter;
		}

		else if ((board[3] == ' ') && ((board[1] == board[2] && board[2] == playerCharacter)
				|| (board[6] == board[9] && board[9] == playerCharacter)
				|| (board[5] == board[7] && board[7] == playerCharacter))) {
			System.out.println("13");
			board[3] = computerCharacter;
		}

		else if ((board[4] == ' ') && ((board[1] == board[7] && board[7] == playerCharacter)
				|| (board[5] == board[6] && board[6] == playerCharacter))) {
			board[4] = computerCharacter;
		}

		else if ((board[5] == ' ') && ((board[1] == board[9] && board[1] == playerCharacter)
				|| (board[7] == board[3] && board[7] == playerCharacter)
				|| (board[2] == board[8] && board[8] == playerCharacter)
				|| (board[4] == board[6] && board[6] == playerCharacter))) {
			board[5] = computerCharacter;
		}

		else if ((board[6] == ' ') && ((board[9] == board[3] && board[3] == playerCharacter)
				|| (board[5] == board[4] && board[4] == playerCharacter))) {
			board[6] = computerCharacter;
		}

		else if ((board[7] == ' ') && ((board[1] == board[4] && board[4] == playerCharacter)
				|| (board[8] == board[9] && board[9] == playerCharacter)
				|| (board[5] == board[3] && board[3] == playerCharacter))) {
			board[7] = computerCharacter;
		}

		else if ((board[8] == ' ') && ((board[9] == board[7] && board[7] == playerCharacter)
				|| (board[2] == board[5] && board[2] == playerCharacter))) {
			board[8] = computerCharacter;
		}

		else if ((board[9] == ' ') && ((board[1] == board[5] && board[5] == playerCharacter)
				|| (board[6] == board[3] && board[3] == playerCharacter)
				|| (board[8] == board[7] && board[7] == playerCharacter))) {
			board[9] = computerCharacter;
		}

		else {
			computerPlay();
		}
		displayBoard();
		checkWinner();
		desiredLocation();
	}

	public void computerPlay() {
		while (true) {
			int index = rn.nextInt(9) + 1;
			if (board[index] == ' ') {
				board[index] = computerCharacter;
				break;
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("welcome to TicTacToe");
		TicTacToeGame t = new TicTacToeGame();
		t.createBoard();
		t.selectCharacter();
		t.toss();

	}

}
