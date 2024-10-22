package chessFigures;

import chessBoard.ChessBoard;

import java.lang.Math;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        ChessPiece figureUnderAttack = chessBoard.getFigureOnPosition(toLine, toColumn);
        int[] moveVector = {toLine - line, toColumn - column};
        if (color.equals("White")) {
            if (line == 1 && moveVector[0] == 2 && moveVector[1] == 0 && figureUnderAttack == null){
                return true;
            }
            if (moveVector[0] == 1 && moveVector[1] == 0 && figureUnderAttack == null){
                return true;
            }
            if (moveVector[0] == 1 && Math.abs(moveVector[1]) == 1 && figureUnderAttack != null){
                return true;
            }
        }
        if (color.equals("Black")) {
            if (line == 6 && moveVector[0] == -2 && moveVector[1] == 0 && figureUnderAttack == null){
                return true;
            }
            if (moveVector[0] == -1 && moveVector[1] == 0 && figureUnderAttack == null){
                return true;
            }
            if (moveVector[0] == -1 && Math.abs(moveVector[1]) == 1 && figureUnderAttack != null){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
