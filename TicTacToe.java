/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    static Scanner in;
	static String[] board;
	static String turn;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		populateEmptyBoard();

		System.out.println("SELAMAT DATANG UNTUK 2 PEMAIN");
		System.out.println("--------------------------------");
		printBoard();
		System.out.println("X Akan bermain pertama. Masukkan nomor untuk menempatkan X:");

		while (winner == null) {
			int numInput;
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println("Gagal di masukkan; Ulangi masukkan nomor:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Gagal di masukkan; Ulangi masukkan nomor:");
				continue;
			}
			if (board[numInput-1].equals(String.valueOf(numInput))) {
				board[numInput-1] = turn;
				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
				printBoard();
				winner = checkWinner();
			} else {
				System.out.println("Slot sudah ditempati; Ulangi masukkan nomor:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("Permainan Draw! Terima Kasih telah bermain");
		} else {
			System.out.println("SELAMATTTT! " + winner + "'adalah pemenangnya! Terima Kasih");
		}
	}

	static String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println(turn + "'bermain; Masukkan nomor untuk menempatkan " + turn + ":");
		return null;
	}

	static void printBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}

	static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}
}