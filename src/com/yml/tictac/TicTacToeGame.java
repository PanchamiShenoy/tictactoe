package com.yml.tictac;

public class TicTacToeGame {
	
	public static char[] board= new char[10];  
	
	public void createBoard() {
		for(int i=1;i<board.length;i++)     //iterate through board array
		{
			board[i]=' ';
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("welcome to TicTacToe");
		TicTacToeGame t=new TicTacToeGame();
		t.createBoard();
	}

}
