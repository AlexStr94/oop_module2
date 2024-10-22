package chessFigures;

import chessBoard.ChessBoard;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int[] moveVector = {toLine - line, toColumn - column};
        if (Math.abs(moveVector[0]) == Math.abs(moveVector[1])) {
            for (int i = 1; i < Math.abs(line - toLine); i++) {
                int interLine = line < toLine? line + i : line - i;
                int interColumn = column < toColumn? column + i : column - i;
                if (chessBoard.getFigureOnPosition(interLine, interColumn) != null) {
                    return false;
                }
            }
            return true;
        }
        if (line == toLine && column != toColumn) {
            if (column < toColumn) {
                for (int i = column + 1; i < toColumn; i++) {
                    if (chessBoard.getFigureOnPosition(line, i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = column - 1; i > toColumn; i--) {
                    if (chessBoard.getFigureOnPosition(line, i) != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (line != toLine && column == toColumn) {
            if (line < toLine) {
                for (int i = line + 1; i < toLine; i++){
                    if (chessBoard.getFigureOnPosition(i, column) != null){
                        return false;
                    }
                }
            } else {
                for (int i = line - 1; i > toLine; i--){
                    if (chessBoard.getFigureOnPosition(i, column) != null){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
