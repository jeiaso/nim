import java.util.Random;

public class Board {
    private static int numPieces;

    public Board(){
    
    }

    public static int getNumPieces(){
        return numPieces;
    }

    public static int randomize(){
        //new Random().nextInt(max - min + 1) + min
        int random = new Random().nextInt(50-20+1)+20;
        return random;
    }
    
    public static void populate(){
        numPieces = randomize();
    }

    public static void removePieces(int pieces){
        numPieces -= pieces;
    }
}
