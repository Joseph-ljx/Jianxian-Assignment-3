package Question1;

public class Room {

  /** Default constructor Initiate the floor [][] with all '0' */
  public Room() {
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {
        this.floor[i][j] = 0;
      }
    }
  }
  // floor of the Room, recording track
  public int[][] floor = new int[20][20];

  /**
   * General method on drawing the track of the dog (pen is down)
   *
   * @param row X
   * @param column Y
   * @param forward Increment
   * @param direction direction
   */
  public void traceTrack(int row, int column, int forward, String direction) {
    switch (direction) {
      case "East":
        for (int j = column; j <= (column + forward); j++) {
          this.floor[row][j] = 1;
        }
        break;
      case "North":
        for (int i = (row - forward); i <= row; i++) {
          this.floor[i][column] = 1;
        }
        break;
      case "West":
        for (int j = (column - forward); j <= column; j++) {
          this.floor[row][j] = 1;
        }
        break;
      case "South":
        for (int i = row; i <= (row + forward); i++) {
          this.floor[i][column] = 1;
        }
        break;
    }
  }

  /** Display the floor with track */
  public void displayFloor() {
    System.out.print("---------------------");
    for (int i = 0; i < 20; i++) {
      System.out.println(" ");
      for (int j = 0; j < 20; j++) {
        if (this.floor[i][j] == 1) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.print("|");
    }
    System.out.println(" ");
    System.out.print("---------------------");
    System.out.println(" ");
  }
}
