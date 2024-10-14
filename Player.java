public class Player {
  private int discType; // Type of disc (0 for O, 1 for X)
  private int score;    // Player's score

  //======================= CONSTRUCTOR =======================//
  /* @discType - The type of disc that is being created (Either O or X) */
  public Player(int discType) {
      this.discType = discType; // Initialize the disc type
      this.score = 0;           // Initialize score to 0
  }

  //====================== PUBLIC METHOD =======================//
  /* Gets the player's disc type (0 or 1)
   * @return - The value of the disc type */
  public int GetDiscType() {
      return discType; // Return the player's disc type
  }

  /* Gets the player's score 
   * @return - The player's score */
  public int GetScore() {
      return score; // Return the player's score
  }

  /* Add scores to the player's existing score
   * @param score - The score that needs to be added
   *                to the player's score */
  public void AddScore(int score) {
      this.score += score; // Increment the player's score by the given amount
  }
}