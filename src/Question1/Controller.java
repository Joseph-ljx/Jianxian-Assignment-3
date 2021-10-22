package Question1;

import java.util.Scanner;

public class Controller {

  /** Default controller: show the menu */
  public Controller() {
    this.Menu();
    do {
      this.action();
    } while (true); // while not exiting the command
  }

  public int command; // New command option
  Scanner sc = new Scanner(System.in);
  Dog d = new Dog(); // composition - control a dog
  Room r = new Room(); // composition - draw line on the floor

  /** Show the menu of the command */
  public void Menu() {
    System.out.println("Hi, the command list is as follows:");
    System.out.println("---------");
    System.out.println("1 - Pen up");
    System.out.println("2 - Pen down");
    System.out.println("3 - Turn right");
    System.out.println("4 - Turn left");
    System.out.println("5,10 - Move forward 10 spaces (10 could be replaced)");
    System.out.println("6 - Display the 20-by-20 floor Array");
    System.out.println("7 - Show the dog's current location");
    System.out.println("9 - End");
    System.out.println("---------");
    System.out.println("Please choose your option");
  }

  /** Action of the user */
  public void action() {
    System.out.print("Enter Command (9 to end input): ");
    this.command = sc.nextInt(); // input a command
    switch (this.command) { // options
      case 1:
        d.setPen(false);
        System.out.println("The pen is UP...");
        break;
      case 2:
        d.setPen(true);
        System.out.println("The pen is DOWN...");
        break;
      case 3:
        d.turnRight();
        System.out.println("The dog turns right...");

        break;
      case 4:
        d.turnLeft();
        System.out.println("The dog turns left...");

        break;
      case 5:
        if (!d.getPen()) {
          System.out.println("The pen is UP, not able to trace the track.");
          System.out.println("The dog will move freely without drawing anything.");
          System.out.println(
              "(Pen is down) The dog is now in the location of: "
                  + d.getLocation()
                  + ", facing: "
                  + d.getDirection());
          System.out.print("Please input the number of grids you want to forward: ");
          int forward = sc.nextInt(); // how many grids the dog will go forward
          d.moveNewLocation(forward, d.getDirection()); // move to new location
        } else { // the pen is down
          System.out.println(
              "(Pen is down) The dog is now in the location of: "
                  + d.getLocation()
                  + ", facing: "
                  + d.getDirection());
          System.out.print("Please input the number of grids you want to forward: ");
          int forward = sc.nextInt(); // how many grids the dog will go forward
          r.traceTrack(
              d.getY(), d.getX(), forward, d.getDirection()); // trace the track on the floor
          d.moveNewLocation(forward, d.getDirection()); // move to new location
        }
        break;
      case 6: // display the track
        r.displayFloor();
        break;
      case 7: // get the current location of the dog
        System.out.println("The dog is now in the place of: " + d.getLocation());
        break;
      case 9: // exit the command
        System.out.println("Exiting the command...");
        System.exit(1); // exit the program
        break;
      default:
        System.out.println("Not an option, please choose another one");
        break;
    }
  }
}
