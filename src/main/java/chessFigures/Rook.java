package chessFigures;

import chessBoard.ChessBoard;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
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
        return "R";
    }
}
