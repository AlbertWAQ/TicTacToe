import java.util.Scanner;

public class TicTacToe{
	public static void main(String[] args) {
		char[][] board = initBoard();
		display(board);
		play(board);
	}
	
	public static void play(char[][] board) {
		int count = 1;
		
		do {
			System.out.println("Round " + count + ": ");
			System.out.println("Player 1");
			players(board, 1);
			display(board);
			if(check(board))
				return;
			System.out.println("Player 2");
			players(board, 2);
			display(board);
			if(check(board))
				return;
			count++;
		} while(true);
	}
	
	public static boolean check(char[][] board) {

		int scoreP1 = 0;
		int scoreP2 = 0;
		//check rows
		for(int row = 0; row < 3; row++) {
			scoreP1 = 0;
			scoreP2 = 0;
			for(int column = 0; column < 3; column++) {
				if(board[row][column] == 'x') scoreP1++;
				else if(board[row][column] == 'o') scoreP2++;
			}
			if(checkWinner(scoreP1, scoreP2))
				return true;
		}
		
		//check columns
		for(int column = 0; column < 3; column++) {
			scoreP1 = 0;
			scoreP2 = 0;
			for(int row = 0; row < 3; row++) {
				if(board[row][column] == 'x') scoreP1++;
				else if(board[row][column] == 'o') scoreP2++;
			}
			if(checkWinner(scoreP1, scoreP2))
				return true;
		}
		
		//check diagonal
		scoreP1 = 0;
		scoreP2 = 0;
		for(int row = 0, column = 2; row < 3; row++, column--) {
			if(board[row][column] == 'x') scoreP1++;
			else if(board[row][column] == 'o') scoreP2++;
		}
		if(checkWinner(scoreP1, scoreP2))
			return true;
		
		scoreP1 = 0;
		scoreP2 = 0;
		for(int row = 0; row < 3; row++) {
			if(board[row][row] == 'x') scoreP1++;
			else if(board[row][row] == 'o') scoreP2++;
		}
		if(checkWinner(scoreP1, scoreP2))
			return true;
		return false;
	}
	
	public static boolean checkWinner(int scoreP1, int scoreP2) {
		if(scoreP1 == 3) {
			System.out.println("P1 win!");
			return true;
		}
		else if(scoreP2 == 3) {
			System.out.println("P2 win!");
			return true;
		}
		return false;
	}
	
	public static void players(char[][] board, int playNum) {
		Scanner scanner = new Scanner(System.in); //scanner cannot be closed
		if(playNum == 1)
			board[inputRow(scanner)-1][inputColumn(scanner)-1] = 'x';
		else
			board[inputRow(scanner)-1][inputColumn(scanner)-1] = 'o';
	}
	
	public static int inputRow(Scanner input) {
		System.out.print("input row: ");
		int row = input.nextInt();
		return row;
	}
	
	public static int inputColumn(Scanner input) {
		System.out.print("input column: ");
		int column = input.nextInt();
		return column;
	}
	
	public static char[][] initBoard() {
		char[][] board = new char[3][3];
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++)
				board[r][c] = '_';
		}
		return board;
	}
	
	public static void display(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
}
