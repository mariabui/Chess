import javax.swing.*;

public class Knight extends Piece {
    public Knight(boolean pieceColor) {
        super(pieceColor);
        if(isBlackPlayer) {
            image = new ImageIcon("bknight.gif");
        }
        else {
            image = new ImageIcon("wknight.gif");
        }
    }

    public boolean canMove(int sx, int sy, int ex, int ey) {
        // must move in an L shape - that is, 2 squares horizontally and 1 square vertically, or 2 squares vertically and 1 horizontally
        if(Math.abs(sx-ex)==2 && Math.abs(sy-ey)==1) {
            return true;
        }
        else if(Math.abs(sy-ey)==2 && Math.abs(sx-ex)==1) {
            return true;
        }
        return false;
    }
}
