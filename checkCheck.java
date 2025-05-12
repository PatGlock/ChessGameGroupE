import java.util.List;
// Edited code - 5/11
public static Boolean checkCheck(List<Piece> tempBoard) {
        int kingIndex = -1;
        int playerColor = -1;

        // Step 1: Find the player's king
        for (int i = 0; i < tempBoard.size(); i++) {
            Piece p = tempBoard.get(i);
            if (p.getPiece().equals("king") && p.getColor() != 0) {
                kingIndex = i;
                playerColor = p.getColor();
                break;
            }
        }

        if (kingIndex == -1) {
            System.out.println("Error: King not found.");
            return false;
        }

        ArrayList<Integer> kingPos = new ArrayList<>();
        kingPos.add(kingIndex % 8); // x
        kingPos.add(kingIndex / 8); // y

        // Step 2: Loop through enemy pieces and see if any can reach the king
        for (int i = 0; i < tempBoard.size(); i++) {
            Piece attacker = tempBoard.get(i);
            if (attacker.getColor() != 0 && attacker.getColor() != playerColor) {
                ArrayList<Integer> attackerPos = new ArrayList<>();
                attackerPos.add(i % 8); // x
                attackerPos.add(i / 8); // y

                int indexA = i;
                int indexK = kingIndex;

                switch (attacker.getPiece()) {
                    case "rook" -> {
                        if ((inRow(attackerPos, kingPos) || inColumn(attackerPos, kingPos))) {
                            return true;
                        }
                    }
                    case "bishop" -> {
                        if (inDiag(attackerPos, kingPos)) {
                            return true;
                        }
                    }
                    case "queen" -> {
                        if (inRow(attackerPos, kingPos) || inColumn(attackerPos, kingPos) || inDiag(attackerPos, kingPos)) {
                            return true;
                        }
                    }
                    case "knight" -> {
                        if (knightMove(attackerPos, kingPos)) {
                            return true;
                        }
                    }
                    case "king" -> {
                        if (adjCheck(attackerPos, kingPos)) {
                            return true;
                        }
                    }
                    case "pawn" -> {
                        if (pawnCheck(tempBoard, indexA, indexK, attackerPos, kingPos)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false; // No threats to king
    }
