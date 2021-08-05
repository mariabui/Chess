import javax.swing.*;

public class Queen extends Piece {
    public Queen(boolean isBlackPlayer) {
        this.isBlackPlayer = isBlackPlayer;
        if(isBlackPlayer) {
            image = new ImageIcon("bqueen.gif");
        }
        else {
            image = new ImageIcon("wqueen.gif");
        }
    }
}
