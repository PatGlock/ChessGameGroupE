import java.util.List;
// I'll make the current player a parameter
public static Boolean checkCheck(){
    List<Piece> board = Game.initBoard();
    int kingIndex = -1;
    int playerColor = -1;

    // Find the current player's king
    for (int i = 0; i < board.size(); i++) {
        Piece p = board.get(i);
        if (p.getType().equals("king") && p.getColor() != 0) {
            kingIndex = i;
            playerColor = p.getColor();
            break;
    //iterate through opposite sides pieces and see if taking king is a valid move
    //if true, return false
    //if finishes the loop and finds nothing, return true
        }
    }
