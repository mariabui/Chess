import javax.swing.*;

public class Queen extends Piece {
    public Queen(boolean pieceColor) {
        super(pieceColor);
        if(isBlackPlayer) {
            image = new ImageIcon("bqueen.gif");
        }
        else {
            image = new ImageIcon("wqueen.gif");
        }
    }

    public boolean canMove(int sx, int sy, int ex, int ey) {
        // can move any number of spaces in any specific direction - horizontally, vertically, or diagonally
            // diagonally (bishop)
        if (sx>ex && sy>ey) {
            for (int x=sx-1, y=sy-1; x>ex && y>ey; x--, y--) {
                if (Chess.position[x][y]!=null) {
                    return false;
                }
            }
        }
        else if (sx<ex && sy<ey) {
            for (int x=sx+1, y=sy+1; x<ex && y<ey; x++, y++) {
                if (Chess.position[x][y]!=null) {
                    return false;
                }
            }
        }
        else if (sx<ex && sy>ey) {
            for (int x=sx+1, y=sy-1; x<ex && y>ey; x++, y--) {
                if (Chess.position[x][y]!=null) {
                    return false;
                }
            }
        }
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
            // horizontally, vertically (rook)
        if(sy>ey) {
            for (int y=sy-1; y>ey; y--) {
                if(Chess.position[sx][y]!=null) {
                    return false;
                }
            }
        }
        else if(sy<ey) {
            for (int y=sy+1; y<ey; y++) {
                if (Chess.position[sx][y]!=null) {
                    return false;
                }
            }
        }
        else if(sx>ex) {
            for (int x=sx-1; x>ex; x--) {
                if (Chess.position[x][ey]!=null) {
                    return false;
                }
            }
        }
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
