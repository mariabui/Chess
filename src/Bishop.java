import javax.swing.*;

public class Bishop extends Piece {
    public Bishop(boolean pieceColor) {
        super(pieceColor);
        if(isBlackPlayer) {
            image = new ImageIcon("bbishop.gif");
        }
        else {
            image = new ImageIcon("wbishop.gif");
        }
    }

    public boolean canMove(int sx, int sy, int ex, int ey) {
        // can move any number of spaces diagonally
            // top left
        if (sx>ex && sy>ey) {
            for (int x=sx-1, y=sy-1; x>ex && y>ey; x--, y--) {
                if (Chess.position[x][y]!=null) {
                    return false;
                }
            }
        }
            // bottom right
        else if (sx<ex && sy<ey) {
            for (int x=sx+1, y=sy+1; x<ex && y<ey; x++, y++) {
                if (Chess.position[x][y]!=null) {
                    return false;
                }
            }
        }
            // top right
        else if (sx<ex && sy>ey) {
            for (int x=sx+1, y=sy-1; x<ex && y>ey; x++, y--) {
                if (Chess.position[x][y]!=null) {
                    return false;
                }
            }
        }
            // bottom left
        else if (sx>ex && sy<ey) {
            for (int x=sx-1, y=sy+1; x>ex && y<ey; x--, y++) {
                if (Chess.position[x][y]!=null) {
                    return false;
                }
            }
        }
        if(Math.abs(sx-ex)==Math.abs(sy-ey)) {
            return true;
        }
        return false;
    }
}
