import javax.swing.*;

public class Rook extends Piece {
    public Rook(boolean pieceColor) {
        super(pieceColor);
        if(isBlackPlayer) {
            image = new ImageIcon("brook.gif");
        }
        else {
            image = new ImageIcon("wrook.gif");
        }
    }

    public boolean canMove(int sx, int sy, int ex, int ey) {
        // can move any number of spaces horizontally or vertically
            // vertically upwards
        if(sy>ey) {
            for (int y=sy-1; y>ey; y--) {
                // can't jump over pieces
                if(Chess.position[sx][y]!=null) {
                    return false;
                }
            }
        }
            // vertically downwards
        else if(sy<ey) {
            for (int y=sy+1; y<ey; y++) {
                if (Chess.position[sx][y]!=null) {
                    return false;
                }
            }
        }
            // horizontally to the left
        else if(sx>ex) {
            for (int x=sx-1; x>ex; x--) {
                if (Chess.position[x][ey]!=null) {
                    return false;
                }
            }
        }
            // horizontally to the right
        else if(sx<ex) {
            for (int x=sx+1; x<ex; x++) {
                if (Chess.position[x][ey]!=null) {
                    return false;
                }
            }
        }
        if(sy==ey || sx==ex) {
            return true;
        }
        return false;
    }
}
