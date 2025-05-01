# TicTacToe

I used an object-oriented approach for this project.
I  created the following classes:

1. Player: stores name and symbol
2. Board: handles the game grid, placing moves, checking win/draw
3. Game: controls turns and manages the overall flow

 Class: Player
   ➤ Purpose:
      Stores each player's name and symbol (X or O).

   class Player {
    String name;
    char symbol;

    Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}

 Class: Board
   ➤ Purpose:
      Handles the 3x3 grid, move validation, printing, win/draw checks.
   
    class Board {
      char[][] grid;

➤ Important methods:

   Constructor: Initializes a 3x3 board with spaces.

   printBoard(): Nicely prints the current board.

   placeMove(row, col, symbol): Places a move if valid.

  checkWin(symbol): Checks all rows, columns, and diagonals for a win.

  isFull(): Detects a draw.

 Class: Game
   ➤ Purpose:
      Handles the game loop — alternating turns, taking inputs, checking for win/draw.
   
      class Game {
        Player p1, p2;
        Board board;

   ➤ Key method:
    start():
      Loops until the game ends.
      Takes input like 1,2 and parses it.
      Places move using the board object.
      Checks for win or draw.
      Switches players each turn.

 TicTacToe (Main Class)
   ➤ Purpose:
      Entry point of the program. Takes player names, creates objects, and starts the game.
   
      public class TicTacToe {
        public static void main(String[] args) {

 I’ve separated responsibilities across three classes: Board for the game state, Player for user data, and Game for coordinates it coordinates the interaction between the Board and the Players, and controls the overall flow of the game — from turn-taking to checking the win condition. This design makes it easier to test, extend (like adding a computer player), and maintain.















   
