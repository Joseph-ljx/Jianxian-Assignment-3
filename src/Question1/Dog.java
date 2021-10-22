package Question1;

public class Dog {
  private boolean pen = false; // false = up, true = down;
  private String direction = "East"; // default face side is East
  private int x = 0; // horizontal axis - x (column)
  private int y = 0; // vertical axis - y (row)

  /**
   * Push up or down the pan
   *
   * @param pen true = down & false = up
   */
  public void setPen(boolean pen) { // set to up or down
    this.pen = pen;
  }

  public boolean getPen() { // up or down
    return this.pen;
  }

  /**
   * Get the current location of the dog
   *
   * @return (x,y)
   */
  public String getLocation() {
    return "(" + this.x + "," + this.y + ")";
  }

  /** The dog moves freely when the pen is up */
  public void moveFreely() {
    this.x = (int) (Math.random() * 20);
    this.y = (int) (Math.random() * 20);
  }

  /**
   * Move to a new location
   *
   * @param increment How many grids to increase
   * @param direction Current direction
   */
  public void moveNewLocation(int increment, String direction) {
    switch (direction) {
      case "South":
        this.y += increment;
        break;
      case "East":
        this.x += increment;
        break;
      case "North":
        this.y -= increment;
        break;
      case "West":
        this.x -= increment;
        break;
    }
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  /** @return The dog's current direction */
  public String getDirection() {
    return this.direction;
  }

  /** Turn left to face a new direction */
  public void turnLeft() {
    switch (this.direction) {
      case "East":
        this.direction = "North";
        break;
      case "North":
        this.direction = "West";
        break;
      case "West":
        this.direction = "South";
        break;
      default:
        this.direction = "East";
        break;
    }
  }

  /** Turn right to face a new direction */
  public void turnRight() {
    switch (this.direction) {
      case "East":
        this.direction = "South";
        break;
      case "South":
        this.direction = "West";
        break;
      case "West":
        this.direction = "North";
        break;
      default:
        this.direction = "East";
        break;
    }
  }
}
