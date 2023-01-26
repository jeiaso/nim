/*
 * Activity 2.5.11
 * 
 * A Player class for the Nim Game
 */
import java.util.Scanner;

public class Player
{

  /* your code here - attributes */

  private String name;
  private int points;

  /* your code here - constructor(s) */ 

  public Player(){
    Scanner s = new Scanner(System.in);
    String newName = s.nextLine();
    name = newName;
    System.out.println("Welcome to the game, " + name + ".");
    points = 0;
  }

  public Player(String inputName){
    name = inputName;
    points = 0;
  }

  /* your code here - accessor(s) */ 

  public double getPoints(){
    return points;
  }

  public String getName(){
    return name;
  }

  /* your code here - mutator(s) */ 

  public void setScore(int pointAmount){
    points += pointAmount;
  }
}