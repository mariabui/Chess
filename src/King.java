import javax.swing.*;

public class King extends Piece {
    public King(boolean isBlackPlayer) {
        this.isBlackPlayer = isBlackPlayer;
        if(isBlackPlayer) {
            image = new ImageIcon("bking.gif");
        }
        else {
            image = new ImageIcon("wking.gif");
        }
    }
}
