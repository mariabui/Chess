import javax.swing.*;

public class Knight extends Piece {
    public Knight(boolean isBlackPlayer) {
        this.isBlackPlayer = isBlackPlayer;
        if(isBlackPlayer) {
            image = new ImageIcon("bknight.gif");
        }
        else {
            image = new ImageIcon("wknight.gif");
        }
    }
}
