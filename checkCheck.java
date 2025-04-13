import java.util.List;

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
        }
    }