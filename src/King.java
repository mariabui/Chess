import javax.swing.*;

public class King extends Piece {
    public King(boolean pieceColor) {
        super(pieceColor);
        if(isBlackPlayer) {
            image = new ImageIcon("bking.gif");
        }
        else {
            image = new ImageIcon("wking.gif");
        }
    }

    public boolean canMove(int sx, int sy, int ex, int ey) {
        // can move one space in any direction
        if(sx-ex>=-1 && sx-ex<=1) {
            if(sy-ey>=-1 && sy-ey<=1) {
                return true;
            }
        }
        return false;
    }

}
