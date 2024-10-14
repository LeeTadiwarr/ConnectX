/* The game that keeps track of all the information, such as
 * the grid and which player's turn */
public class ConnectX {
  public final static int DEFAULT_HEIGHT =  6;    // The default height of the grid (DO NOT CHANGE)
  public final static int DEFAULT_WIDTH  =  7;    // The default width of the grid (DO NOT CHANGE)
  public final static int TOTAL_ROUNDS   =  4;    // The total round of games (DO NOT CHANGE)

  private Disc[][] grid;                          // The grid of the game. A 2D array of Disc objects
  private Player[] allPlayers;                    // An array that stores all the player's object
  private Player currPlayer;                      // Keeps track of the current player
  private int currRound;                          // Keep track of the current round
  private int numConnect;                         // The number of connected discs to win.

  //======================= CONSTRUCTOR =======================//
  /* Initialize the game's instance variables. */
  public ConnectX() {
      this(4); // Default number of connected discs to win is 4
  }

  /* Initialize the game's instance variables. 
   * @param numConnect - Number of connected discs to win. */
  public ConnectX(int numConnect) {
      if (numConnect < 2 || numConnect > 6) {
          throw new IllegalArgumentException("Number of discs to connect must be between 2 and 6.");
      }
      this.numConnect = numConnect;
      this.grid = new Disc[DEFAULT_HEIGHT][DEFAULT_WIDTH];
      this.allPlayers = new Player[2]; // Assuming 2 players (O and X)
      this.allPlayers[0] = new Player(Disc.O_DISC); // Player O
      this.allPlayers[1] = new Player(Disc.X_DISC); // Player X
      this.currPlayer = allPlayers[0]; // Player O starts first
      this.currRound = 1; // Start at round 1
  }

  //====================== PRIVATE METHOD =======================//
  /* (Put your private methods here) */

  //====================== PUBLIC METHOD =======================//
  /* Get the current round number. 
   * First round will be 1, second round will be 2, etc...
   * @return - The current round number. */
  public int GetCurrRound() {
      return currRound;
  }

  /* Increment the round number by 1. */
  public void NextRound() {
      currRound++;
      ResetGrid();
  }

  /* Get the 2D array Disc array
   * @return - The 2D grid containing Disc objects */
  public Disc[][] GetGrid() {
      return grid;
  }

  /* Resets the grid so it contains no objects */
  public void ResetGrid() {
      grid = new Disc[DEFAULT_HEIGHT][DEFAULT_WIDTH];
  }

  /* Get the player object array  
   * @return - The array that contains all the players' object */
  public Player[] GetAllPlayers() {
      return allPlayers;
  }

  /* Returns the current player object
   * @return - The current player's object */
  public Player GetCurrPlayer() {
      return currPlayer;
  }

  /* Set who will be the current player
   * @param index - The value that represents the player. This
   *                is based on the array position of where the 
   *                player is stored. */
  public void SetCurrPlayer(int index) {
      if (index >= 0 && index < allPlayers.length) {
          currPlayer = allPlayers[index];
      }
  }  

  /* Switch player's turn to the next player (If current player is X, then it 
   * switches to O. If current player is O, then it switches to X) */   
  public void SwitchPlayer() {
      currPlayer = (currPlayer == allPlayers[0]) ? allPlayers[1] : allPlayers[0];
  }  

  /* Check if the grid is full (Every block has a disc object)
   * @return - Returns true, if the grid is full.
   *           Returns false, if the grid is not full. */    
  public boolean IsGridFull() {
      for (int col = 0; col < DEFAULT_WIDTH; col++) {
          if (grid[0][col] == null) {
              return false; // Found an empty spot
          }
      }
      return true; // No empty spots
  }   

  /* Inserts a disc object in the specified column.
   * @param col - The column that the player wants to insert the disc
   *              Note: col = 0 is the 1st column 
   *                    col = 1 is the 2nd column
   *                    etc...
   * @return    - Returns 1, if the disc is inserted successfully into the column.
   *              Returns -1, if the column is full. 
   *              Returns -2, if the column is invalid. */    
  public int Insert(int col) {
      if (col < 0 || col >= DEFAULT_WIDTH) {
          return -2; // Invalid column
      }
      
      if (grid[0][col] != null) {
          return -1; // Column is full
      }

      for (int row = DEFAULT_HEIGHT - 1; row >= 0; row--) {
          if (grid[row][col] == null) {
              grid[row][col] = new Disc(currPlayer.GetDiscType());
              return 1; // Disc inserted successfully
          }
      }
      return -1; // Should not reach here since column check is done above
  }   

  /* Get the number of available (empty) blocks in the grid
   * @return - The number of empty blocks */
  public int NumAvailBlock() {
      int count = 0;
      for (int row = 0; row < DEFAULT_HEIGHT; row++) {
          for (int col = 0; col < DEFAULT_WIDTH; col++) {
              if (grid[row][col] == null) {
                  count++;
              }
          }
      }
      return count; // Return the count of empty blocks
  }   

  /* Get the current player's name (either X or O) as a char
   * @return - The player's name, either 'X' or 'O' */   
  public char GetCurrPlayerChar() {
      return currPlayer.GetDiscType() == Disc.O_DISC ? 'O' : 'X';
  }

  /* Check if there is a winner for the current round 
   * @return - Returns true, if there is a winner.
   *           Returns false, if there is no winner */      
  public boolean HasRoundWinner() {
      // Logic to check for a winner based on numConnect
      return false; // Placeholder
  }

  /* Determine the final winner by checking the player's score. 
   * @return - Returns the array position value that represents the player who wins.
   *           Returns -3, if there's a tie (same score) */
  public int HasGameWinner() {
      // Logic to determine if a player has won the game
      return -1; // Placeholder for no winner; return winner's disc type if there is one
  }
}