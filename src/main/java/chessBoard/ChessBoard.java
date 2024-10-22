package chessBoard;

import chessFigures.ChessPiece;
import chessFigures.King;
import chessFigures.Rook;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    private boolean checkKingUnderAttack() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece figure = getFigureOnPosition(i, j);
                if (figure instanceof King && figure.getColor().equals(nowPlayer)) {
                    return ((King) figure).isUnderAttack(this, i, j);
                }
            }
        }
        return false;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn) && checkPos(endLine) && checkPos(endColumn)) {
            ChessPiece figure = board[startLine][startColumn];
            ChessPiece figureUnderAttack = board[endLine][endColumn];

            if (!nowPlayer.equals(figure.getColor())) return false;

            if (figureUnderAttack != null && nowPlayer.equals(figureUnderAttack.getColor())) return false;

            if (!(figure instanceof King) && checkKingUnderAttack()) return false;

            if (figure.canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                if (figure instanceof King || figure instanceof Rook) {
                    figure.check = false;
                }
                board[endLine][endColumn] = figure; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");

        for (int i = 7; i > -1; i--) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling0() {
        int line = nowPlayer.equals("White") ? 0 : 7;
        nowPlayer = nowPlayerColor().equals("White") ? "Black" : "White";
        ChessPiece king = board[line][4];
        ChessPiece rook = board[line][0];
        if (
                king instanceof King
                && king.check
                && rook instanceof Rook
                && rook.check
                && board[line][1] == null
                && board[line][2] == null
                && board[line][3] == null
        ) {
            board[line][2] = king;
            board[line][3] = rook;
            board[line][4] = null;
            board[line][0] = null;
            king.check = false;
            return true;
        }
        return false;
    }

    public boolean castling7() {
        int line = nowPlayer.equals("White") ? 0 : 7;
        nowPlayer = nowPlayerColor().equals("White") ? "Black" : "White";
        ChessPiece king = board[line][4];
        ChessPiece rook = board[line][7];
        if (
                king instanceof King
                && king.check
                && rook instanceof Rook
                && rook.check
                && board[line][5] == null
                && board[line][6] == null
        ) {
            board[line][6] = king;
            board[line][5] = rook;
            board[line][4] = null;
            board[line][7] = null;
            king.check = false;
            return true;
        }
        return false;
    }

    public ChessPiece getFigureOnPosition(int line, int column) {
        return board[line][column];
    }
}
