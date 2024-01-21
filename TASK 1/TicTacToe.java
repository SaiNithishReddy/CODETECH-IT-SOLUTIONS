// Task 1
// Tic-Tac-Toe Game
import java.util.Scanner;

public class TicTacToe {
    private final char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';

        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TicTacToe game = new TicTacToe();

            while (true) {
                game.printBoard();

                System.out.println("Player " + game.currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (game.makeMove(row, col)) {
                    if (game.checkWin()) {
                        game.printBoard();
                        System.out.println("Player " + game.currentPlayer + " wins!");
                        break;
                    }

                    if (game.isBoardFull()) {
                        game.printBoard();
                        System.out.println("It's a draw!");
                        break;
                    }

                    game.switchPlayer();
                }
            }
        }
    }
}