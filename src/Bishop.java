import javax.swing.*;

public class Bishop extends Piece {
    public Bishop(boolean isBlackPlayer) {
        this.isBlackPlayer = isBlackPlayer;
        if(isBlackPlayer) {
            image = new ImageIcon("bbishop.gif");
        }
        else {
            image = new ImageIcon("wbishop.gif");
        }
    }
}
