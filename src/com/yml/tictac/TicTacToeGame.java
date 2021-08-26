package com.yml.tictac;

import java.util.Scanner;

public class TicTacToeGame {
	
	public static char[] board= new char[10];  
	public char playerCharacter, computerCharacter;
	
	Scanner sc = new Scanner(System.in);
	
	public void createBoard() {
		for(int i=1;i<board.length;i++)     //iterate through board array
		{
			board[i]=' ';
		}
		
	}
	
	public void selectCharacter() {

		System.out.println("Enter the input(X or O) ");
		playerCharacter=sc.next().charAt(0);
		if(playerCharacter == 'x'|| playerCharacter == 'X')
			{
			computerCharacter='o';
			playerCharacter='x';
			}
		else
			{
			computerCharacter='x';
			playerCharacter='o';
			}
	}
	public static void main(String[] args) {
		
		System.out.println("welcome to TicTacToe");
		TicTacToeGame t=new TicTacToeGame();
		t.createBoard();
		t.selectCharacter();
	}

}
