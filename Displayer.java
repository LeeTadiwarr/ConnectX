public class Displayer {
    //======================= CONSTRUCTOR =======================//
    public Displayer() {
    }
  
    //====================== PUBLIC METHOD =======================//
    /* Displays the game title screen */
    public void GameHeader() {
        System.out.println("CURRENT SCORE--------------------");
    }
  
    /* Display the player's score on the screen 
     * @param o - Object that represents player O  
     * @param x - Object that represents player X */
    public void ScoreBoard(Player o, Player x) {
        System.out.println("PLAYER O: " + o.GetScore() + " points");
        System.out.println("PLAYER X: " + x.GetScore() + " points");
        System.out.println();
    }
  
    /* Display the current round number
     * @param roundNum - The current round's number */
    public void ShowRound(int roundNum) {
        System.out.println("*********** ROUND " + roundNum + " ***********");
        System.out.println();
    }
  
    /* Takes in a 2D array disc array and displays it on 
     * the screen, in a nice grid form.
     * @param grid - The 2D array that contains Disc objects */
    public void ShowGrid(Disc[][] grid) {
        // Print the grid
        for (int row = 0; row < grid.length; row++) {
            System.out.print(" |"); // Start of the row
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == null) {
                    System.out.print("   |"); // Empty space
                } else {
                    System.out.print(" " + (grid[row][col].GetDiscType() == Disc.O_DISC ? 'O' : 'X') + " |"); // Disc symbol
                }
            }
            System.out.println(); // End of the row
        }
        // Print the bottom border
        System.out.println(" ----------------------------- ");
        System.out.println(); // Extra line for better readability

        // Print column numbers
        System.out.print("COL ");
        for (int col = 1; col <= grid[0].length; col++) {
            System.out.print(" " + col + " ");
        }
        System.out.println();

        System.out.println("Player O, Select column to insert (1-7):"); // Prompt for column input
    }
}