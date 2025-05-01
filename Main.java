import java.util.Scanner;

class Player {
    String name;
    char symbol;

    Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}

class Board {
    char[][] grid;

    Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = ' ';
    }

    void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + grid[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    }

    boolean placeMove(int row, int col, char symbol) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == ' ') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    boolean checkWin(char symbol) {
        // Rows, Columns, Diagonals
        for (int i = 0; i < 3; i++)
            if ((grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) ||
                (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol))
                return true;

        if ((grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
            (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol))
            return true;

        return false;
    }

    boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j] == ' ')
                    return false;
        return true;
    }
}

class Game {
    Player p1, p2;
    Board board;
    Scanner scanner;

    Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        board = new Board();
        scanner = new Scanner(System.in);
    }

    void start() {
        Player currentPlayer = p1;
        while (true) {
            board.printBoard();
            System.out.print(currentPlayer.name + " (" + currentPlayer.symbol + ") enter your move (row,col): ");
            String input = scanner.nextLine();
            String[] parts = input.split(",");
            if (parts.length != 2) {
                System.out.println("Invalid input. Use format row,col (e.g., 1,2)");
                continue;
            }

            try {
                int row = Integer.parseInt(parts[0].trim());
                int col = Integer.parseInt(parts[1].trim());

                if (!board.placeMove(row, col, currentPlayer.symbol)) {
                    System.out.println("Invalid move. Try again!");
                    continue;
                }

                if (board.checkWin(currentPlayer.symbol)) {
                    board.printBoard();
                    System.out.println(currentPlayer.name + " wins!");
                    break;
                }

                if (board.isFull()) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == p1) ? p2 : p1;

            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers. Try again!");
            }
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1 name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2 name: ");
        String name2 = scanner.nextLine();

        Player p1 = new Player(name1, 'X');
        Player p2 = new Player(name2, 'O');

        Game game = new Game(p1, p2);
        game.start();
    }
}

