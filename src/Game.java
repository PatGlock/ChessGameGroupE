//imports
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//main class to run for game
public class Game {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        List<Piece> board = initBoard();
        printGreeting();
        int turnCounter = 0;
        Boolean done = false;
        while (true){
            //void method that prints the turn number and whose turn based on the turn counter
            printTurn(turnCounter);
            while (true) {
                //validate the move within the getMove function
                Boolean c1 = getMove(board);
                //make sure you don't check yourself
                Boolean c2 = checkCheck();
                if (Objects.equals(c1, true)){
                    break;
                }
                System.out.println("Please enter a valid move");
            }
            //checkMate function
            Boolean c3 = checkMate();
            if (Objects.equals(c3, true)){
                break;
            }
            //display the move on the ASCII board
            displayMove();
            turnCounter++;

        }
        //include the option to play again
        displayEnd();

    }
    public static void printTurn(int turnCounter){
        if (turnCounter%2==0) {
            System.out.println("Whites turn to play");
            System.out.println("Turn "+turnCounter);
        } else {
            System.out.println("Blacks turn to play");
            System.out.println("Turn "+turnCounter);
        }

    }
    public static Boolean getMove(List<Piece> board){
        System.out.println("Please enter the space of the piece you wish to move");
        String pos = scan.nextLine();
        ArrayList<Integer> posi = setFormat(pos);
        System.out.println("Please enter where you'd like to move the piece");
        String dest = scan.nextLine();
        ArrayList<Integer> desti= setFormat(dest);
        List<Piece> tempBoard = movePiece(posi,desti,board);

        Boolean c2 = checkCheck();
        if(Boolean.TRUE.equals(c2)){
            board = tempBoard;
            return true;
        }
        System.out.println("Please enter a valid move");
        return false;
    }

    private static List<Piece> movePiece(ArrayList<Integer> posi, ArrayList<Integer> desti, List<Piece> board) {
        List<Piece> tempBoard =  board;
        //complete move
        //validate move
        //if move valid, output new board
        //else, output original board
        return tempBoard;
    }

    public static Boolean checkCheck(){

        return null;
    }

    /**
     * This creates the board as a list, using modulo 8 arithmetic to validate moves
     * @return
     */
    public static List<Piece> initBoard() {
        //  A board in which the blank pieces are a third color
        // Taken pieces will become color 0 with the Piece.setColor(0)
        List<Piece> board = new ArrayList<>();
        board.add(new Piece("rook",false,1,true));
        board.add(new Piece("knight",false,1,false));
        board.add(new Piece("bishop",false,1,false));
        board.add(new Piece("queen",false,1,false));
        board.add(new Piece("king",false,1,true));
        board.add(new Piece("bishop",false,1,false));
        board.add(new Piece("knight",false,1,false));
        board.add(new Piece("rook",false,1,true));
        for(int i=0;i<8;i++){
            board.add(new Piece("pawn",false,1,true));
        }
        for(int i=0;i<32;i++){
            board.add(new Piece("blank",false,0,false));
        }
        for(int i=0;i<8;i++){
            board.add(new Piece("pawn",false,2,true));
        }
        board.add(new Piece("rook",false,2,true));
        board.add(new Piece("knight",false,2,false));
        board.add(new Piece("bishop",false,2,false));
        board.add(new Piece("queen",false,2,false));
        board.add(new Piece("king",false,2,true));
        board.add(new Piece("bishop",false,2,false));
        board.add(new Piece("knight",false,2,false));
        board.add(new Piece("rook",false,2,true));
        return board;
    }

    public static void printGreeting(){
        System.out.println("Welcome to our chess engine!\n Please enter moves using chess board locations(a-g)(1-8)");
    }
    public static void displayMove(){

    }
    public static ArrayList<Integer> setFormat(String s){
        ArrayList<Integer> output = new ArrayList<>();
        var Starray = s.toCharArray();
        char newS1 = Starray[0];
        newS1 = switch (newS1) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            default -> 15;
        };
        char c = Starray[1];
        var tempS2 = (int) c;
        tempS2--;
        output.add((int) newS1);
        output.add(tempS2);
        return output;
    }
    public static Boolean checkMate(){
        return null;
    }
    public static void displayEnd(){

    }
}