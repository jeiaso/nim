import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player p1;
    private Player p2;
    private Player computer;
    private Player singlePlayer;
    private Board board;
    private boolean stillPlaying = true;
    private boolean inGame = true;
    private int turnNum;
    private boolean typing = false;

// Constructor for a new game with two players. 
    public Game(){
        System.out.println("Enter Player 1 name: ");
        p1 = new Player();
        System.out.println("Enter Player 2 name: ");
        p2 = new Player();
        Board board;
        computer = new Player("Computer");
    }

    // function used to randomize who goes first in a game

    public void randomizeFirst(){
        int random = new Random().nextInt(2-1+1)+1;
        if (random % 2 == 0){
            turnNum = 1;
        }
        else{
            turnNum = 0;
        }
    }

// plays the game 

    public void play(){
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to try single player mode?");
        String mode = s.nextLine();
        if (mode.equals("yes") || mode.equals("y")){
                inGame = true;
                System.out.println("Which player wants to play against the computer?");
                boolean unknown = true;
                while (unknown){
                    String single = s.nextLine();
                    if (single.equals(p1.getName())){
                        singlePlayer = p1;
                        unknown = false;
                    }
                    else if (single.equals(p2.getName())){
                        singlePlayer = p2;
                        unknown = false;
                    }
                    else{
                        System.out.println("That isn't one of the players");
                    }
                }
            while(stillPlaying){
                randomizeFirst();
                System.out.println("Welcome to a new game!");
                while(inGame == true){
                    System.out.println("___________________________________________________________");
                    System.out.println("There are " + Board.getNumPieces() + " pieces on the board.");
                    System.out.println("___________________________________________________________");
                    if (turnNum % 2 == 0){ 
                        System.out.println("Computer's turn");
                        int random = new Random().nextInt((Board.getNumPieces()/2)-1+1)+1;
                        Board.removePieces(random);
                        System.out.println("The computer took " + random + " pieces");
                        turnNum++;
                        if (Board.getNumPieces() == 1){
                            inGame = false;
                            if (turnNum % 2 == 0){ 
                                System.out.println(singlePlayer.getName() + " Wins");
                                singlePlayer.setScore(1);
                            }
                            else{
                                System.out.println("Computer Wins");
                                computer.setScore(1);
                            }
                        }
                        
                    }
                    else{
                        System.out.println(singlePlayer.getName() + "'s turn");
                    
                    System.out.println("How many pieces would you like to take?");
                    String pt = s.nextLine();
                    int ptInt = Integer.parseInt(pt);
                    if (ptInt > Board.getNumPieces()/2){
                        System.out.println("Please only enter numbers equal to or less than half the number of pieces on the board");
                        typing = true;
                    }
                    while(typing){
                        pt = s.nextLine();
                        ptInt = Integer.parseInt(pt);
                        if (ptInt <= Board.getNumPieces()/2){
                            typing = false;
                        }
                        else{
                            System.out.println("Please only enter numbers equal to or less than half the number of pieces on the board");
                        }
                    }
                    Board.removePieces(ptInt);
                    turnNum++;
                
                    if (Board.getNumPieces() == 1){
                        inGame = false;
                        if (turnNum % 2 == 0){ 
                            System.out.println(singlePlayer.getName() + " Wins");
                            singlePlayer.setScore(1);
                        }
                        else{
                            System.out.println("Computer Wins");
                            computer.setScore(1);
                        }
                    }
                }
             }

                // text displayed after game is over
                System.out.println("___________________________________________________________");
                System.out.println(singlePlayer.getName() + " has " + singlePlayer.getPoints() + " wins");
                System.out.println(computer.getName() + " has " + computer.getPoints() + " wins");
                System.out.println("___________________________________________________________");
                System.out.println("Would you like to play again? (type \"y\" or \"yes\" to accept)");
                String rsp = s.nextLine();

                // if wants to play again, plays again but if doesn't want to play again, ends the code
                if (rsp.equals("yes") || rsp.equals("y")){
                    inGame = true;
                    Board.populate();
                }
                else{
                    stillPlaying = false;
                }
            }
         }
        else{
        inGame = true;
            while(stillPlaying){
                randomizeFirst();
                System.out.println("Welcome to a new game!");
                while(inGame == true){
                    System.out.println("___________________________________________________________");
                    System.out.println("There are " + Board.getNumPieces() + " pieces on the board.");
                    System.out.println("___________________________________________________________");
                    if (turnNum % 2 == 0){ 
                        System.out.println(p1.getName() + "'s turn");

                        
                    }
                    else{
                        System.out.println(p2.getName() + "'s turn");
                    }
                    System.out.println("How many pieces would you like to take?");
                    String pt = s.nextLine();
                    int ptInt = Integer.parseInt(pt);
                    if (ptInt > Board.getNumPieces()/2){
                        System.out.println("Please only enter numbers equal to or less than half the number of pieces on the board");
                        typing = true;
                    }
                    while(typing){
                        pt = s.nextLine();
                        ptInt = Integer.parseInt(pt);
                        if (ptInt <= Board.getNumPieces()/2){
                            typing = false;
                        }
                        else{
                            System.out.println("Please only enter numbers equal to or less than half the number of pieces on the board");
                        }
                    }
                    Board.removePieces(ptInt);
                    turnNum++;
                    if (Board.getNumPieces() == 1){
                        inGame = false;
                        if (turnNum % 2 == 0){ 
                            System.out.println(p2.getName() + " Wins");
                            p2.setScore(1);
                            
                        }
                        else{
                            System.out.println(p1.getName() + " Wins");
                            p1.setScore(1);
                        }
                    }
                }

                // text displayed after game is over
                System.out.println("___________________________________________________________");
                System.out.println(p1.getName() + " has " + p1.getPoints() + " wins");
                System.out.println(p2.getName() + " has " + p2.getPoints() + " wins");
                System.out.println("___________________________________________________________");
                System.out.println("Would you like to play again? (type \"y\" or \"yes\" to accept)");
                String rsp = s.nextLine();

                // if wants to play again, plays again but if doesn't want to play again, ends the code
                if (rsp.equals("yes") || rsp.equals("y")){
                    inGame = true;
                    Board.populate();
                }
                else{
                    stillPlaying = false;
                }
            }
        }
        


    }

}