import javax.swing.*;
import java.awt.*;

public abstract class Piece {
    protected ImageIcon image;
    protected boolean isBlackPlayer = true;

    public boolean canMove() {
        return true;
    }
}
