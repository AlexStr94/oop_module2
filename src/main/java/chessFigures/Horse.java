package chessFigures;

import chessBoard.ChessBoard;

public class Horse  extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int[] moveVector = {toLine - line, toColumn - column};
        return Math.abs(moveVector[0]) == 1 && Math.abs(moveVector[1]) == 2
               || Math.abs(moveVector[0]) == 2 && Math.abs(moveVector[1]) == 1;

    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
