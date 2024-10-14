public class Displayer {
  //======================= CONSTRUCTOR =======================//
  public Displayer() {
  }

  //====================== PRIVATE METHOD ======================//
  // (Put your private methods here) */

  //====================== PUBLIC METHOD =======================//
  /* Displays the game title screen */
  public void GameHeader() {
      System.out.println("=================================");
      System.out.println("         Welcome to Connect X    ");
      System.out.println("=================================");
  }

  /* Display the player's score on the screen 
   * @param o - Object that represents player O  
   * @param x - Object that represents player X */
  public void ScoreBoard(Player o, Player x) {
      System.out.println("Scoreboard:");
      System.out.println("Player O: " + o.GetScore());
      System.out.println("Player X: " + x.GetScore());
      System.out.println();
  }

  /* Display the current round number
   * @param roundNum - The current round's number */
  public void ShowRound(int roundNum) {
      System.out.println("Current Round: " + roundNum);
  }

  /* Takes in a 2D array disc array and displays it on 
   * the screen, in a nice grid form.
   * @param grid - The 2D array that contains Disc objects */
  public void ShowGrid(Disc[][] grid) {
      for (int row = 0; row < grid.length; row++) {
          for (int col = 0; col < grid[row].length; col++) {
              if (grid[row][col] == null) {
                  System.out.print(". "); // Empty space
              } else {
                  System.out.print((grid[row][col].GetDiscType() == Disc.O_DISC ? 'O' : 'X') + " "); // Disc symbol
              }
          }
          System.out.println(); // New line for the next row
      }
      System.out.println(); // Extra line for better readability
  }
}