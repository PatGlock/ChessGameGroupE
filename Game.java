import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        initBoard();
        printGreeting();
        int turnCounter = 0;
        Boolean done = false;
        while (done.equals(false)){
            //void method that prints the turn number and whose turn based on the turn counter
            printTurn();
            while (true) {
                //validate the move within the getMove function
                Boolean c1 = getMove();
                //make sure you don't check yourself
                Boolean c2 = checkCheck();
                if (c1.equals(true)&&c2.equals(true)){
                    break;
                }
                System.out.println("Please enter a valid move");
            }
            //checkMate function
            if (checkMate().equals(true)){
                break;
            }
            //display the move on the ASCII board
            displayMove();
            turnCounter++;

        }
        //include the option to play again
        displayEnd();

    }
    public static void printTurn(){

    }
    public static Boolean getMove(){

        return null;
    }
    public static Boolean checkCheck(){

        return null;
    }
    public static void initBoard() {
      //  ArrayList Piece board= []  ;
    }

    public static void printGreeting(){
        System.out.println("Welcome to our chess engine!\n Please enter moves in the format a2->a3");
    }
    public static void displayMove(){

    }
    public static Boolean checkMate(){
        return null;
    }
    public static void displayEnd(){

    }

}