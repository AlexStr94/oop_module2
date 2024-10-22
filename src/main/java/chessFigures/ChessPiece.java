package chessFigures;

import chessBoard.ChessBoard;

public abstract class ChessPiece {
    String color;
    public boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

}
