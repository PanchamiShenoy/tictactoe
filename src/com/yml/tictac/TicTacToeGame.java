package com.yml.tictac;

import java.util.Scanner;

public class TicTacToeGame {

	public static char[] board = new char[10];
	public char playerCharacter, computerCharacter;
	public int index = 0;

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

	public void desiredLocation() {
		System.out.println("Player is playing");
		System.out.println("Please enter the index 1 to 9");
		index = sc.nextInt();
		if (index < 1 || index > 9) {
			System.out.println("Please enter the valid index");
			desiredLocation();
		}
		else {
			checkSpace();
		}
	}

	public void checkSpace()
	{
		
		if(board[index]==' ')					
		{
			board[index]=playerCharacter;
			displayBoard();
		}
		else
			{
				System.out.println("Please enter different index current one is already filled!!!");
				desiredLocation();					
				checkSpace();
			}
		
	}
	public static void main(String[] args) {

		System.out.println("welcome to TicTacToe");
		TicTacToeGame t = new TicTacToeGame();
		t.createBoard();
		t.selectCharacter();
		t.displayBoard();
		t.desiredLocation();
	}

}
