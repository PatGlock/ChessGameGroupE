//imports
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//main class to run for game
public class Game {
    //private static final Display disp = new Display();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        List<Piece> board = initBoard();
        printGreeting();
        int turnCounter = 0;
        while (true){
            //void method that prints the turn number and whose turn based on the turn counter
            printTurn(turnCounter);
            while (true) {
                //validate the move within the getMove function
                Boolean c1 = getMove(board);
                if (Objects.equals(c1, true)){
                    break;
                }
            }
            //checkMate function
            Boolean c3 = checkMate();
            if (Objects.equals(c3, true)){
                break;
            }
            //display the move on the display
            //disp.displayMove(board);
            turnCounter++;

        }
        //include the option to play again
        displayEnd();

    }

    /**
     *
     * @param turnCounter
     */
    public static void printTurn(int turnCounter){
        if (turnCounter%2==0) {
            System.out.println("Whites turn to play");
            System.out.println("Turn "+turnCounter);
        } else {
            System.out.println("Blacks turn to play");
            System.out.println("Turn "+turnCounter);
        }

    }

    /**
     * This function takes the board, gathers and reformats the moves
     * Then applies the movePiece function
     * It returns a Boolean to make sure a move was made
     * @param board
     * @return
     */
    public static Boolean getMove(List<Piece> board){
        System.out.println("Please enter the space of the piece you wish to move");
        String pos = scan.nextLine();
        ArrayList<Integer> posi = setFormat(pos);
        System.out.println("Please enter where you'd like to move the piece");
        String dest = scan.nextLine();
        ArrayList<Integer> desti= setFormat(dest);
        List<Piece> tempBoard = movePiece(posi,desti,board);

        Boolean c2 = checkCheck(tempBoard);
        if(Boolean.TRUE.equals(c2)&& !tempBoard.equals(board)){
            board = tempBoard;
            return true;
        }
        System.out.println("Please enter a valid move");
        return false;
    }

    /**
     * This function attempts the move and sends back the board with the completed move if it's validated
     * Otherwise it returns the original board
     * Very rudementary and it doesn't check for collision yet(Todo)
     * @param posi
     * @param desti
     * @param board
     * @return
     */
    private static List<Piece> movePiece(ArrayList<Integer> posi, ArrayList<Integer> desti, List<Piece> board) {
        //create a copy of the board to test the move on
        List<Piece> tempBoard = board;
        int indexP = 8 * posi.get(1) + posi.get(0);
        Piece moved = tempBoard.get(indexP);
        int indexD = 8 * desti.get(1) + desti.get(0);
        String moveValid = moved.getPiece();
        //total move validation
        boolean isValid = false;
        //valid movement checker
        boolean destCheck = false;
        //collision checker
        boolean colCheck = false;
        switch (moveValid) {
            case "rook" -> {
                Boolean tempCheck1 = inRow(posi, desti);
                Boolean tempCheck2 = inColumn(posi, desti);
                if (tempCheck1 || tempCheck2) {
                    destCheck = true;
                }
                //todo
                colCheck = true;
                if (destCheck && colCheck) {
                    tempBoard = takePiece(tempBoard, indexP, indexD);
                    isValid = true;
                }
            }
            case "bishop" -> {
                Boolean tempCheck1 = inDiag(posi, desti);
                if (tempCheck1) {
                    destCheck = true;
                }
                //todo
                colCheck = true;
                if (destCheck && colCheck) {
                    tempBoard = takePiece(tempBoard, indexP, indexD);
                    isValid = true;
                }
            }
            case "queen" -> {
                Boolean tempCheck1 = inRow(posi, desti);
                Boolean tempCheck2 = inColumn(posi, desti);
                Boolean tempCheck3 = inDiag(posi, desti);
                if (tempCheck1 || tempCheck2 || tempCheck3) {
                    destCheck = true;
                }
                //todo
                colCheck = true;
                if (destCheck && colCheck) {
                    tempBoard = takePiece(tempBoard, indexP, indexD);
                    isValid = true;
                }
            }
            case "knight" -> {
                Boolean tempCheck1 = knightMove(posi, desti);
                if (tempCheck1) {
                    destCheck = true;
                }
                //todo
                colCheck = true;
                if (destCheck && colCheck) {
                    tempBoard = takePiece(tempBoard, indexP, indexD);
                    isValid = true;
                }
            }
            case "king" -> {
                destCheck = adjCheck(posi, desti);
                //todo
                colCheck = true;
                if (destCheck && colCheck) {
                    tempBoard = takePiece(tempBoard, indexP, indexD);
                    isValid = true;
                }
            }
            case "pawn" -> {
                destCheck = pawnCheck(tempBoard, indexP, indexD, posi, desti);
                //todo
                colCheck = true;
                if (destCheck && colCheck) {
                    tempBoard = takePiece(tempBoard, indexP, indexD);
                    isValid = true;
                }
            }
        }
        //complete move
        //validate move
        //if move valid, output new board
        //else, output original board
        if (!isValid) {
            tempBoard = board;
        }
        return tempBoard;
    }
        //todo - Takes the board and makes sure that the player did not put themselves in check
        public static Boolean checkCheck (List < Piece > tempBoard) {

            return true;
        }

        /// This creates the board as a list, using modulo 8 arithmetic to validate moves
        /// @return
        public static List<Piece> initBoard () {
            //  A board in which the blank pieces are a third color
            // Taken pieces will become color 0 with the Piece.setColor(0)
            List<Piece> board = new ArrayList<>();
            board.add(new Piece("rook", 1, true));
            board.add(new Piece("knight", 1, false));
            board.add(new Piece("bishop", 1, false));
            board.add(new Piece("queen", 1, false));
            board.add(new Piece("king", 1, true));
            board.add(new Piece("bishop", 1, false));
            board.add(new Piece("knight", 1, false));
            board.add(new Piece("rook", 1, true));
            for (int i = 0; i < 8; i++) {
                board.add(new Piece("pawn", 1, true));
            }
            for (int i = 0; i < 32; i++) {
                board.add(new Piece("blank", 0, false));
            }
            for (int i = 0; i < 8; i++) {
                board.add(new Piece("pawn", 2, true));
            }
            board.add(new Piece("rook", 2, true));
            board.add(new Piece("knight", 2, false));
            board.add(new Piece("bishop", 2, false));
            board.add(new Piece("queen", 2, false));
            board.add(new Piece("king", 2, true));
            board.add(new Piece("bishop", 2, false));
            board.add(new Piece("knight", 2, false));
            board.add(new Piece("rook", 2, true));
            return board;
        }
        /// Simple greeting
        public static void printGreeting () {
            System.out.println("Welcome to our chess engine!\n Please enter moves using chess board locations(a-h)(1-8)");
        }

        public static void displayMove () {

        }

    /**
     * Takes the move string and turns it into the usable integer array
     * @param s
     * @return
     */
    public static ArrayList<Integer> setFormat (String s){
            ArrayList<Integer> output = new ArrayList<>();
            char newS1 = s.charAt(0);
            newS1 = switch (newS1) {
                case 'a' -> 0;
                case 'b' -> 1;
                case 'c' -> 2;
                case 'd' -> 3;
                case 'e' -> 4;
                case 'f' -> 5;
                case 'g' -> 6;
                case 'h' -> 7;
                default -> 20;
            };
            int tempS2 = Integer.parseInt(String.valueOf(s.charAt(1)));
            tempS2 = tempS2-1;
            output.add((int) newS1);
            output.add(tempS2);
            return output;
        }

    /**
     * Checks for checkmate
     * unfinished
     * @return
     */
    public static Boolean checkMate () {
            return null;
        }

    /**
     * Displays an end message in the graphic
     * unfinished
     */
    public static void displayEnd () {
        }

    /**
     * Completes the process of switching the pieces and voiding the taken piece.
     * Could add a point counter in iterations
     * @param tempBoard
     * @param indexMoved
     * @param indexTaken
     * @return
     */
        private static List<Piece> takePiece (List < Piece > tempBoard,int indexMoved, int indexTaken) {
            tempBoard.set(indexTaken, tempBoard.get(indexMoved));
            tempBoard.set(indexMoved, Piece.empty);
            return tempBoard;
        }
    /**
     * Checks that the y values match in the position and destination
     * @param posi
     * @param desti
     * @return Boolean
     */
        private static Boolean inRow(ArrayList<Integer> posi, ArrayList<Integer> desti){
            return posi.get(0).equals(desti.get(0));
        }

    /**
     * Checks that the x values match in the position and destination
     * @param posi
     * @param desti
     * @return Boolean
     */
        private static Boolean inColumn(ArrayList<Integer> posi, ArrayList<Integer> desti){
            return posi.get(1).equals(desti.get(1));
        }

    /**
     * Checks that the squares(accounting for pos and neg values) of the difference are equal
     * This returns a boolean True if it is on a diagnal
     * @param posi
     * @param desti
     * @return Boolean
     */
        private static Boolean inDiag(ArrayList<Integer> posi, ArrayList<Integer> desti){
            int difX = (posi.get(0)-desti.get(0))^2;
            int difY = (posi.get(1)-desti.get(1))^2;
            if (difY!=0) {
                return difX == difY ;
            }
            return false;
        }

    /**
     *Checks that the squares add up to 5
     * Since the values are only integers,
     * the only combinations that would allow this are 2 in one direction and 1 in another
     * @param posi
     * @param desti
     * @return Boolean
     */
        private static Boolean knightMove(ArrayList<Integer> posi, ArrayList<Integer> desti){
            int difX = (posi.get(0)-desti.get(0))^2;
            int difY = (posi.get(1)-desti.get(1))^2;
            return difX + difY == 5;
        }

    /**
     * For the king, makes sure that it only goes 1 square
     * Castling in progress
     * @param posi
     * @param desti
     * @return Boolean
     */
        private static Boolean adjCheck(ArrayList<Integer> posi, ArrayList<Integer> desti){
            int difX = (posi.get(0)-desti.get(0))^2;
            int difY = (posi.get(1)-desti.get(1))^2;
            boolean corner = false;
            if (difX+difY==2&&inDiag(posi,desti)){
                corner = true;
            }
            return difX + difY == 1 || corner;
            //todo: Castling
        }

    /**
     * Checks that the pawn only moves 1(for now)
     * and only goes diagonal if there is a piece to take
     * @param tempBoard
     * @param indexP
     * @param indexD
     * @param posi
     * @param desti
     * @return Boolean
     */
        private static boolean pawnCheck(List<Piece> tempBoard,int indexP,int indexD,ArrayList<Integer> posi, ArrayList<Integer> desti ){
            boolean check1 = false;
            boolean check2 = false;
            //Make sure the pawn is moving in the correct direction
            if(Objects.equals(tempBoard.get(indexP).getColor(),1)){
                if(desti.get(0)-posi.get(0)==1){check1 =true;}
            } else{
                if(posi.get(0)-desti.get(0)==1) {check1 = true;}
            }
            //In the case where it is moving diagonally, make sure there is something there to capture
            if(inDiag(posi,desti)){
                if(!Objects.equals(tempBoard.get(indexD).getPiece(),"blank")&&!Objects.equals(tempBoard.get(indexD).getColor(),tempBoard.get(indexP).getColor())){check2= true;}
            }else{ //in the case where it is moving straight, make sure there is nothing in the way
                if(Objects.equals(tempBoard.get(indexD).getPiece(),"blank")){check2 = true;}
            }
            //todo: En Passant, Promoting, and double forward
            return check1 && check2;
        }
}
