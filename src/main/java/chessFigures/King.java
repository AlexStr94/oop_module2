package chessFigures;

import chessBoard.ChessBoard;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                ChessPiece figure = chessBoard.getFigureOnPosition(i, j);
                if (
                        figure != null
                        && !figure.getColor().equals(color)
                        && (i != line && j != column)
                        && figure.canMoveToPosition(chessBoard, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int[] moveVector = {toLine - line, toColumn - column};
        return Math.abs(moveVector[0]) == 1
               && Math.abs(moveVector[1]) == 1
               && !isUnderAttack(chessBoard, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
