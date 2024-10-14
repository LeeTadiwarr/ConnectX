import java.util.Scanner;

public class ConnectXMain{
    /* The start of the game */
    public static void main(String[] args) {
        ConnectX cx; // Creates the ConnectX object (DO NOT DELETE IT)
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Connect X!");
        
        // Get the number of discs to connect from the user
        int numConnect;
        do {
            System.out.print("Enter the number of discs to connect (2-6): ");
            numConnect = scanner.nextInt();
        } while (numConnect < 2 || numConnect > 6);
        
        // Initialize the game with the specified number of discs to connect
        cx = new ConnectX(numConnect);
        
        // Main game loop
        while (cx.GetCurrRound() <= ConnectX.TOTAL_ROUNDS) {
            cx.ResetGrid();
            while (!cx.IsGridFull()) {
                System.out.println("Current Round: " + cx.GetCurrRound());
                System.out.println("Current Player: " + cx.GetCurrPlayerChar());
                System.out.println("Grid:");
                displayGrid(cx.GetGrid());
                
                System.out.print("Choose a column (0-6): ");
                int column = scanner.nextInt();
                
                int insertResult = cx.Insert(column);
                if (insertResult == -2) {
                    System.out.println("Invalid column! Please enter a column between 0 and " + (ConnectX.DEFAULT_WIDTH - 1) + ".");
                } else if (insertResult == -1) {
                    System.out.println("Column is full! Try again.");
                } else {
                    // Check for round winner
                    if (cx.HasRoundWinner()) {
                        System.out.println("Player " + cx.GetCurrPlayerChar() + " wins this round!");
                        break; // Exit to next round
                    }
                    // Switch to the next player
                    cx.SwitchPlayer();
                }
            }
            // Check if the grid is full without a winner
            if (cx.IsGridFull()) {
                System.out.println("The grid is full! It's a draw!");
            }
            cx.NextRound(); // Move to the next round
        }
        
        // Final game results
        int gameWinner = cx.HasGameWinner();
        if (gameWinner == -3) {
            System.out.println("The game is a tie!");
        } else if (gameWinner >= 0) {
            System.out.println("Player " + (gameWinner == Disc.O_DISC ? 'O' : 'X') + " wins the game!");
        } else {
            System.out.println("No winner for the game.");
        }

        scanner.close(); // Close the scanner
    }

    // Method to display the grid
    private static void displayGrid(Disc[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == null) {
                    System.out.print(". "); // Empty space
                } else {
                    System.out.print((grid[row][col].GetDiscType() == Disc.O_DISC ? 'O' : 'X') + " "); // Disc symbol
                }
            }
            System.out.println();
        }
        System.out.println(); // Extra line for better readability
    }
}