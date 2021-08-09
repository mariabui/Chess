// Maria Bui

import javax.swing.*;

public class Pawn extends Piece {
    boolean isFirstMove = true;

    public Pawn(boolean pieceColor) {
        super(pieceColor);
        if(isBlackPlayer) {
            image = new ImageIcon("bpawn.gif");
        }
        else {
            image = new ImageIcon("wpawn.gif");
        }
    }

    public boolean canMove(int sx, int sy, int ex, int ey) {
        // Must move 1 square forward
            // up for white
        if(!Chess.position[sx][sy].isBlackPlayer) {
            if(sx==ex && sy-ey==1 && Chess.position[ex][ey]==null) {
                isFirstMove = false;
                return true;
            }
            // the first move can be 2 spaces forward and cannot jump over pieces
            else if(sx==ex && sy-ey==2 && Chess.position[ex][ey]==null && Chess.position[sx][sy-1]==null && isFirstMove) {
                isFirstMove = false;
                return true;
            }
            // capture one square forward-diagonally
            else if((sx-ex==1 || sx-ex==-1) && sy-ey==1 && Chess.position[ex][ey]!=null) {
                if(Chess.position[ex][ey].isBlackPlayer) {
                    isFirstMove = false;
                    return true;
                }
            }
        }
            // down for black
        if(Chess.position[sx][sy].isBlackPlayer) {
            if (sx==ex && sy-ey==-1 && Chess.position[ex][ey]==null) {
                isFirstMove = false;
                return true;
            }
            // the first move can be 2 spaces forward and cannot jump over pieces
            else if (sx==ex && sy-ey==-2 && Chess.position[ex][ey]==null && Chess.position[sx][sy+1]==null && isFirstMove) {
                isFirstMove = false;
                return true;
            }
            // capture one square forward-diagonally
            else if ((sx-ex==1 || sx-ex==-1) && sy-ey==-1 && Chess.position[ex][ey]!=null) {
                if (!Chess.position[ex][ey].isBlackPlayer) {
                    isFirstMove = false;
                    return true;
                }
            }
        }
        return false;
    }
}
