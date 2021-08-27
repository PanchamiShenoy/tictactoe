package com.yml.tictac;

import java.util.Scanner;

public class TicTacToeGame {

	public static char[] board = new char[10];
	public char playerCharacter, computerCharacter;

	Scanner sc = new Scanner(System.in);

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

	public static void main(String[] args) {

		System.out.println("welcome to TicTacToe");
		TicTacToeGame t = new TicTacToeGame();
		t.createBoard();
		t.selectCharacter();
		t.displayBoard();
	}

}
