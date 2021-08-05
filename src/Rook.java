import javax.swing.*;

public class Rook extends Piece {
    public Rook(boolean isBlackPlayer) {
        this.isBlackPlayer = isBlackPlayer;
        if(isBlackPlayer) {
            image = new ImageIcon("brook.gif");
        }
        else {
            image = new ImageIcon("wrook.gif");
        }
    }
}
